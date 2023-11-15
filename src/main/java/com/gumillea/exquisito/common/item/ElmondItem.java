package com.gumillea.exquisito.common.item;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Objects;

public class ElmondItem extends Item {

    public ElmondItem(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().above();
        Player player = context.getPlayer();
        ItemStack hand = context.getItemInHand();
        BlockState crop = level.dimension() == Level.END ? ExquisitoBlocks.END_ELMOND_FLOWER.get().defaultBlockState() : ExquisitoBlocks.OVERWORLD_ELMOND_CROP.get().defaultBlockState();

        if (crop.canSurvive(level, pos) && level.isEmptyBlock(pos)) {
            level.setBlock(pos, crop, 3);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, pos, hand);
            }
            SoundType soundtype = crop.getSoundType(level, pos, player);
            level.playSound(player, pos, this.getPlaceSound(crop, level, pos, player), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

            if (player == null || !player.getAbilities().instabuild) {
                hand.shrink(1);
            }
        } else {
            return InteractionResult.FAIL;
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    protected SoundEvent getPlaceSound(BlockState state, Level world, BlockPos pos, Player entity) {
        return state.getSoundType(world, pos, entity).getPlaceSound();
    }

}
