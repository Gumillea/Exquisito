package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.common.block.*;
import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.blueprint.common.block.BlueprintDirectionalBlock;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.common.block.MilkshakeCauldronBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = Exquisito.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExquisitoBlocks {
    public static final BlockSubRegistryHelper HELPER = Exquisito.REGISTRY_HELPER.getBlockSubHelper();

    //Milkshake
    public static final RegistryObject<Block> CHORUS_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("chorus_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.CHORUS_MILKSHAKE.map()));
    public static final RegistryObject<Block> ETHER_BULB_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("ether_bulb_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.ETHER_BULB_MILKSHAKE.map()));
    public static final RegistryObject<Block> JELLY_RING_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("jelly_ring_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.JELLY_RING_MILKSHAKE.map()));
    public static final RegistryObject<Block> NIGHTSHADE_BERRY_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("nightshade_berry_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.NIGHTSHADE_BERRY_MILKSHAKE.map()));
    public static final RegistryObject<Block> WARZIPAN_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("warzipan_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.WARZIPAN_MILKSHAKE.map()));
    public static final RegistryObject<Block> ZURE_BERRY_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("zure_berry_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.ZURE_BERRY_MILKSHAKE.map()));

    //Chorus Fruit Flavor
    public static final RegistryObject<Block> CHORUS_ICE_CREAM_BLOCK = HELPER.createBlock("chorus_ice_cream_block", () -> new Block(Properties.CHORUS_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> CHORUS_CAKE = HELPER.createBlockNoItem("chorus_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.CHORUS_CAKE, Properties.CHORUS_CAKE));

    //Ether Bulb Flavor
    public static final RegistryObject<Block> ETHER_BULB_ICE_CREAM_BLOCK = HELPER.createBlock("ether_bulb_ice_cream_block", () -> new Block(Properties.JELLY_RING_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> ETHER_BULB_CAKE = HELPER.createBlockNoItem("ether_bulb_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.ETHER_BULB_CAKE, Properties.JELLY_RING_CAKE));

    // Jelly Ring Flavor
    public static final RegistryObject<Block> JELLY_RING_ICE_CREAM_BLOCK = HELPER.createBlock("jelly_ring_ice_cream_block", () -> new Block(Properties.JELLY_RING_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> JELLY_RING_CAKE = HELPER.createBlockNoItem("jelly_ring_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.JELLY_RING_CAKE, Properties.JELLY_RING_CAKE));
    public static final RegistryObject<Block> JELLY_RING_CRATE = HELPER.createBlock("jelly_ring_crate", () -> new BlueprintDirectionalBlock(Properties.JELLY_RING_CRATE));

    //Nightshade Berry Flavor
    public static final RegistryObject<Block> NIGHTSHADE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("nightshade_berry_ice_cream_block", () -> new Block(Properties.NIGHTSHADE_BERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> NIGHTSHADE_BERRY_CAKE = HELPER.createBlockNoItem("nightshade_berry_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.NIGHTSHADE_BERRY_CAKE, Properties.NIGHTSHADE_BERRY_CAKE));

    //Zure Berry Flavor
    public static final RegistryObject<Block> ZURE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("zure_berry_ice_cream_block", () -> new Block(Properties.ZURE_BERRY_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> ZURE_BERRY_CAKE = HELPER.createBlockNoItem("zure_berry_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.ZURE_BERRY_CAKE, Properties.ZURE_BERRY_CAKE));

    //Elmond Flavor
    public static final RegistryObject<Block> ELMOND_BLOCK = HELPER.createBlock("elmond_block", () -> new Block(Properties.ELMOND_BLOCK));

    public static final RegistryObject<Block> WARZIPAN_ICE_CREAM_BLOCK = HELPER.createBlock("warzipan_ice_cream_block", () -> new Block(Properties.WARZIPAN_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> WARZIPAN_BLOCK = HELPER.createBlock("warzipan_block", () -> new Block(Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> WARZIPAN_BRICKS = HELPER.createBlock("warzipan_bricks", () -> new Block(Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> WARZIPAN_BRICK_SLAB = HELPER.createBlock("warzipan_brick_slab", () -> new SlabBlock(Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> WARZIPAN_BRICK_STAIRS = HELPER.createBlock("warzipan_brick_stairs", () -> new StairBlock(() -> WARZIPAN_BRICKS.get().defaultBlockState(),Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> WARZIPAN_BRICK_WALL = HELPER.createBlock("warzipan_brick_wall", () -> new WallBlock(Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICKS = HELPER.createBlock("dessert_checkered_bricks", () -> new Block(Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICK_SLAB = HELPER.createBlock("dessert_checkered_brick_slab", () -> new SlabBlock(Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICK_STAIRS = HELPER.createBlock("dessert_checkered_brick_stairs", () -> new StairBlock(() -> DESSERT_CHECKERED_BRICKS.get().defaultBlockState(),Properties.WARZIPAN_BLOCK));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICK_WALL = HELPER.createBlock("dessert_checkered_brick_wall", () -> new WallBlock(Properties.WARZIPAN_BLOCK));

    public static final RegistryObject<Block> CARMOTINE_BLOCK = HELPER.createBlock("carmotine_block", () -> new Block(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_SLAB = HELPER.createBlock("carmotine_slab", () -> new SlabBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_STAIRS = HELPER.createBlock("carmotine_stairs", () -> new StairBlock(() -> CARMOTINE_BLOCK.get().defaultBlockState(),Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_WALL = HELPER.createBlock("carmotine_wall", () -> new WallBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_BRICKS = HELPER.createBlock("carmotine_bricks", () -> new Block(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_BRICK_SLAB = HELPER.createBlock("carmotine_brick_slab", () -> new SlabBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_BRICK_STAIRS = HELPER.createBlock("carmotine_brick_stairs", () -> new StairBlock(() -> CARMOTINE_BRICKS.get().defaultBlockState(),Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_BRICK_WALL = HELPER.createBlock("carmotine_brick_wall", () -> new WallBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_PILLAR = HELPER.createBlock("carmotine_pillar", () -> new RotatedPillarBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> WEATHERED_CARMOTINE_MURAL = HELPER.createBlock("weathered_carmotine_mural", () -> new Block(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> RUINED_CARMOTINE_MURAL = HELPER.createBlock("ruined_carmotine_mural", () -> new Block(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> CARMOTINE_LADDER = HELPER.createBlock("carmotine_ladder", () -> new LadderBlock(Properties.CARMOTINE_LADDER));
    public static final RegistryObject<Block> ABANDONED_VESSEL = HELPER.createBlock("abandoned_vessel", () -> new AbandonedVesselBlock(Properties.ABANDONED_VESSEL));
    public static final RegistryObject<Block> BATTENLIGHT = HELPER.createBlock("battenlight", () -> new Block(Properties.BATTENLIGHT));

    public static final RegistryObject<Block> IMAGINAL_CAPSULE = HELPER.createBlock("imaginal_capsule", () -> new ImaginalCapsuleBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> IMAGINAL_CAPSULE_MIDNIGHT = HELPER.createBlock("imaginal_capsule_midnight", () -> new ActivatedImaginalCapsuleBlock(Properties.CARMOTINE_BLOCK));
    public static final RegistryObject<Block> IMAGINAL_CAPSULE_STARCLOUD = HELPER.createBlock("imaginal_capsule_starcloud", () -> new ActivatedImaginalCapsuleBlock(Properties.CARMOTINE_BLOCK));

    public static final RegistryObject<Block> OVERWORLD_ELMOND_CROP = HELPER.createBlockNoItem("overworld_elmond_crop", () -> new OverworldElmondCropBlock(Properties.OVERWORLD_ELMOND_CROP));
    public static final RegistryObject<Block> ATTACHED_OVERWORLD_ELMOND_CROP = HELPER.createBlockNoItem("attached_overworld_elmond_crop", () -> new AttachedOverworldElmondCropBlock(Properties.OVERWORLD_ELMOND_CROP));
    public static final RegistryObject<Block> OVERWORLD_ELMOND_FRUIT = HELPER.createBlockNoItem("overworld_elmond_fruit", () -> new OverworldElmondFruitBlock(Properties.OVERWORLD_ELMOND_FRUIT));
    public static final RegistryObject<Block> END_ELMOND_PLANT = HELPER.createBlockNoItem("end_elmond_plant", () -> new EndElmondPlantBlock(Properties.END_ELMOND));
    public static final RegistryObject<Block> END_ELMOND_FLOWER = HELPER.createBlockNoItem("end_elmond_flower", () -> new EndElmondFlowerBlock((EndElmondPlantBlock) ExquisitoBlocks.END_ELMOND_PLANT.get(), Properties.END_ELMOND));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(Exquisito.MODID)
                .tab(BUILDING_BLOCKS)
                .addItemsBefore(of(Blocks.PURPUR_BLOCK),
                        WARZIPAN_BLOCK, WARZIPAN_BRICKS, WARZIPAN_BRICK_STAIRS, WARZIPAN_BRICK_SLAB, WARZIPAN_BRICK_WALL,
                        DESSERT_CHECKERED_BRICKS, DESSERT_CHECKERED_BRICK_STAIRS, DESSERT_CHECKERED_BRICK_SLAB, DESSERT_CHECKERED_BRICK_WALL,
                        CARMOTINE_BLOCK, CARMOTINE_PILLAR, CARMOTINE_STAIRS, CARMOTINE_SLAB, CARMOTINE_WALL,
                        CARMOTINE_BRICKS, CARMOTINE_BRICK_STAIRS, CARMOTINE_BRICK_SLAB, CARMOTINE_BRICK_WALL
                )

                .addItems(CHORUS_ICE_CREAM_BLOCK, WARZIPAN_ICE_CREAM_BLOCK)
                .predicate(event -> event.getTabKey() == BUILDING_BLOCKS && ModList.get().isLoaded(ModCompat.EED))
                .addItems(JELLY_RING_ICE_CREAM_BLOCK, ZURE_BERRY_ICE_CREAM_BLOCK)
                .predicate(event -> event.getTabKey() == BUILDING_BLOCKS && ModList.get().isLoaded(ModCompat.B))
                .addItems(ETHER_BULB_ICE_CREAM_BLOCK, NIGHTSHADE_BERRY_ICE_CREAM_BLOCK)

                .tab(FUNCTIONAL_BLOCKS)
                .addItemsAfter(of(Blocks.PEARLESCENT_FROGLIGHT), BATTENLIGHT)
                .addItemsAfter(of(Blocks.LADDER), CARMOTINE_LADDER)
                .addItemsAfter(of(Blocks.BEEHIVE), IMAGINAL_CAPSULE)

                .tab(NATURAL_BLOCKS)
                .addItemsAfter(of(Blocks.MELON), ABANDONED_VESSEL)
                .addItemsAfter(of(Blocks.HONEY_BLOCK), ELMOND_BLOCK)
                .predicate(event -> event.getTabKey() == NATURAL_BLOCKS && ModList.get().isLoaded(ModCompat.EED))
                .addItemsAfter(of(Blocks.HAY_BLOCK), JELLY_RING_CRATE);
    }

    static class Properties {
        //Ice Cream Blocks
        public static final BlockBehaviour.Properties CHORUS_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties JELLY_RING_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties NIGHTSHADE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties ZURE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties WARZIPAN_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.2F).sound(SoundType.SNOW);

        //Cakes
        public static final Block.Properties CHORUS_CAKE = Block.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties JELLY_RING_CAKE = Block.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties NIGHTSHADE_BERRY_CAKE = Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties ZURE_BERRY_CAKE = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.5F).sound(SoundType.WOOL);

        //Elmond
        public static final BlockBehaviour.Properties ELMOND_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).strength(0.5F, 2.0F).sound(SoundType.MUD);
        public static final BlockBehaviour.Properties WARZIPAN_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).strength(1.0F, 4.0F).sound(SoundType.STONE);

        public static final BlockBehaviour.Properties CARMOTINE_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.DEEPSLATE);
        public static final BlockBehaviour.Properties CARMOTINE_LADDER = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(0.4F).sound(SoundType.DEEPSLATE).noOcclusion();
        public static final BlockBehaviour.Properties ABANDONED_VESSEL = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(0.4F).noOcclusion().isValidSpawn(ExquisitoBlocks::never).isRedstoneConductor(ExquisitoBlocks::never).isSuffocating(ExquisitoBlocks::never).isViewBlocking(ExquisitoBlocks::never).sound(SoundType.GLASS).lightLevel(value -> 6);
        public static final BlockBehaviour.Properties BATTENLIGHT = BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).strength(0.5F).sound(SoundType.DEEPSLATE).lightLevel(value -> 15);

        public static final BlockBehaviour.Properties OVERWORLD_ELMOND_CROP = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.4F).noCollission().sound(SoundType.WEEPING_VINES);
        public static final BlockBehaviour.Properties OVERWORLD_ELMOND_FRUIT = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).instabreak().noCollission().sound(SoundType.MUD).lightLevel(value -> 10);
        public static final BlockBehaviour.Properties END_ELMOND = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.5F, 2.0F).noOcclusion().sound(SoundType.MUD);

        //Crates
        public static final BlockBehaviour.Properties JELLY_RING_CRATE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(1.5F).sound(SoundType.WOOD);
    }

    private static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }
    private static boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}

