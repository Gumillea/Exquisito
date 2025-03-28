package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EndElmondPlantBlock extends ChorusPlantBlock {
    public EndElmondPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockGetter getter, BlockPos pos) {
        Block flower = ExquisitoBlocks.END_ELMOND_FLOWER.get();
        BlockState $$2 = getter.getBlockState(pos.below());
        BlockState $$3 = getter.getBlockState(pos.above());
        BlockState $$4 = getter.getBlockState(pos.north());
        BlockState $$5 = getter.getBlockState(pos.east());
        BlockState $$6 = getter.getBlockState(pos.south());
        BlockState $$7 = getter.getBlockState(pos.west());
        return this.defaultBlockState().setValue(DOWN, $$2.is(this) || $$2.is(flower) || $$2.is(Blocks.END_STONE)).setValue(UP, $$3.is(this) || $$3.is(flower)).setValue(NORTH, $$4.is(this) || $$4.is(flower)).setValue(EAST, $$5.is(this) || $$5.is(flower)).setValue(SOUTH, $$6.is(this) || $$6.is(flower)).setValue(WEST, $$7.is(this) || $$7.is(flower));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        if (!state.canSurvive(levelAccessor, pos)) {
            levelAccessor.scheduleTick(pos, this, 1);
            return super.updateShape(state, direction, state1, levelAccessor, pos, pos1);
        } else {
            boolean $$6 = state1.is(this) || state1.is(ExquisitoBlocks.END_ELMOND_FLOWER.get()) || direction == Direction.DOWN && state1.is(Blocks.END_STONE);
            return state.setValue(PROPERTY_BY_DIRECTION.get(direction), $$6);
        }
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ExquisitoItems.ELMOND.get());
    }
}
