package com.gumillea.exquisito.common.item;

import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.google.common.collect.Lists;
import com.teamabnormals.neapolitan.common.item.DrinkItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;

import java.util.ArrayList;
import java.util.List;

public class ExquisitoMilkshakeItem extends DrinkItem {
    public ExquisitoMilkshakeItem(Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        handleEffects(world, user);
        if (this == ExquisitoItems.CHORUS_MILKSHAKE.get() && (user instanceof Player)) {
            ((Player)user).getCooldowns().addCooldown(this, 40);
        }
        return super.finishUsingItem(stack, world, user);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (player.getCooldowns().isOnCooldown(this))
            return InteractionResult.FAIL;

        if (entity.level.isClientSide)
            return InteractionResult.CONSUME;
        entity.level.playSound(null, entity.blockPosition(), SoundEvents.WANDERING_TRADER_DRINK_MILK, SoundSource.NEUTRAL, 1, 1);

        if (player instanceof ServerPlayer serverplayerentity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity.getEffect(NeapolitanMobEffects.VANILLA_SCENT.get()) == null) {
            handleEffects(entity.getLevel(), entity);
            if (this == ExquisitoItems.CHORUS_MILKSHAKE.get())
                player.getCooldowns().addCooldown(this, 40);
        }

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
            ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
            if (!player.getInventory().add(itemstack)) {
                player.drop(itemstack, false);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private void handleEffects(Level world, LivingEntity entity) {
        List<MobEffectInstance> effects = Lists.newArrayList(entity.getActiveEffects());

        if (this == ExquisitoItems.CHORUS_MILKSHAKE.get()) {
            List<MobEffectInstance> releasable_effects = new ArrayList<>();
            for(MobEffectInstance mobeffectinstance : effects) {
                if(mobeffectinstance.getDuration()<32766)releasable_effects.add(mobeffectinstance);
            }
            if (!world.isClientSide) {
                double x0 = entity.getX();
                double y0 = entity.getY();
                double z0 = entity.getZ();
                for (int i = 0; i < 16; ++i) {
                    double x1 = entity.getX() + (entity.getRandom().nextDouble() - 0.5D) * 32.0D;
                    double y1 = Mth.clamp(entity.getY() + (double)(entity.getRandom().nextInt(32) - 16), world.getMinBuildHeight(), world.getMinBuildHeight() + ((ServerLevel)world).getLogicalHeight() - 1);
                    double z1 = entity.getZ() + (entity.getRandom().nextDouble() - 0.5D) * 32.0D;
                    if (entity.isPassenger()) {
                        entity.stopRiding();
                    }
                    Vec3 vec3 = entity.position();
                    world.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(entity));
                    EntityTeleportEvent.ChorusFruit event = ForgeEventFactory.onChorusFruitTeleport(entity, x1, y1, z1);
                    if (entity.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                        if (!releasable_effects.isEmpty()){
                            AreaEffectCloud cloud = new AreaEffectCloud(world, x0, y0, z0);
                            cloud.setRadius(4.0F);
                            cloud.setRadiusOnUse(-0.5F);
                            cloud.setWaitTime(10);
                            cloud.setDuration(cloud.getDuration());
                            cloud.setRadiusPerTick(-cloud.getRadius() / (float)cloud.getDuration());
                            for(MobEffectInstance mobeffectinstance : releasable_effects) {
                                    cloud.addEffect(new MobEffectInstance(mobeffectinstance.getEffect(), mobeffectinstance.getDuration() / 4, mobeffectinstance.getAmplifier()));
                                    entity.removeEffect(mobeffectinstance.getEffect());
                            }
                            world.addFreshEntity(cloud);
                        }
                        SoundEvent soundevent = entity instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                        world.playSound(null, x0, y0, z0, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                        entity.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }
            }
        }

        if (this == ExquisitoItems.JELLY_RING_MILKSHAKE.get()) {
            List<MobEffectInstance> clearable_effects = new ArrayList<>();
            for(MobEffectInstance mobeffectinstance : effects) {
                if(mobeffectinstance.getEffect().isBeneficial())clearable_effects.add(mobeffectinstance);
            }
            if (!clearable_effects.isEmpty()) {
                for(MobEffectInstance mobeffectinstance : clearable_effects) {
                    if (entity.getMobType() == MobType.UNDEAD){
                        entity.hurt(DamageSource.MAGIC,2.0F * clearable_effects.size());
                    } else {
                        entity.heal(2.0F * clearable_effects.size());
                    }
                    entity.removeEffect(mobeffectinstance.getEffect());
                }
            }
        }

        if (this == ExquisitoItems.ZURE_BERRY_MILKSHAKE.get()) {
            List<MobEffectInstance> clearable_effects = new ArrayList<>();
            for(MobEffectInstance mobeffectinstance : effects) {
                if(!mobeffectinstance.getEffect().isBeneficial())clearable_effects.add(mobeffectinstance);
            }
            if (!clearable_effects.isEmpty()) {
                for(MobEffectInstance mobeffectinstance : clearable_effects) {
                    entity.hurt(DamageSource.MAGIC,1.0F * clearable_effects.size());
                    if (!world.isClientSide) {
                        world.explode(entity, entity.getX(), entity.getY(), entity.getZ(), 1 + clearable_effects.size(), Explosion.BlockInteraction.NONE);
                    }
                    entity.removeEffect(mobeffectinstance.getEffect());
                }
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}
