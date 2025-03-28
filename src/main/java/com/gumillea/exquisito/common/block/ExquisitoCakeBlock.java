package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ExquisitoCakeBlock extends FlavoredCakeBlock {
    public ExquisitoCakeBlock(FoodProperties food, Properties properties) {
        super(food, properties);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();

        if (ModList.get().isLoaded("farmersdelight") && stack.is(ModTags.KNIVES)) {
            Block block = state.getBlock();
            int bites = state.getValue(BITES);

            world.setBlock(pos, bites < 6 ? state.setValue(CakeBlock.BITES, bites + 1) : Blocks.AIR.defaultBlockState(), 3);

            Map<Block, Supplier<Item>> cakeSliceMap = Map.of(
                    ExquisitoBlocks.CHORUS_CAKE.get(), ExquisitoItems.CHORUS_CAKE_SLICE,
                    ExquisitoBlocks.ETHER_BULB_CAKE.get(), ExquisitoItems.ETHER_BULB_CAKE_SLICE,
                    ExquisitoBlocks.JELLY_RING_CAKE.get(), ExquisitoItems.JELLY_RING_CAKE_SLICE,
                    ExquisitoBlocks.NIGHTSHADE_BERRY_CAKE.get(), ExquisitoItems.NIGHTSHADE_BERRY_CAKE_SLICE,
                    ExquisitoBlocks.ZURE_BERRY_CAKE.get(), ExquisitoItems.ZURE_BERRY_CAKE_SLICE
            );

            Optional.ofNullable(cakeSliceMap.get(block))
                    .ifPresent(sliceSupplier -> ItemUtils.spawnItemEntity(
                            world, new ItemStack(sliceSupplier.get()),
                            pos.getX() + (bites * 0.1), pos.getY() + 0.2, pos.getZ() + 0.5,
                            -0.05, 0, 0
                    ));

            world.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);

            world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.awardStat(Stats.ITEM_USED.get(item));

            return InteractionResult.SUCCESS;
        }

        return this.eatSlice(world, pos, state, player);
    }
}
