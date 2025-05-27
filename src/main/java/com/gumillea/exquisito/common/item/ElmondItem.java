package com.gumillea.exquisito.common.item;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ElmondItem extends Item {

    public ElmondItem(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockState crop = level.dimension() == Level.END ? ExquisitoBlocks.END_ELMOND_FLOWER.get().defaultBlockState() : ExquisitoBlocks.OVERWORLD_ELMOND_CROP.get().defaultBlockState();

        if (level.getBlockState(clickedPos).canBeReplaced() && crop.canSurvive(level, clickedPos)) {
            placeElmond(level, clickedPos, player, stack);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        BlockPos targetPos = clickedPos.relative(direction);
        if (level.getBlockState(targetPos).canBeReplaced() && crop.canSurvive(level, targetPos)) {
            placeElmond(level, targetPos, player, stack);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return InteractionResult.FAIL;
    }

    private void placeElmond(Level level, BlockPos pos, Player player, ItemStack stack) {
        BlockState crop = level.dimension() == Level.END ? ExquisitoBlocks.END_ELMOND_FLOWER.get().defaultBlockState() : ExquisitoBlocks.OVERWORLD_ELMOND_CROP.get().defaultBlockState();

        level.setBlock(pos, crop, 3);
        level.playSound(player, pos, this.getPlaceSound(crop, level, pos, player), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);

        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, stack);
        }
        if (player == null || !player.getAbilities().instabuild) {
            stack.shrink(1);
        }
    }

    protected SoundEvent getPlaceSound(BlockState state, Level world, BlockPos pos, Player entity) {
        return state.getSoundType(world, pos, entity).getPlaceSound();
    }

}
