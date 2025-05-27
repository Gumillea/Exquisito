package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.berry_good.core.registry.BGItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.ModList;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ImaginalCapsuleBlock extends KarmotineBlock {

    public ImaginalCapsuleBlock(Properties properties) {
        super(properties);
    }

    protected static final VoxelShape AABB = Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0);

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return AABB;
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();

        Map<Item, Supplier<Block>> cropMap = Map.of(
                ModList.get().isLoaded(ModCompat.BG) ? BGItems.SWEET_BERRY_PIPS.get() : Items.SWEET_BERRIES, ExquisitoBlocks.IMAGINAL_CAPSULE_MIDNIGHT,
                ModList.get().isLoaded(ModCompat.BG) ? BGItems.GLOW_BERRY_PIPS.get() : Items.GLOW_BERRIES, ExquisitoBlocks.IMAGINAL_CAPSULE_STARCLOUD
        );

        return Optional.ofNullable(cropMap.get(item))
                .map(blockSupplier -> {
                    level.setBlock(pos, blockSupplier.get().defaultBlockState(), 3);
                    level.playSound(null, pos, SoundEvents.AZALEA_LEAVES_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                })
                .orElse(InteractionResult.FAIL);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
    }

}
