package com.gumillea.exquisito.common.effect;

import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

import java.util.Collection;

public class MorgothEffect extends MobEffect {
    public MorgothEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level;
        ItemStack stack = entity.getMainHandItem();
        Multimap<Attribute, AttributeModifier> mainhand = stack.getAttributeModifiers(EquipmentSlot.MAINHAND);

        if (entity.isShiftKeyDown()){
            entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 30));
        }

        if (mainhand.containsKey(Attributes.ATTACK_DAMAGE) && !((Player)entity).getCooldowns().isOnCooldown(stack.getItem())) {
            Collection<LivingEntity> effectrange = world.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT,
                    entity, entity.getBoundingBox().inflate((amplifier + 3) * 2.0D));
            for (LivingEntity targets : effectrange) {
                BlockPos pos = new BlockPos(targets.getX(), targets.getY() , targets.getZ());
                int light = targets.level.getRawBrightness(pos, world.getSkyDarken());
                if (light < 8) {
                    float damage = 0;
                    for (AttributeModifier modifier : mainhand.get(Attributes.ATTACK_DAMAGE)) {
                        damage += modifier.getAmount();
                    }
                    if (entity.hasEffect(MobEffects.INVISIBILITY)) {
                        targets.hurt(DamageSource.MAGIC, damage * ((8 - light) * 0.15F));
                    } else {
                        targets.hurt(DamageSource.mobAttack(entity).setMagic(), damage * ((8 - light) * 0.15F));
                    }
                    world.addParticle(ParticleTypes.SWEEP_ATTACK, targets.getX(), targets.getEyeY(), targets.getZ(), 0, 0, 0);
                    if (!world.isClientSide()) {
                        ((Player) entity).getCooldowns().addCooldown(stack.getItem(), 30 * effectrange.size());
                    }
                    stack.hurtAndBreak(effectrange.size() * 2, ((Player) entity), (attacker) -> attacker.broadcastBreakEvent(InteractionHand.MAIN_HAND));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
