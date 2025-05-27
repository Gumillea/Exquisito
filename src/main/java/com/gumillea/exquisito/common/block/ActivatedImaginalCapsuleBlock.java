package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;

public class ActivatedImaginalCapsuleBlock extends ImaginalCapsuleBlock implements BonemealableBlock {

    public ActivatedImaginalCapsuleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    protected ItemLike getCropItem() {
        return this == ExquisitoBlocks.IMAGINAL_CAPSULE_MIDNIGHT.get() ? ExquisitoItems.MIDNIGHT_BERRIES.get() : ExquisitoItems.STARCLOUD_BULBS.get();
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(this.getCropItem());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int i = state.getValue(AGE);
        boolean flag = i == 5;
        float chance = player.hasEffect(ExquisitoEffects.MODULATION.get()) ? 0.1F : 0.033F;

        if (player.getItemInHand(hand).is(Items.SHEARS)) {
            level.setBlock(pos, ExquisitoBlocks.IMAGINAL_CAPSULE.get().defaultBlockState(), 3);
            level.playSound(null, pos, SoundEvents.AZALEA_LEAVES_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
            return InteractionResult.SUCCESS;
        }

        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 3) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos.above(), new ItemStack(this.getCropItem(), j + (flag ? 1 : 0)));
            if (player.getRandom().nextFloat() <= chance) {
                popResource(level, pos.above(), new ItemStack(ExquisitoItems.ABANDONED_CORE.get(), 1));
            }
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = state.setValue(AGE, 3);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.FAIL;
        }
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 5;
    }
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = state.getValue(AGE);
        if (i < 5 && ForgeHooks.onCropsGrowPre(serverLevel, pos, state, randomSource.nextInt(5) == 0)) {
            BlockState blockstate = state.setValue(AGE, i + 1);
            serverLevel.setBlock(pos, blockstate, 2);
            serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            ForgeHooks.onCropsGrowPost(serverLevel, pos, state);
        }
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, boolean p_57263_) {
        return state.getValue(AGE) < 5;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos pos, BlockState state) {
        int i = Math.min(5, state.getValue(AGE) + 1);
        serverLevel.setBlock(pos, state.setValue(AGE, i), 2);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        int age = state.getValue(AGE);
        return age > 2 ? age * 3 : 0;
    }

}
