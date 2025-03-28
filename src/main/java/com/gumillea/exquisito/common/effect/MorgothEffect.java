package com.gumillea.exquisito.common.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class MorgothEffect extends MobEffect {
    public MorgothEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x404CC8);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();

        if (entity.isSprinting()) {
            Vec3 lookAngle = entity.getLookAngle();
            Vec3 dashVec = lookAngle.scale(0.4 + (amplifier * 0.15));

            entity.setDeltaMovement(dashVec);
            entity.setInvulnerable(true);

            for (LivingEntity targets : entity.level().getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                    entity, entity.getBoundingBox().inflate(1.0D))) {
                if (!(targets instanceof TamableAnimal tamableAnimal && tamableAnimal.isTame())) {
                    targets.hurt(entity.damageSources().magic(), 1.0F + 0.5F * amplifier);
                    targets.knockback(0.5D,targets.getX() - entity.getX(),targets.getZ() - entity.getZ());
                    targets.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10));
                }
            }

            RandomSource rand = entity.getRandom();
            if (world.isClientSide()) {
                int times = 2 * Math.round(amplifier + 1);

                for(int i = 0; i < times; ++i) {
                    double d0 = rand.nextGaussian() * 0.02;
                    double d1 = rand.nextGaussian() * 0.02;
                    double d2 = rand.nextGaussian() * 0.02;
                    world.addParticle(ParticleTypes.LARGE_SMOKE, entity.getRandomX(1.0F), entity.getRandomY() - (double)0.5F, entity.getRandomZ(1.0F), d0, d1, d2);
                }
            }

        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);

        entity.setInvulnerable(false);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
