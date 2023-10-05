package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class OverworldElmondFruitBlock extends BushBlock {

    public OverworldElmondFruitBlock(Properties properties) {
        super(properties);
    }

    public ItemStack getCloneItemStack(BlockGetter p_52254_, BlockPos p_52255_, BlockState p_52256_) {
        return new ItemStack(ExquisitoItems.ELMOND.get());
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter getter, BlockPos pos) {
        return blockState.is(ExquisitoBlocks.ATTACHED_OVERWORLD_ELMOND_CROP.get());
    }

}
