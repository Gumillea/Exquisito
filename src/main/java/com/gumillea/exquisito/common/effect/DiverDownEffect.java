package com.gumillea.exquisito.common.effect;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class DiverDownEffect extends WarzipanEffect{
    public DiverDownEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x4896B3);
        this.addAttributeModifier(Attributes.FLYING_SPEED, "3E9B28D7-8D30-A056-672D-AFA64B4A29D0", 0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level;

        if (entity.isFallFlying() && !entity.isShiftKeyDown()) {
            if (entity.getY() < world.getMinBuildHeight() || entity.isInFluidType()) {
                entity.playSound(SoundEvents.FIREWORK_ROCKET_BLAST, 1.5F, 1.5F);
                entity.setDeltaMovement(entity.getDeltaMovement().add(0, 3.2D, 0));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

}
