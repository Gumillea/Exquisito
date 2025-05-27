package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class Battenlightblock extends KarmotineBlock{
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public Battenlightblock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(OPEN, true));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
       return this.defaultBlockState().setValue(OPEN, false);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.getValue(OPEN) ? 15 : 8;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        boolean open = state.getValue(OPEN);
        ItemStack inHand = player.getItemInHand(hand);

        if (!open && (inHand.is(ExquisitoItems.WARZIPAN.get()))) {
            if (!level.isClientSide) {
                setOpen(state, level, pos);
                if (!player.getAbilities().instabuild) {
                    inHand.shrink(1);
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    public static void setOpen(BlockState state, Level level, BlockPos pos) {
        level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 1.25F, 1.25F);
        level.setBlock(pos, state.setValue(OPEN, true), 3);

        AABB box = new AABB(pos.offset(-32, -32, -32), pos.offset(31, 31, 31));
        List<Monster> targets = level.getEntitiesOfClass(Monster.class, box, Monster::isAlive);
        if (!targets.isEmpty()) {
            for (LivingEntity living : targets) {
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 3000));
            }
        }

        level.scheduleTick(pos, state.getBlock(), 6000);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, state.setValue(OPEN, false), 3);
    }
}
