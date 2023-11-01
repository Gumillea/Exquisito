package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OverworldElmondCropBlock extends CropBlock implements BonemealableBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    public OverworldElmondCropBlock(Properties properties) {
        super(properties);
    }

    protected ItemLike getBaseSeedId() {
        return null;
    }

    public ItemStack getCloneItemStack(BlockGetter p_52254_, BlockPos p_52255_, BlockState p_52256_) {
        return new ItemStack(ExquisitoItems.ELMOND.get());
    }

    public boolean isRandomlyTicking(BlockState p_52288_) {
        return true;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_52258_, BlockPos p_52259_, BlockState p_52260_, boolean p_52261_) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        int i = state.getValue(AGE);
        if (level.getRawBrightness(pos.above(), 0) >= 6
                && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, source.nextInt(5) == 0)) {
            if (i < 7) {
                BlockState blockstate = state.setValue(AGE, i + 1);
                level.setBlock(pos, blockstate, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            }

            if (i == 7 && level.isEmptyBlock(pos.above(1))){
                BlockState blockstate = state.setValue(AGE, i);
                level.setBlock(pos, ExquisitoBlocks.ATTACHED_OVERWORLD_ELMOND_CROP.get().defaultBlockState(), 2);
                level.setBlock(pos.above(1), ExquisitoBlocks.OVERWORLD_ELMOND_FRUIT.get().defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            }
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
        }
    }


}
