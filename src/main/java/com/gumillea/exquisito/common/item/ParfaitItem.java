package com.gumillea.exquisito.common.item;

import com.google.common.collect.Multimap;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.food.FoodProperties;

import java.util.Collection;
import java.util.Objects;

public class ParfaitItem extends Item {
    public ParfaitItem(Properties builder) {
        super(builder.durability(3).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        giveEffect(stack, world, user);

        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            stack.hurt(1, world.getRandom(), serverPlayer);
        }

        if (stack.getDamageValue() > 2) {
            return ((Player)user).getAbilities().instabuild ? new ItemStack(this) : new ItemStack(Items.GLASS_BOTTLE);
        }

        return super.finishUsingItem(stack, world, user);
    }

    private void giveEffect(ItemStack stack, Level world, LivingEntity user){
        BlockPos pos = new BlockPos(user.getX(), user.getY(), user.getZ());
        int light = world.getRawBrightness(pos, world.getSkyDarken());

        if (user instanceof Player player){
            player.getFoodData().eat(4,0.4F);
        }

        if (this == ExquisitoItems.NIGHTSHADE_BERRY_PARFAIT.get()){

            if (stack.getDamageValue() == 0) {
                user.addEffect(new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 1200, (15 - light) / 5));
                user.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200));
            }

            if (stack.getDamageValue() == 1) {
                user.addEffect(new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 600, (15 - light) / 3));
                if (user.hasEffect(ExquisitoEffects.MORGOTH.get())){
                    int amplifier = user.getEffect(ExquisitoEffects.MORGOTH.get()).getAmplifier();
                    Collection<LivingEntity> effectrange = world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                       user, user.getBoundingBox().inflate((amplifier + 3) * 2.0D));
                    for (LivingEntity targets : effectrange) {
                        targets.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, (15 - light) / 3));
                    }
                }
            }

            if (stack.getDamageValue() == 2) {
                if (user.hasEffect(ExquisitoEffects.MORGOTH.get())){
                    int amplifier = user.getEffect(ExquisitoEffects.MORGOTH.get()).getAmplifier();
                    for (LivingEntity targets :  world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                            user, user.getBoundingBox().inflate((amplifier + 3) * 4.0D))){
                        targets.knockback( (16 - light) * 0.2F,targets.getX() - user.getX(),targets.getZ() - user.getZ());
                        targets.hurt(DamageSource.MAGIC, (16 - light + amplifier) * 0.5F);
                    }
                    if (!world.isClientSide()) {
                    user.removeEffect(ExquisitoEffects.MORGOTH.get());
                    }
                } else {
                    user.addEffect(new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 600, (15 - light) / 3));
                }
            }

        }

        if (this == ExquisitoItems.ETHER_BULB_PARFAIT.get()) {

            if (stack.getDamageValue() == 0) {
                user.addEffect(new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 1200 + light * 40));
                user.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200 + light * 40));
            }

            if (stack.getDamageValue() == 1) {
                for (LivingEntity targets : world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                        user, user.getBoundingBox().inflate((6.0D)))) {
                    if (targets.hasEffect(MobEffects.GLOWING) && targets instanceof Enemy) {
                        if (!world.isClientSide()) {
                            targets.removeEffect(MobEffects.GLOWING);
                        }
                        targets.setSecondsOnFire(5);
                        targets.playSound(SoundEvents.SHIELD_BLOCK, 3.0F, 1.0F);
                        targets.knockback(2.0F, user.getX() - targets.getX(), user.getZ() - targets.getZ());
                    }
                }
            }

            if (stack.getDamageValue() == 2) {
                if (user.getEffect(ExquisitoEffects.EARENDEL.get()) != null) {
                    int amplifier = user.getEffect(ExquisitoEffects.EARENDEL.get()).getAmplifier();
                    int size = 0;
                    for (LivingEntity targets : world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                            user, user.getBoundingBox().inflate((amplifier + 3) * 2.0D))) {
                        if (targets.getEffect(MobEffects.GLOWING) != null) {
                            size = Math.min(size + 1, 5);
                        }
                    }

                    if (size != 0) {
                        if (user.getHealth() >= user.getMaxHealth() * 0.5) {
                            user.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, size - 1));
                        } else {
                            user.heal(size);
                        }
                    user.removeEffect(ExquisitoEffects.EARENDEL.get());
                    }

                } else {
                    user.addEffect(new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 600 + light * 20));
                }
            }
        }
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
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
        return SoundEvents.GENERIC_EAT;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_EAT;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        return InteractionResultHolder.success(stack);
    }

    @Override
    public boolean isEdible() {
        return false;
    }

    @Override
    public boolean isRepairable(ItemStack stack)  {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

}
