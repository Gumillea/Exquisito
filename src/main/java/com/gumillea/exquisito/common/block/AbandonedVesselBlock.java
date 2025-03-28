package com.gumillea.exquisito.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbandonedVesselBlock extends GlassBlock {
    protected static final VoxelShape AABB = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return AABB;
    }

    public AbandonedVesselBlock(Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource randomSource) {
        if (randomSource.nextInt(5) == 0) {
            Direction $$4 = Direction.getRandom(randomSource);
            if ($$4 != Direction.UP) {
                BlockPos $$5 = pos.relative($$4);
                BlockState $$6 = level.getBlockState($$5);
                if (!state.canOcclude() || !$$6.isFaceSturdy(level, $$5, $$4.getOpposite())) {
                    double $$7 = $$4.getStepX() == 0 ? randomSource.nextDouble() : (double)0.5F + (double)$$4.getStepX() * 0.6;
                    double $$8 = $$4.getStepY() == 0 ? randomSource.nextDouble() : (double)0.5F + (double)$$4.getStepY() * 0.6;
                    double $$9 = $$4.getStepZ() == 0 ? randomSource.nextDouble() : (double)0.5F + (double)$$4.getStepZ() * 0.6;
                    level.addParticle(ParticleTypes.END_ROD, (double)pos.getX() + $$7, (double)pos.getY() + $$8, (double)pos.getZ() + $$9, 0.0F, 0.0F, 0.0F);
                }
            }
        }
    }
}
