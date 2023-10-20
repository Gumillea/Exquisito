package com.gumillea.exquisito.core.util;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.ExquisitoConfig;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.gumillea.exquisito.core.util.tags.ExquisitoBlockTags;
import com.gumillea.exquisito.core.util.tags.ExquisitoEntityTypeTags;
import com.teamabnormals.neapolitan.core.Neapolitan;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanMobEffectTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Exquisito.MODID)
public class ExquisitoEvents {
    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        LevelAccessor world = target.getLevel();
        float health = target.getHealth();
        float damage = event.getAmount();
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            //Resonance Effects
            if (attacker.getEffect(ExquisitoEffects.RESONANCE.get()) != null
                    && !target.getType().is(ExquisitoEntityTypeTags.RESONANCE_IMMUNE)) {
                EntityTeleportEvent targetevent = new EntityTeleportEvent(target, attacker.getX(), attacker.getY(), attacker.getZ());
                EntityTeleportEvent attackerevent = new EntityTeleportEvent(attacker, target.getX(), target.getY(), target.getZ());
                if (target.isPassenger() || (attacker.isPassenger())) {
                        target.stopRiding();
                        attacker.stopRiding();
                }
                target.teleportTo(targetevent.getTargetX(), targetevent.getTargetY(), targetevent.getTargetZ());
                attacker.teleportTo(attackerevent.getTargetX(), attackerevent.getTargetY(), attackerevent.getTargetZ());
                target.resetFallDistance();
                attacker.resetFallDistance();
                target.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                attacker.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }
            //Modulation Effects 1
            if (attacker.getEffect(ExquisitoEffects.MODULATION.get()) != null) {
                int m_d = attacker.getEffect(ExquisitoEffects.MODULATION.get()).getDuration();
                int m_a = attacker.getEffect(ExquisitoEffects.MODULATION.get()).getAmplifier();
                if (attacker.getRandom().nextFloat() <= 0.5F) {
                    attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, m_d * 2, m_a));
                } else {
                    event.setAmount(damage * (1.0F + (m_a + 1) * 0.3F));
                }
                attacker.playSound(SoundEvents.MUD_BREAK, 1.5F, 1.5F);
                attacker.removeEffect(ExquisitoEffects.MODULATION.get());
            }
        }
        //Fuchsia Goo Effect
        if (target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
            MobEffectInstance fg1 = target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get());
            target.playSound(SoundEvents.SLIME_BLOCK_HIT, 1.5F, 1.5F);
            if (event.getSource() != DamageSource.OUT_OF_WORLD && event.getSource() != DamageSource.STARVE) {
                if (fg1.getAmplifier() < 5) {
                    event.setAmount(damage - damage * ((fg1.getAmplifier() + 1) * 0.2F));
                } else {
                    event.setAmount(0);
                }
            }
            if (event.getSource().getDirectEntity() instanceof LivingEntity attacker) {
                if (!attacker.getType().is(ExquisitoEntityTypeTags.FUCHSIA_GOO_IMMUNE)) {
                    if (attacker.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
                        MobEffectInstance fg2 = attacker.getEffect(ExquisitoEffects.FUCHSIA_GOO.get());
                        if (fg1.getDuration() >= fg2.getDuration()) {
                            attacker.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), fg1.getDuration(), fg1.getAmplifier() + fg2.getAmplifier() + 1));
                        } else {
                            attacker.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), fg2.getDuration(), fg1.getAmplifier() + fg2.getAmplifier() + 1));
                        }
                    } else {
                        attacker.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), fg1.getDuration(), fg1.getAmplifier() + 1));
                    }
                    target.removeEffect(ExquisitoEffects.FUCHSIA_GOO.get());
                } else {
                    target.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), fg1.getDuration(), fg1.getAmplifier() + 1));
                }
            }
        }
        //Space Diving Effect
        if (event.getSource() == DamageSource.FALL && target.getEffect(ExquisitoEffects.SPACE_DIVING.get()) != null) {
            int amplifier = target.getEffect(ExquisitoEffects.SPACE_DIVING.get()).getAmplifier() + 1;
            float fallDistance = target.fallDistance;
            for (LivingEntity targets : world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector((livingEntity) -> livingEntity != target),
                    target, target.getBoundingBox().inflate(target.getBbWidth() + amplifier * 6.0D + fallDistance * 0.15D, target.getBbHeight() * 2.0D, target.getBbWidth() + amplifier * 6.0D + fallDistance * 0.15D))) {
                if (fallDistance < 10 && ExquisitoConfig.Common.SPACE_DIVING_LIMITATION.get()) {
                    targets.playSound(SoundEvents.WARDEN_SONIC_BOOM, 0.3F, 3.5F);
                    targets.hurt(DamageSource.explosion(target), (fallDistance * (0.25F + amplifier * 0.15F)));
                    targets.push(0, 0.4D, 0);
                } else {
                    targets.playSound(SoundEvents.WARDEN_SONIC_BOOM, 0.3F, 3.5F);
                    targets.hurt(DamageSource.explosion(target), (fallDistance * (0.5F + amplifier * 0.15F)));
                    targets.push(0, 0.6D, 0);
                    targets.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40 + (amplifier * 20)));
                }
            }
            if (damage >= health) {
                if (target instanceof Player && ExquisitoConfig.Client.SPACE_DIVING_SFX.get()) {
                    Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(ExquisitoItems.SPACE_DIVING_ICON.get()));
                }
                target.playSound(SoundEvents.TOTEM_USE, 0.3F, 3.5F);
                event.setAmount(health * 0.9F);
            }
            target.removeEffect(ExquisitoEffects.SPACE_DIVING.get());
        }
        //Modulation Effects 2
        if (target.getEffect(ExquisitoEffects.MODULATION.get()) != null) {
            int m_d = target.getEffect(ExquisitoEffects.MODULATION.get()).getDuration();
            int m_a = target.getEffect(ExquisitoEffects.MODULATION.get()).getAmplifier();
            if (event.getSource() == DamageSource.OUT_OF_WORLD && target.getY() < world.getMinBuildHeight()) {
                target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, m_d, 9 + m_a));
            } else if (event.getSource() == DamageSource.LAVA || event.getSource() == DamageSource.ON_FIRE)  {
                target.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, m_d * 2, m_a));
            } else if (target.getHealth() / target.getMaxHealth() <= 0.5F) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, m_d / 2, 2 + m_a));
            } else {
                target.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, m_d * 2, m_a));
            }
            target.playSound(SoundEvents.MUD_BREAK, 1.5F, 1.5F);
            target.removeEffect(ExquisitoEffects.MODULATION.get());
        }

    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        if (target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null && ExquisitoConfig.Common.FUCHSIA_GOO_SPREAD.get()) {
            generateEnnegels(target.getLevel(), target);
        }
    }

    public static void generateEnnegels(Level world, LivingEntity entity) {
        List<Block> plants = Arrays.asList(
                ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModCompat.EED, "ennegel_fern")),
                ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModCompat.EED, "indigo_sprouts")),
                ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModCompat.EED, "indigo_roots")),
                ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModCompat.EED, "springleaf"))
        );
        int amplifier = entity.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()).getAmplifier() + 1;

        Collection<LivingEntity> effectrange = world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector((living) -> living != entity),
                entity, entity.getBoundingBox().inflate(4.0D, entity.getBbHeight() * 2.0D, 4.0D));
        for (LivingEntity targets : effectrange) {
            int duration = entity.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()).getDuration() / effectrange.size();
            if (targets.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
                MobEffectInstance fg = targets.getEffect(ExquisitoEffects.FUCHSIA_GOO.get());
                targets.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), fg.getDuration() + duration, fg.getAmplifier() + amplifier));
            } else {
                targets.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), duration, amplifier - 1));
            }
        }
        for (int i = 0; i < 16 + amplifier * 2; ++i) {
            double x = entity.getX() + (entity.getRandom().nextDouble() - 0.5D) * 8.0D;
            double y = entity.getY();
            double z = entity.getZ() + (entity.getRandom().nextDouble() - 0.5D) * 8.0D;
            for (int i2 = 0; i2 < 8; ++i2) {
                BlockPos pos = new BlockPos(x, y, z);
                BlockPos pos2 = new BlockPos(pos.above(1));
                BlockState blockstate = world.getBlockState(pos);
                BlockState blockstate2 = world.getBlockState(pos2);
                if (blockstate.is(ExquisitoBlockTags.ENNEGEL_REPLACEABLE)) {
                    if ((world.isEmptyBlock(pos2) || (blockstate2.is(BlockTags.REPLACEABLE_PLANTS)))) {
                        world.destroyBlock(pos, false);
                        if (ModList.get().isLoaded(ModCompat.EED)) {
                            if (entity.getRandom().nextFloat() < 0.25F) {
                                world.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModCompat.EED, "ennegel_block")).defaultBlockState(), 3);
                            } else {
                                world.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModCompat.EED,"indigo_eylium")).defaultBlockState(), 3);
                                if (entity.getRandom().nextFloat() < 0.33F) {
                                    Block block2 = plants.get(entity.getRandom().nextInt(plants.size()));
                                    world.setBlock(pos2, block2.defaultBlockState(), 3);
                                }
                            }
                        } else {
                            world.setBlock(pos, Blocks.PINK_CONCRETE.defaultBlockState(), 3);
                        }
                        break;
                    } else {
                        y = y + 1;
                    }
                } else {
                    y = y - 1;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEffectApplicable(MobEffectEvent.Applicable event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity entity = event.getEntity();

        if (effect == ExquisitoEffects.FUCHSIA_GOO.get()) {
            if (entity.getType().is(ExquisitoEntityTypeTags.FUCHSIA_GOO_IMMUNE)) {
                event.setResult(Event.Result.DENY);
            }
        }

        if (effect == ExquisitoEffects.RESONANCE.get()) {
            if (entity.getType().is(ExquisitoEntityTypeTags.RESONANCE_IMMUNE)) {
                event.setResult(Event.Result.DENY);
            }
        }

        if (entity.getEffect(ExquisitoEffects.LOVE_DELUXE.get()) != null) {
            ITagManager<MobEffect> mobEffectTags = ForgeRegistries.MOB_EFFECTS.tags();
            if (mobEffectTags != null && !mobEffectTags.getTag(NeapolitanMobEffectTags.UNAFFECTED_BY_VANILLA_SCENT).contains(effect)) {
                float amplifier = entity.getEffect(ExquisitoEffects.LOVE_DELUXE.get()).getAmplifier() + 1.0f;
                entity.heal(amplifier * 2);

                event.setResult(Event.Result.DENY);
            }
        }

    }

    @SubscribeEvent
    public static void onEntityHealed(LivingHealEvent event) {
        LivingEntity entity = event.getEntity();
        float amount = event.getAmount();

        if (entity.getEffect(ExquisitoEffects.MODULATION.get()) != null
                && entity.getEffect(ExquisitoEffects.LOVE_DELUXE.get()) == null
                && entity.getEffect(NeapolitanMobEffects.VANILLA_SCENT.get()) == null
                && amount + entity.getHealth() > entity.getMaxHealth()) {

            int m_d = entity.getEffect(ExquisitoEffects.MODULATION.get()).getDuration();
            int m_a = entity.getEffect(ExquisitoEffects.MODULATION.get()).getAmplifier();

            entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, m_d, m_a));
            entity.playSound(SoundEvents.MUD_BREAK, 1.5F, 1.5F);
            entity.removeEffect(ExquisitoEffects.MODULATION.get());
        }
    }

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity instanceof Player player && player.getEffect(ExquisitoEffects.DIVER_DOWN.get()) != null && player.isFallFlying()) {
            player.noPhysics = true;
        }
    }

}


