package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class KarmotineSlabBlock extends SlabBlock {
    public KarmotineSlabBlock(Properties properties) {
        super(properties);
    }

    private boolean hasEffect(Entity entity) {
        return entity instanceof LivingEntity living && living.hasEffect(ExquisitoEffects.MODULATION.get());
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float v) {
        if (!hasEffect(entity) || entity.isSuppressingBounce()) {
            super.fallOn(level, state, pos, entity, v);
        } else  {
            entity.playSound(SoundEvents.HONEY_BLOCK_BREAK, 1.0F, 1.0F);
            entity.causeFallDamage(v, 0.0F, level.damageSources().fall());
        }

    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter getter, Entity entity) {
        if (!hasEffect(entity) ||entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(getter, entity);
        } else {
            this.bounceUp(entity);
        }

    }

    private void bounceUp(Entity entity) {
        Vec3 movement = entity.getDeltaMovement();
        if (movement.y < (double)0.0F) {
            entity.setDeltaMovement(movement.x, -movement.y, movement.z);
        }
    }

}
