package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.common.block.FlavoredCakeBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Exquisito.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExquisitoBlocks {
    public static final BlockSubRegistryHelper HELPER = Exquisito.REGISTRY_HELPER.getBlockSubHelper();

    //Chorus Fruit Flavor
    public static final RegistryObject<Block> CHORUS_ICE_CREAM_BLOCK = HELPER.createBlock("chorus_ice_cream_block", () -> new Block(Properties.CHORUS_ICE_CREAM_BLOCK), (CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> CHORUS_CAKE = HELPER.createBlockNoItem("chorus_cake", () -> new FlavoredCakeBlock(ExquisitoItems.ExquisitoFoods.CHORUS_CAKE, Properties.CHORUS_CAKE));

    //Jelly Ring Flavor
    public static final RegistryObject<Block> JELLY_RING_ICE_CREAM_BLOCK = HELPER.createBlock("jelly_ring_ice_cream_block", () -> new Block(Properties.JELLY_RING_ICE_CREAM_BLOCK), ModCompat.ENLIGHTEND_BLOCK);
    public static final RegistryObject<Block> JELLY_RING_CAKE = HELPER.createBlockNoItem("jelly_ring_cake", () -> new FlavoredCakeBlock(ExquisitoItems.ExquisitoFoods.JELLY_RING_CAKE, Properties.JELLY_RING_CAKE));

    //Zure Berry Flavor
    public static final RegistryObject<Block> ZURE_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("zure_berry_ice_cream_block", () -> new Block(Properties.ZURE_BERRY_ICE_CREAM_BLOCK), ModCompat.ENLIGHTEND_BLOCK);
    public static final RegistryObject<Block> ZURE_BERRY_CAKE = HELPER.createBlockNoItem("zure_berry_cake", () -> new FlavoredCakeBlock(ExquisitoItems.ExquisitoFoods.ZURE_BERRY_CAKE, Properties.ZURE_BERRY_CAKE));

    static class Properties {
        //Ice Cream Blocks
        public static final BlockBehaviour.Properties CHORUS_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_PURPLE).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties JELLY_RING_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_PINK).strength(0.2F).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties ZURE_BERRY_ICE_CREAM_BLOCK = BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_LIGHT_BLUE).strength(0.2F).sound(SoundType.SNOW);

        //Cakes
        public static final Block.Properties CHORUS_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_PURPLE).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties JELLY_RING_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOL);
        public static final Block.Properties ZURE_BERRY_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_LIGHT_BLUE).strength(0.5F).sound(SoundType.WOOL);
    }
}

