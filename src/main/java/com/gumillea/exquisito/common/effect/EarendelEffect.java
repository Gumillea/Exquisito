package com.gumillea.exquisito.common.effect;

import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.LevelAccessor;

public class EarendelEffect extends MobEffect {
    public EarendelEffect() {
        super(MobEffectCategory.NEUTRAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        BlockPos pos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
        LevelAccessor world = entity.level;
        int light = world.getRawBrightness(pos, world.getSkyDarken());
        for (LivingEntity targets : entity.level.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                entity, entity.getBoundingBox().inflate((amplifier + 4) * 2.0D))) {
            if (light > 7) {
                if (targets.hasEffect(MobEffects.GLOWING)) {
                    targets.heal(0.2F * light);
                } else {
                    if (targets.getMobType() == MobType.UNDEAD) {
                        targets.setSecondsOnFire((amplifier + 1) * 4);
                    }
                    targets.playSound(SoundEvents.SHIELD_BLOCK, 3.0F, 1.0F);
                    targets.knockback( 0.15F * light,entity.getX() - targets.getX(),entity.getZ() - targets.getZ());
                }
            }
        }
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        int duration = entity.getEffect(ExquisitoEffects.EARENDEL.get()).getDuration();
        for (LivingEntity targets : entity.level.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                entity, entity.getBoundingBox().inflate((amplifier + 4) * 2.0D))) {
            if (targets.getMobType() == MobType.UNDEAD) {
                targets.setSecondsOnFire((amplifier + 1) * 4);
                targets.playSound(SoundEvents.SHIELD_BLOCK, 3.0F, 1.0F);
                targets.knockback( 2.0F,entity.getX() - targets.getX(),entity.getZ() - targets.getZ());
            } else {
                targets.addEffect(new MobEffectInstance(MobEffects.GLOWING, duration, amplifier));
            }
        }
        super.addAttributeModifiers(entity, attributeMap, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % (60 - 10 * amplifier) == 0;
    }
}
