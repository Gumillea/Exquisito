package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.neapolitan.common.block.FlavoredCakeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

public class ExquisitoCakeBlock extends FlavoredCakeBlock {
    public ExquisitoCakeBlock(FoodProperties food, Properties properties) {
        super(food, properties);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();

        if (ModList.get().isLoaded("farmersdelight") && (stack.is(ModTags.KNIVES))) {
            Block block = state.getBlock();
            int bites = state.getValue(BITES);

            if (bites < 6) {
                world.setBlock(pos, state.setValue(CakeBlock.BITES, bites + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            if (block == ExquisitoBlocks.CHORUS_CAKE.get()) {
                ItemUtils.spawnItemEntity(world, new ItemStack(ExquisitoItems.CHORUS_CAKE_SLICE.get()),
                        pos.getX() + (bites * 0.1), pos.getY() + 0.2, pos.getZ() + 0.5,
                        -0.05, 0, 0);
            }

            if (block == ExquisitoBlocks.ETHER_BULB_CAKE.get()) {
                ItemUtils.spawnItemEntity(world, new ItemStack(ExquisitoItems.ETHER_BULB_CAKE_SLICE.get()),
                        pos.getX() + (bites * 0.1), pos.getY() + 0.2, pos.getZ() + 0.5,
                        -0.05, 0, 0);
            }

            if (block == ExquisitoBlocks.JELLY_RING_CAKE.get()) {
                ItemUtils.spawnItemEntity(world, new ItemStack(ExquisitoItems.JELLY_RING_CAKE_SLICE.get()),
                        pos.getX() + (bites * 0.1), pos.getY() + 0.2, pos.getZ() + 0.5,
                        -0.05, 0, 0);
            }

            if (block == ExquisitoBlocks.NIGHTSHADE_BERRY_CAKE.get()) {
                ItemUtils.spawnItemEntity(world, new ItemStack(ExquisitoItems.NIGHTSHADE_BERRY_CAKE_SLICE.get()),
                        pos.getX() + (bites * 0.1), pos.getY() + 0.2, pos.getZ() + 0.5,
                        -0.05, 0, 0);
            }

            if (block == ExquisitoBlocks.ZURE_BERRY_CAKE.get()) {
                ItemUtils.spawnItemEntity(world, new ItemStack(ExquisitoItems.ZURE_BERRY_CAKE_SLICE.get()),
                        pos.getX() + (bites * 0.1), pos.getY() + 0.2, pos.getZ() + 0.5,
                        -0.05, 0, 0);
            }

            world.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);

            world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.awardStat(Stats.ITEM_USED.get(item));

            return InteractionResult.SUCCESS;
        }

        return this.eatSlice(world, pos, state, player);
    }
}
