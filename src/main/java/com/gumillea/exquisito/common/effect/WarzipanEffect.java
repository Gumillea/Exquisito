package com.gumillea.exquisito.common.effect;

import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class WarzipanEffect extends MobEffect {
    public WarzipanEffect(MobEffectCategory effectType, int liquidColor) {
            super(effectType, liquidColor);
        }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);

        if (entity.hasEffect(ExquisitoEffects.MODULATION.get())) {
            entity.removeEffect(ExquisitoEffects.MODULATION.get());
            entity.addEffect(new MobEffectInstance(this, 600, amplifier + 1));
        }

    }

}
