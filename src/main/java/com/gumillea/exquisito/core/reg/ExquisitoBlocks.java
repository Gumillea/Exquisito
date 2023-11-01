package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.common.block.*;
import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.common.block.MilkshakeCauldronBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Exquisito.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExquisitoBlocks {
    public static final BlockSubRegistryHelper HELPER = Exquisito.REGISTRY_HELPER.getBlockSubHelper();

    //Milkshake
    public static final RegistryObject<Block> CHORUS_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("chorus_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.CHORUS_MILKSHAKE.map()));
    public static final RegistryObject<Block> JELLY_RING_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("jelly_ring_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.JELLY_RING_MILKSHAKE.map()));
    public static final RegistryObject<Block> ZURE_BERRY_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("zure_berry_milkshake_cauldron", () -> new MilkshakeCauldronBlock(ExquisitoCauldronInteractions.ZURE_BERRY_MILKSHAKE.map()));

    //Chorus Fruit Flavor
    public static final RegistryObject<Block> CHORUS_ICE_CREAM_BLOCK = HELPER.createBlock("chorus_ice_cream_block", () -> new Block(Properties.CHORUS_ICE_CREAM_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CHORUS_CAKE = HELPER.createBlockNoItem("chorus_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.CHORUS_CAKE, Properties.CHORUS_CAKE));

    //Ether Bulb Flavor
    public static final RegistryObject<Block> ETHER_BULB_ICE_CREAM_BLOCK = HELPER.createBlock("ether_bulb_ice_cream_block", () -> new Block(Properties.JELLY_RING_ICE_CREAM_BLOCK), (ModCompat.BYG_BLOCK));
    public static final RegistryObject<Block> ETHER_BULB_CAKE = HELPER.createBlockNoItem("ether_bulb_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.ETHER_BULB_CAKE, Properties.JELLY_RING_CAKE));

    // Jelly Ring Flavor
    public static final RegistryObject<Block> JELLY_RING_ICE_CREAM_BLOCK = HELPER.createBlock("jelly_ring_ice_cream_block", () -> new Block(Properties.JELLY_RING_ICE_CREAM_BLOCK), ModCompat.ENLIGHTEND_BLOCK);
    public static final RegistryObject<Block> JELLY_RING_CAKE = HELPER.createBlockNoItem("jelly_ring_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.JELLY_RING_CAKE, Properties.JELLY_RING_CAKE));
    public static final RegistryObject<Block> JELLY_RING_CRATE = HELPER.createBlock("jelly_ring_crate", () -> new Block(Properties.JELLY_RING_CRATE), (CreativeModeTab.TAB_BUILDING_BLOCKS));

    //Nightshade Berry Flavor
    public static final RegistryObject<Block> NIGHTSHADE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("nightshade_berry_ice_cream_block", () -> new Block(Properties.NIGHTSHADE_BERRY_ICE_CREAM_BLOCK), (ModCompat.BYG_BLOCK));
    public static final RegistryObject<Block> NIGHTSHADE_BERRY_CAKE = HELPER.createBlockNoItem("nightshade_berry_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.NIGHTSHADE_BERRY_CAKE, Properties.NIGHTSHADE_BERRY_CAKE));

    //Zure Berry Flavor
    public static final RegistryObject<Block> ZURE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("zure_berry_ice_cream_block", () -> new Block(Properties.ZURE_BERRY_ICE_CREAM_BLOCK), ModCompat.ENLIGHTEND_BLOCK);
    public static final RegistryObject<Block> ZURE_BERRY_CAKE = HELPER.createBlockNoItem("zure_berry_cake", () -> new ExquisitoCakeBlock(ExquisitoItems.ExquisitoFoods.ZURE_BERRY_CAKE, Properties.ZURE_BERRY_CAKE));

    //Elmond Flavor
    public static final RegistryObject<Block> ELMOND_BLOCK = HELPER.createBlock("elmond_block", () -> new Block(Properties.ELMOND_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> WARZIPAN_BLOCK = HELPER.createBlock("warzipan_block", () -> new Block(Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> WARZIPAN_BRICKS = HELPER.createBlock("warzipan_bricks", () -> new Block(Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> WARZIPAN_BRICK_SLAB = HELPER.createBlock("warzipan_brick_slab", () -> new SlabBlock(Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> WARZIPAN_BRICK_STAIRS = HELPER.createBlock("warzipan_brick_stairs", () -> new StairBlock(() -> WARZIPAN_BRICKS.get().defaultBlockState(),Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICKS = HELPER.createBlock("dessert_checkered_bricks", () -> new Block(Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICK_SLAB = HELPER.createBlock("dessert_checkered_brick_slab", () -> new SlabBlock(Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> DESSERT_CHECKERED_BRICK_STAIRS = HELPER.createBlock("dessert_checkered_brick_stairs", () -> new StairBlock(() -> DESSERT_CHECKERED_BRICKS.get().defaultBlockState(),Properties.WARZIPAN_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_BLOCK = HELPER.createBlock("carmotine_block", () -> new Block(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_SLAB = HELPER.createBlock("carmotine_slab", () -> new SlabBlock(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_STAIRS = HELPER.createBlock("carmotine_stairs", () -> new StairBlock(() -> CARMOTINE_BLOCK.get().defaultBlockState(),Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_BRICKS = HELPER.createBlock("carmotine_bricks", () -> new Block(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_BRICK_SLAB = HELPER.createBlock("carmotine_brick_slab", () -> new SlabBlock(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_BRICK_STAIRS = HELPER.createBlock("carmotine_brick_stairs", () -> new StairBlock(() -> CARMOTINE_BRICKS.get().defaultBlockState(),Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_PILLAR = HELPER.createBlock("carmotine_pillar", () -> new RotatedPillarBlock(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> WEATHERED_CARMOTINE_MURAL = HELPER.createBlock("weathered_carmotine_mural", () -> new Block(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> RUINED_CARMOTINE_MURAL = HELPER.createBlock("ruined_carmotine_mural", () -> new Block(Properties.CARMOTINE_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CARMOTINE_LADDER = HELPER.createBlock("carmotine_ladder", () -> new LadderBlock(Properties.CARMOTINE_LADDER), (CreativeModeTab.TAB_DECORATIONS));
    public static final RegistryObject<Block> ABANDONED_VESSEL = HELPER.createBlock("abandoned_vessel", () -> new Block(Properties.ABANDONED_VESSEL), (CreativeModeTab.TAB_DECORATIONS));
    public static final RegistryObject<Block> BATTENLIGHT = HELPER.createBlock("battenlight", () -> new Block(Properties.BATTENLIGHT), (CreativeModeTab.TAB_DECORATIONS));

    public static final RegistryObject<Block> OVERWORLD_ELMOND_CROP = HELPER.createBlockNoItem("overworld_elmond_crop", () -> new OverworldElmondCropBlock(Properties.OVERWORLD_ELMOND_CROP));
    public static final RegistryObject<Block> ATTACHED_OVERWORLD_ELMOND_CROP = HELPER.createBlockNoItem("attached_overworld_elmond_crop", () -> new AttachedOverworldElmondCropBlock(Properties.OVERWORLD_ELMOND_CROP));
    public static final RegistryObject<Block> OVERWORLD_ELMOND_FRUIT = HELPER.createBlockNoItem("overworld_elmond_fruit", () -> new OverworldElmondFruitBlock(Properties.OVERWORLD_ELMOND_FRUIT));
    public static final RegistryObject<Block> END_ELMOND_PLANT = HELPER.createBlockNoItem("end_elmond_plant", () -> new EndElmondPlantBlock(Properties.END_ELMOND));
    public static final RegistryObject<Block> END_ELMOND_FLOWER = HELPER.createBlockNoItem("end_elmond_flower", () -> new EndElmondFlowerBlock((EndElmondPlantBlock) ExquisitoBlocks.END_ELMOND_PLANT.get(), Properties.END_ELMOND));

    static class Properties {
        //Ice Cream Blocks
        public static final BlockBehaviour.Properties CHORUS_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_PURPLE).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties JELLY_RING_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_PINK).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties NIGHTSHADE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_BLUE).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties ZURE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_LIGHT_BLUE).strength(0.2F).sound(SoundType.SNOW);

        //Cakes
        public static final Block.Properties CHORUS_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_PURPLE).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties JELLY_RING_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties NIGHTSHADE_BERRY_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties ZURE_BERRY_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_LIGHT_BLUE).strength(0.5F).sound(SoundType.WOOL);

        //Elmond
        public static final BlockBehaviour.Properties ELMOND_BLOCK = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.RAW_IRON).strength(0.5F, 2.0F).sound(SoundType.MUD);
        public static final BlockBehaviour.Properties WARZIPAN_BLOCK = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.RAW_IRON).strength(1.0F, 4.0F).sound(SoundType.STONE);
        public static final BlockBehaviour.Properties CARMOTINE_BLOCK = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.DEEPSLATE);
        public static final BlockBehaviour.Properties CARMOTINE_LADDER = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(0.4F).sound(SoundType.DEEPSLATE).noOcclusion();
        public static final BlockBehaviour.Properties ABANDONED_VESSEL = BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_MAGENTA).strength(0.4F).noOcclusion().sound(SoundType.GLASS).lightLevel(value -> 6);
        public static final BlockBehaviour.Properties BATTENLIGHT = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.RAW_IRON).strength(0.5F).sound(SoundType.DEEPSLATE).lightLevel(value -> 15);
        public static final BlockBehaviour.Properties OVERWORLD_ELMOND_CROP = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_RED).instabreak().noCollission().sound(SoundType.GRASS);
        public static final BlockBehaviour.Properties OVERWORLD_ELMOND_FRUIT = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.SNOW).instabreak().noCollission().sound(SoundType.MUD).lightLevel(value -> 10);
        public static final BlockBehaviour.Properties END_ELMOND = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_RED).strength(0.5F, 2.0F).noOcclusion().sound(SoundType.MUD);

        //Crates
        public static final BlockBehaviour.Properties JELLY_RING_CRATE = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(1.5F).sound(SoundType.WOOD);
    }
}

