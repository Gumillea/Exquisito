package com.gumillea.exquisito.common.item;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ElmondItem extends Item {

    public ElmondItem(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState ow_crop = ExquisitoBlocks.OVERWORLD_ELMOND_CROP.get().defaultBlockState();
        BlockState ed_crop = ExquisitoBlocks.END_ELMOND_FLOWER.get().defaultBlockState();

        if (level.dimension() == Level.OVERWORLD && ow_crop.canSurvive(level, pos.above(1))) {
            level.playSound(context.getPlayer(), pos.above(1), SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            level.setBlock(pos.above(1), ow_crop, 3);
        } else if (level.dimension() == Level.END && ed_crop.canSurvive(level, pos.above(1))) {
            level.playSound(context.getPlayer(), pos.above(1), SoundEvents.MUD_PLACE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            level.setBlock(pos.above(1), ed_crop, 3);
        } else {
            return InteractionResult.FAIL;
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }


}
