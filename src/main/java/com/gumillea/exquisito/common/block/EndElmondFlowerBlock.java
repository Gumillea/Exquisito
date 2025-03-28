package com.gumillea.exquisito.common.block;

import com.gumillea.exquisito.core.reg.ExquisitoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nullable;
import java.util.Iterator;

public class EndElmondFlowerBlock extends Block {
    public static final IntegerProperty AGE;
    private final EndElmondPlantBlock plant;

    public EndElmondFlowerBlock(EndElmondPlantBlock plantBlock, BlockBehaviour.Properties properties) {
        super(properties);
        this.plant = plantBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public void tick(BlockState p_220975_, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        if (!p_220975_.canSurvive(serverLevel, pos)) {
            serverLevel.destroyBlock(pos, true);
        }

    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 5;
    }

    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        BlockPos blockpos = pos.above();
        if (serverLevel.isEmptyBlock(blockpos) && blockpos.getY() < serverLevel.getMaxBuildHeight()) {
            int i = state.getValue(AGE);
            if (i < 5 && ForgeHooks.onCropsGrowPre(serverLevel, blockpos, state, true)) {
                boolean flag = false;
                boolean flag1 = false;
                BlockState blockstate = serverLevel.getBlockState(pos.below());
                int l;
                if (blockstate.is(Blocks.END_STONE)) {
                    flag = true;
                } else if (!blockstate.is(this.plant)) {
                    if (blockstate.isAir()) {
                        flag = true;
                    }
                } else {
                    l = 1;

                    for(int k = 0; k < 4; ++k) {
                        BlockState blockstate1 = serverLevel.getBlockState(pos.below(l + 1));
                        if (!blockstate1.is(this.plant)) {
                            if (blockstate1.is(Blocks.END_STONE)) {
                                flag1 = true;
                            }
                            break;
                        }

                        ++l;
                    }

                    if (l < 2 || l <= randomSource.nextInt(flag1 ? 5 : 4)) {
                        flag = true;
                    }
                }

                if (flag && allNeighborsEmpty(serverLevel, blockpos, (Direction)null) && serverLevel.isEmptyBlock(pos.above(2))) {
                    serverLevel.setBlock(pos, this.plant.getStateForPlacement(serverLevel, pos), 2);
                    this.placeGrownFlower(serverLevel, blockpos, i);
                } else if (i >= 4) {
                    this.placeDeadFlower(serverLevel, pos);
                } else {
                    l = randomSource.nextInt(4);
                    if (flag1) {
                        ++l;
                    }

                    boolean flag2 = false;

                    for(int i1 = 0; i1 < l; ++i1) {
                        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
                        BlockPos blockpos1 = pos.relative(direction);
                        if (serverLevel.isEmptyBlock(blockpos1) && serverLevel.isEmptyBlock(blockpos1.below()) && allNeighborsEmpty(serverLevel, blockpos1, direction.getOpposite())) {
                            this.placeGrownFlower(serverLevel, blockpos1, i + 1);
                            flag2 = true;
                        }
                    }

                    if (flag2) {
                        serverLevel.setBlock(pos, this.plant.getStateForPlacement(serverLevel, pos), 2);
                    } else {
                        this.placeDeadFlower(serverLevel, pos);
                    }
                }

                ForgeHooks.onCropsGrowPost(serverLevel, pos, state);
            }
        }

    }

    private void placeGrownFlower(Level level, BlockPos pos, int i) {
        level.setBlock(pos, this.defaultBlockState().setValue(AGE, i), 2);
        level.levelEvent(1033, pos, 0);
    }

    private void placeDeadFlower(Level level, BlockPos pos) {
        level.setBlock(pos, this.defaultBlockState().setValue(AGE, 5), 2);
        level.levelEvent(1034, pos, 0);
    }

    private static boolean allNeighborsEmpty(LevelReader levelReader, BlockPos pos, @Nullable Direction direction1) {
        Iterator var3 = Direction.Plane.HORIZONTAL.iterator();

        Direction direction;
        do {
            if (!var3.hasNext()) {
                return true;
            }

            direction = (Direction)var3.next();
        } while(direction == direction1 || levelReader.isEmptyBlock(pos.relative(direction)));

        return false;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        if (direction != Direction.UP && !state.canSurvive(levelAccessor, pos)) {
            levelAccessor.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, state1, levelAccessor, pos, pos1);
    }

    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockState blockstate = levelReader.getBlockState(pos.below());
        if (!blockstate.is(this.plant) && !blockstate.is(Blocks.END_STONE)) {
            if (!blockstate.isAir()) {
                return false;
            } else {
                boolean flag = false;
                Iterator var6 = Direction.Plane.HORIZONTAL.iterator();

                while(var6.hasNext()) {
                    Direction direction = (Direction)var6.next();
                    BlockState blockstate1 = levelReader.getBlockState(pos.relative(direction));
                    if (blockstate1.is(this.plant)) {
                        if (flag) {
                            return false;
                        }

                        flag = true;
                    } else if (!blockstate1.isAir()) {
                        return false;
                    }
                }

                return flag;
            }
        } else {
            return true;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public void onProjectileHit(Level level, BlockState state, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockpos = blockHitResult.getBlockPos();
        if (!level.isClientSide && projectile.mayInteract(level, blockpos) && projectile.getType().is(EntityTypeTags.IMPACT_PROJECTILES)) {
            level.destroyBlock(blockpos, true, projectile);
        }

    }

    static {
        AGE = BlockStateProperties.AGE_5;
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ExquisitoItems.ELMOND.get());
    }
}
