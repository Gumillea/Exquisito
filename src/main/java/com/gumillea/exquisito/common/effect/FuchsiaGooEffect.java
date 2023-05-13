package com.gumillea.exquisito.common.effect;

import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;

public class FuchsiaGooEffect extends MobEffect {
    public FuchsiaGooEffect() {
        super(MobEffectCategory.NEUTRAL, 0xE0528E);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "A7CF522A-8C38-42A1-9AB1-F4BC0E8DBFE7", -0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        int duration = entity.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()).getDuration();
        if (duration == 2) {
            if (entity.isPassenger()) {
                entity.stopRiding();
            }
            entity.playSound(SoundEvents.FIREWORK_ROCKET_BLAST, 1.5F, 1.5F);
            entity.setDeltaMovement(Vec3.ZERO);
            if (amplifier < 9) {
                entity.push(0, 0.6D + (amplifier + 1) * 0.6D, 0);
            } else {
                entity.push(0, 6.6D, 0);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
