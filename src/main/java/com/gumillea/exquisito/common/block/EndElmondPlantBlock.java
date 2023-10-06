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
import net.minecraft.world.level.block.state.properties.Property;

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
    public BlockState updateShape(BlockState p_51728_, Direction p_51729_, BlockState p_51730_, LevelAccessor p_51731_, BlockPos p_51732_, BlockPos p_51733_) {
        if (!p_51728_.canSurvive(p_51731_, p_51732_)) {
            p_51731_.scheduleTick(p_51732_, this, 1);
            return super.updateShape(p_51728_, p_51729_, p_51730_, p_51731_, p_51732_, p_51733_);
        } else {
            boolean $$6 = p_51730_.is(this) || p_51730_.is(ExquisitoBlocks.END_ELMOND_FLOWER.get()) || p_51729_ == Direction.DOWN && p_51730_.is(Blocks.END_STONE);
            return p_51728_.setValue(PROPERTY_BY_DIRECTION.get(p_51729_), $$6);
        }
    }

    public ItemStack getCloneItemStack(BlockGetter p_52254_, BlockPos p_52255_, BlockState p_52256_) {
        return new ItemStack(ExquisitoItems.ELMOND.get());
    }
}
