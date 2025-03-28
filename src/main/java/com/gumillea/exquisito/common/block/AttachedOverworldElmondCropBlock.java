package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AttachedOverworldElmondCropBlock extends BushBlock {

    public AttachedOverworldElmondCropBlock(Properties properties) {
        super(properties);
    }
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ExquisitoItems.ELMOND.get());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        Block fruit = ExquisitoBlocks.OVERWORLD_ELMOND_FRUIT.get();
        Block stem = ExquisitoBlocks.OVERWORLD_ELMOND_CROP.get();
        return !levelAccessor.getBlockState(new BlockPos(pos.above(1))).is(fruit) ? stem.defaultBlockState().setValue(StemBlock.AGE, 7) : super.updateShape(state, direction, state1, levelAccessor, pos, pos1);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(Blocks.FARMLAND);
    }

}
