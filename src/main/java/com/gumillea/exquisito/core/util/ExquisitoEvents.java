package com.gumillea.exquisito.core.util;

import com.google.common.collect.Lists;
import com.gumillea.exquisito.common.block.ImaginalCapsuleBlock;
import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.ExquisitoConfig;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.gumillea.exquisito.core.util.tags.ExquisitoEntityTypeTags;
import com.teamabnormals.neapolitan.common.entity.projectile.BananaPeel;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanMobEffectTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanEntityTypes;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod.EventBusSubscriber(modid = Exquisito.MODID)
public class ExquisitoEvents {
    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        Level world = target.level();
        float health = target.getHealth();
        float damage = event.getAmount();
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            //Resonance Effect
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
                attacker.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.5F, 1.5F);
                attacker.removeEffect(ExquisitoEffects.MODULATION.get());
            }
            //Monkey Majik Effect
            if (attacker.getEffect(ExquisitoEffects.MONKEY_MAJIK.get()) != null
                    && !target.getType().is(ExquisitoEntityTypeTags.RESONANCE_IMMUNE)) {
                double x0 = target.getX();
                double y0 = target.getY();
                double z0 = target.getZ();
                int m_a = attacker.getEffect(ExquisitoEffects.MONKEY_MAJIK.get()).getAmplifier();
                List<MobEffectInstance> effects = Lists.newArrayList(target.getActiveEffects());
                List<MobEffectInstance> releasable_effects = new ArrayList<>();

                for(MobEffectInstance mobeffectinstance : effects) {
                    if(mobeffectinstance.getDuration()<32766)releasable_effects.add(mobeffectinstance);
                }

                for (int i = 0; i < 16; ++i) {
                    double x1 = x0 + (target.getRandom().nextDouble() - 0.5D) * 20.0D;
                    double y1 = Mth.clamp(target.getY() + (double)(target.getRandom().nextInt(20) - 10), world.getMinBuildHeight(), world.getMinBuildHeight() + ((ServerLevel)world).getLogicalHeight() - 1);
                    double z1 = z0 + (target.getRandom().nextDouble() - 0.5D) * 20.0D;
                    if (target.isPassenger()) {
                        target.stopRiding();
                    }
                    Vec3 vec3 = target.position();
                    world.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(target));
                    EntityTeleportEvent.ChorusFruit event_mj = ForgeEventFactory.onChorusFruitTeleport(target, x1, y1, z1);
                    if (target.randomTeleport(event_mj.getTargetX(), event_mj.getTargetY(), event_mj.getTargetZ(), true)) {
                        if (releasable_effects.iterator().hasNext()){
                            AreaEffectCloud cloud = new AreaEffectCloud(world, x0, y0, z0);
                            cloud.setRadius(3.0F);
                            cloud.setRadiusOnUse(-0.5F);
                            cloud.setWaitTime(10);
                            cloud.setDuration(cloud.getDuration());
                            cloud.setRadiusPerTick(-cloud.getRadius() / (float)cloud.getDuration());

                            MobEffectInstance effect = releasable_effects.iterator().next();

                            cloud.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration() / (4 - m_a), effect.getAmplifier()));
                            target.removeEffect(effect.getEffect());
                            world.addFreshEntity(cloud);
                        } else {
                            BananaPeel bananaPeel = (BananaPeel)((EntityType<?>)NeapolitanEntityTypes.BANANA_PEEL.get()).create(world);
                            bananaPeel.moveTo(x0, y0, z0, 0.0F, 0.0F);
                            world.addFreshEntity(bananaPeel);
                            target.playSound(NeapolitanSoundEvents.CHIMPANZEE_SCREAM.get(), 1.0F, 1.0F);
                        }
                        break;
                    }
                }
            }
        }
        //Fuchsia Goo Effect
        if (target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
            MobEffectInstance fg1 = target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get());
            target.playSound(SoundEvents.SLIME_BLOCK_HIT, 1.5F, 1.5F);
            if (event.getSource() != target.damageSources().fellOutOfWorld() && event.getSource() != target.damageSources().starve()) {
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
        if (event.getSource() == target.damageSources().fall() && target.getEffect(ExquisitoEffects.SPACE_DIVING.get()) != null) {
            int amplifier = target.getEffect(ExquisitoEffects.SPACE_DIVING.get()).getAmplifier() + 1;
            float fallDistance = target.fallDistance;
            for (LivingEntity targets : world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector((livingEntity) -> livingEntity != target),
                    target, target.getBoundingBox().inflate(target.getBbWidth() + amplifier * 6.0D + fallDistance * 0.15D, target.getBbHeight() * 2.0D, target.getBbWidth() + amplifier * 6.0D + fallDistance * 0.15D))) {
                if (fallDistance < 10 && ExquisitoConfig.Common.SPACE_DIVING_LIMITATION.get()) {
                    targets.playSound(SoundEvents.WARDEN_SONIC_BOOM, 0.3F, 3.5F);
                    targets.hurt(target.damageSources().explosion(target, target), (fallDistance * (0.25F + amplifier * 0.15F)));
                    targets.push(0, 0.4D, 0);
                } else {
                    targets.playSound(SoundEvents.WARDEN_SONIC_BOOM, 0.3F, 3.5F);
                    targets.hurt(target.damageSources().explosion(target, target), (fallDistance * (0.5F + amplifier * 0.15F)));
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
            if (event.getSource() == target.damageSources().fellOutOfWorld() && target.getY() < world.getMinBuildHeight()) {
                target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, m_d, 9 + m_a));
            } else if (event.getSource() == target.damageSources().lava() || event.getSource() == target.damageSources().onFire())  {
                target.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, m_d * 2, m_a));
            } else if (target.getHealth() / target.getMaxHealth() <= 0.5F) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, m_d / 2, 2 + m_a));
            } else {
                target.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, m_d * 2, m_a));
            }
            target.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.5F, 1.5F);
            target.removeEffect(ExquisitoEffects.MODULATION.get());
        }

    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        if (target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null && ExquisitoConfig.Common.FUCHSIA_GOO_SPREAD.get()) {
            generateEnnegels(target.level(), target);
        }
    }

    public static void generateEnnegels(Level world, LivingEntity target) {
        int amplifier = target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()).getAmplifier() + 1;

        Collection<LivingEntity> effectrange = world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector((living) -> living != target),
                target, target.getBoundingBox().inflate(4.0D, target.getBbHeight() * 2.0D, 4.0D));
        for (LivingEntity targets : effectrange) {
            int duration = target.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()).getDuration() / effectrange.size();
            if (targets.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
                MobEffectInstance fg = targets.getEffect(ExquisitoEffects.FUCHSIA_GOO.get());
                targets.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), fg.getDuration() + duration, fg.getAmplifier() + amplifier));
            } else {
                targets.addEffect(new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), duration, amplifier - 1));
            }
        }
    }

    @SubscribeEvent
    public static void onEffectApplicable(MobEffectEvent.Applicable event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

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

        if (effect == ExquisitoEffects.MORGOTH.get() && entity.getEffect(ExquisitoEffects.MORGOTH.get()) != null) {
                event.setResult(Event.Result.DENY);
        }

        if (entity.getEffect(ExquisitoEffects.LOVE_DELUXE.get()) != null) {
            ITagManager<MobEffect> mobEffectTags = ForgeRegistries.MOB_EFFECTS.tags();
            if (mobEffectTags != null && !mobEffectTags.getTag(NeapolitanMobEffectTags.UNAFFECTED_BY_VANILLA_SCENT).contains(effect)) {
                if (effect.getCategory() == MobEffectCategory.HARMFUL) {
                    float amount = 1.5F * (entity.getEffect(ExquisitoEffects.LOVE_DELUXE.get()).getAmplifier() + 2.0F);
                    entity.heal(amount);

                    if (!level.isClientSide && level instanceof ServerLevel server) {
                        RandomSource rand = entity.getRandom();
                        int times = 2 * Math.round(amount);

                        for(int i = 0; i < times; ++i) {
                            double d0 = rand.nextGaussian() * 0.02;
                            double d1 = rand.nextGaussian() * 0.02;
                            double d2 = rand.nextGaussian() * 0.02;

                            server.sendParticles(ParticleTypes.HEART, entity.getRandomX(1.0F), entity.getRandomY() + (double)0.5F, entity.getRandomZ(1.0F), 1, d0, d1, d2, 1);
                        }
                    }
                }
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
            entity.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.5F, 1.5F);
            entity.removeEffect(ExquisitoEffects.MODULATION.get());
        }
    }

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        if (entity.getEffect(ExquisitoEffects.EARENDEL.get()) != null) {
            int amplifier = entity.getEffect(ExquisitoEffects.EARENDEL.get()).getAmplifier();
            for (LivingEntity targets : entity.level().getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                    entity, entity.getBoundingBox().inflate((amplifier + 2) * 2.0D))) {
                if (targets.getType().getCategory() == MobCategory.MONSTER && !targets.getType().getCategory().isFriendly()) {
                    targets.setSecondsOnFire((amplifier + 1) * 4);
                    targets.playSound(SoundEvents.AMETHYST_CLUSTER_BREAK, 4F, 2F);
                    targets.knockback( 1.0F,entity.getX() - targets.getX(),entity.getZ() - targets.getZ());
                } else {
                    targets.heal(1.0F * amplifier);
                }
            }
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2));
            if (!level.isClientSide && level instanceof ServerLevel server) {
                RandomSource rand = entity.getRandom();

                for (int i = 0; i < 25 * (amplifier + 1); ++i) {
                    double d0 = rand.nextGaussian() * 0.25D;
                    double d1 = rand.nextGaussian() * 0.25D;
                    double d2 = rand.nextGaussian() * 0.25D;

                    server.sendParticles(ParticleTypes.ELECTRIC_SPARK, entity.getX(), entity.getEyeY(), entity.getZ(), 1, d0, d1, d2, 2);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRenderPlayer(RenderPlayerEvent event) {
        Player entity = event.getEntity();

        if (entity.getEffect(ExquisitoEffects.MORGOTH.get()) != null && entity.isSprinting()) {
            event.setCanceled(true);
        }

    }

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();

        if (level.getBlockState(pos.below()).getBlock() instanceof ImaginalCapsuleBlock) {
            if (level.getBlockState(pos.above()).isAir()) {
                level.setBlock(pos.above(), event.getPlacedBlock(), 3);
                level.removeBlock(pos, false);
            } else {
            event.setCanceled(true);
            }
        }
    }

}


