package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.common.item.ChocolateRinglingItem;
import com.gumillea.exquisito.common.item.ExquisitoMilkshakeItem;
import com.gumillea.exquisito.common.item.ParfaitItem;
import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Exquisito.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExquisitoItems {
    public static final ItemSubRegistryHelper HELPER = Exquisito.REGISTRY_HELPER.getItemSubHelper();

    //Chorus Fruit Flavor
    public static final RegistryObject<Item> CHORUS_ICE_CREAM = HELPER.createItem("chorus_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.CHORUS_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CHORUS_CAKE = HELPER.createItem("chorus_cake", () -> new BlockItem(ExquisitoBlocks.CHORUS_CAKE.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> CHORUS_MILKSHAKE = HELPER.createItem("chorus_milkshake", () -> new ExquisitoMilkshakeItem(new Item.Properties().food(ExquisitoFoods.MILKSHAKE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CHORUS_COOKIE = HELPER.createItem("chorus_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.CHORUS_COOKIE).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CHORUS_CAKE_SLICE = HELPER.createItem("chorus_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.CHORUS_CAKE).tab(CreativeModeTab.TAB_FOOD)));

    //Jelly Ring Flavor
    public static final RegistryObject<Item> JELLY_RING_ICE_CREAM = HELPER.createItem("jelly_ring_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.JELLY_RING_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> JELLY_RING_CAKE = HELPER.createItem("jelly_ring_cake", () -> new BlockItem(ExquisitoBlocks.JELLY_RING_CAKE.get(), new Item.Properties().stacksTo(1).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> JELLY_RING_MILKSHAKE = HELPER.createItem("jelly_ring_milkshake", () -> new ExquisitoMilkshakeItem(new Item.Properties().food(ExquisitoFoods.MILKSHAKE).stacksTo(16).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> JELLY_RING_COOKIE = HELPER.createItem("jelly_ring_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING_COOKIE).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> JELLY_RING_CAKE_SLICE = HELPER.createItem("jelly_ring_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING_CAKE).tab(ModCompat.ENLIGHTEND_ITEM)));

    //Zure Berry Flavor
    public static final RegistryObject<Item> ZURE_BERRY_ICE_CREAM = HELPER.createItem("zure_berry_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> ZURE_BERRY_CAKE = HELPER.createItem("zure_berry_cake", () -> new BlockItem(ExquisitoBlocks.ZURE_BERRY_CAKE.get(), new Item.Properties().stacksTo(1).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> ZURE_BERRY_MILKSHAKE = HELPER.createItem("zure_berry_milkshake", () -> new ExquisitoMilkshakeItem(new Item.Properties().food(ExquisitoFoods.MILKSHAKE).stacksTo(16).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> ZURE_BERRY_COOKIE = HELPER.createItem("zure_berry_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_COOKIE).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> ZURE_BERRY_CAKE_SLICE = HELPER.createItem("zure_berry_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_CAKE).tab(ModCompat.ENLIGHTEND_ITEM)));

    //Ether Bulb Flavor
    public static final RegistryObject<Item> ETHER_BULB_ICE_CREAM = HELPER.createItem("ether_bulb_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> ETHER_BULB_CAKE = HELPER.createItem("ether_bulb_cake", () -> new BlockItem(ExquisitoBlocks.ETHER_BULB_CAKE.get(), new Item.Properties().stacksTo(1).tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> ETHER_BULB_CAKE_SLICE = HELPER.createItem("ether_bulb_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_CAKE).tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> ETHER_BULB_PARFAIT = HELPER.createItem("ether_bulb_parfait", () -> new ParfaitItem(new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> ETHER_BULB_COOKIE = HELPER.createItem("ether_bulb_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_COOKIE).tab(ModCompat.BYG_ITEM)));

    //Nightshade Berry Flavor
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_ICE_CREAM = HELPER.createItem("nightshade_berry_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_CAKE = HELPER.createItem("nightshade_berry_cake", () -> new BlockItem(ExquisitoBlocks.NIGHTSHADE_BERRY_CAKE.get(), new Item.Properties().stacksTo(1).tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_CAKE_SLICE = HELPER.createItem("nightshade_berry_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_CAKE).tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_PARFAIT = HELPER.createItem("nightshade_berry_parfait", () -> new ParfaitItem(new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_COOKIE = HELPER.createItem("nightshade_berry_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_COOKIE).tab(ModCompat.BYG_ITEM)));

    //Mix
    public static final RegistryObject<Item> BATTENBERG_CAKE = HELPER.createItem("battenberg_cake", () -> new Item(new Item.Properties().food(ExquisitoFoods.BATTENBERG_CAKE).tab(ModCompat.ENLIGHTEND_ITEM)));
    public static final RegistryObject<Item> CHOCOLATE_RINGLING = HELPER.createItem("chocolate_ringling", () -> new ChocolateRinglingItem(new Item.Properties().food(ExquisitoFoods.CHOCOLATE_RINGLING).stacksTo(1).tab(ModCompat.ENLIGHTEND_ITEM)));

    //Other
    public static final RegistryObject<Item> SPACE_DIVING_ICON = HELPER.createItem("space_diving_icon", () -> new Item(new Item.Properties().stacksTo(1)));

    static class ExquisitoFoods {
        //Ice Creams
        public static final FoodProperties CHORUS_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 1200), 1.0F).build();
        public static final FoodProperties JELLY_RING_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 600), 1.0F).build();
        public static final FoodProperties ZURE_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 120000, 2), 1.0F).build();
        public static final FoodProperties ETHER_BULB_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 600, 2), 1.0F).build();
        public static final FoodProperties NIGHTSHADE_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 600, 2), 1.0F).build();

        //Cakes
        public static final FoodProperties CHORUS_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 300), 1.0F).fast().build();
        public static final FoodProperties ETHER_BULB_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 400), 1.0F).fast().build();
        public static final FoodProperties JELLY_RING_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 400), 1.0F).fast().build();
        public static final FoodProperties ZURE_BERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 120000), 1.0F).fast().build();
        public static final FoodProperties NIGHTSHADE_BERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 400), 1.0F).fast().build();

        //Cookies
        public static final FoodProperties CHORUS_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 300), 1.0F).fast().build();
        public static final FoodProperties JELLY_RING_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 100), 1.0F).fast().build();
        public static final FoodProperties ZURE_BERRY_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 100), 1.0F).fast().build();
        public static final FoodProperties ETHER_BULB_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 300), 1.0F).fast().build();
        public static final FoodProperties NIGHTSHADE_BERRY_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 300), 1.0F).fast().build();

        //Others
        public static final FoodProperties MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties BATTENBERG_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 400), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 600), 1.0F).build();
        public static final FoodProperties CHOCOLATE_RINGLING = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.0F).effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 1200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 600,2), 1.0F).build();
    }
}
