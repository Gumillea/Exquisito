package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.common.item.*;
import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.ExquisitoConfig;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.common.item.IceCreamItem;
import com.teamabnormals.neapolitan.common.item.MilkshakeItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

import java.util.function.Predicate;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = Exquisito.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExquisitoItems {
    public static final ItemSubRegistryHelper HELPER = Exquisito.REGISTRY_HELPER.getItemSubHelper();

    //Chorus Fruit Flavor
    public static final RegistryObject<Item> CHORUS_ICE_CREAM = HELPER.createItem("chorus_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.CHORUS_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> CHORUS_CAKE = HELPER.createItem("chorus_cake", () -> new BlockItem(ExquisitoBlocks.CHORUS_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CHORUS_CAKE_SLICE = HELPER.createItem("chorus_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.CHORUS_CAKE)));
    public static final RegistryObject<Item> CHORUS_MILKSHAKE = HELPER.createItem("chorus_milkshake", () -> new MilkshakeItem(new Item.Properties().food(ExquisitoFoods.CHORUS_MILKSHAKE).stacksTo(16)));
    public static final RegistryObject<Item> CHORUS_COOKIE = HELPER.createItem("chorus_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.CHORUS_COOKIE)));
    public static final RegistryObject<Item> CHORUS_KHANOM_CHAN = HELPER.createItem("chorus_khanom_chan", () -> new Item(new Item.Properties().food(ExquisitoFoods.CHORUS_KHANOM_CHAN)));

    //Jelly Ring Flavor
    public static final RegistryObject<Item> JELLY_RING_ICE_CREAM = HELPER.createItem("jelly_ring_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.JELLY_RING_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> JELLY_RING_CAKE = HELPER.createItem("jelly_ring_cake", () -> new BlockItem(ExquisitoBlocks.JELLY_RING_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JELLY_RING_CAKE_SLICE = HELPER.createItem("jelly_ring_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING_CAKE)));
    public static final RegistryObject<Item> JELLY_RING_MILKSHAKE = HELPER.createItem("jelly_ring_milkshake", () -> new MilkshakeItem(new Item.Properties().food(ExquisitoFoods.JELLY_RING_MILKSHAKE).stacksTo(16)));
    public static final RegistryObject<Item> JELLY_RING_COOKIE = HELPER.createItem("jelly_ring_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING_COOKIE)));
    public static final RegistryObject<Item> FUSCHIA_SMOOTHIE_BOWL = HELPER.createItem("fuschia_smoothie_bowl", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.FUSCHIA_SMOOTHIE_BOWL).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> JELLY_RING = HELPER.createItem("jelly_ring", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING)));

    //Zure Berry Flavor
    public static final RegistryObject<Item> ZURE_BERRY_ICE_CREAM = HELPER.createItem("zure_berry_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> ZURE_BERRY_CAKE = HELPER.createItem("zure_berry_cake", () -> new BlockItem(ExquisitoBlocks.ZURE_BERRY_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ZURE_BERRY_CAKE_SLICE = HELPER.createItem("zure_berry_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_CAKE)));
    public static final RegistryObject<Item> ZURE_BERRY_MILKSHAKE = HELPER.createItem("zure_berry_milkshake", () -> new MilkshakeItem(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_MILKSHAKE).stacksTo(16)));
    public static final RegistryObject<Item> ZURE_BERRY_COOKIE = HELPER.createItem("zure_berry_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_COOKIE)));
    public static final RegistryObject<Item> ENDERNEATH_SALAD = HELPER.createItem("enderneath_salad", () -> new BowlFoodItem(new Item.Properties().food(ExquisitoFoods.ENDERNEATH_SALAD).craftRemainder(Items.BOWL).stacksTo(1)));

    //Ether Bulb Flavor
    public static final RegistryObject<Item> STARCLOUD_BULBS = HELPER.createItem("starcloud_bulbs", () -> new Item(new Item.Properties().food(ExquisitoFoods.STARCLOUD_BULBS)));
    public static final RegistryObject<Item> ETHER_BULB_ICE_CREAM = HELPER.createItem("ether_bulb_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> ETHER_BULB_CAKE = HELPER.createItem("ether_bulb_cake", () -> new BlockItem(ExquisitoBlocks.ETHER_BULB_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ETHER_BULB_CAKE_SLICE = HELPER.createItem("ether_bulb_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_CAKE)));
    public static final RegistryObject<Item> ETHER_BULB_MILKSHAKE = HELPER.createItem("ether_bulb_milkshake", () -> new MilkshakeItem(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_MILKSHAKE).stacksTo(16)));
    public static final RegistryObject<Item> ETHER_BULB_PARFAIT = HELPER.createItem("ether_bulb_parfait", () -> new ParfaitItem(new Item.Properties()));
    public static final RegistryObject<Item> ETHER_BULB_COOKIE = HELPER.createItem("ether_bulb_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_COOKIE)));
    public static final RegistryObject<Item> ETHER_LOLLIPOP = HELPER.createItem("ether_lollipop", () -> new LollipopItem((new Item.Properties().food(ExquisitoFoods.ETHER_LOLLIPOP).craftRemainder(Items.STICK))));
    public static final RegistryObject<Item> NIGHTSHADE_LOLLIPOP = HELPER.createItem("nightshade_lollipop", () -> new LollipopItem((new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_LOLLIPOP).craftRemainder(Items.STICK))));

    //Nightshade Berry Flavor
    public static final RegistryObject<Item> MIDNIGHT_BERRIES = HELPER.createItem("midnight_berries", () -> new Item(new Item.Properties().food(ExquisitoFoods.MIDNIGHT_BERRIES)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_ICE_CREAM = HELPER.createItem("nightshade_berry_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_CAKE = HELPER.createItem("nightshade_berry_cake", () -> new BlockItem(ExquisitoBlocks.NIGHTSHADE_BERRY_CAKE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_CAKE_SLICE = HELPER.createItem("nightshade_berry_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_CAKE)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_MILKSHAKE = HELPER.createItem("nightshade_berry_milkshake", () -> new MilkshakeItem(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_MILKSHAKE).stacksTo(16)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_PARFAIT = HELPER.createItem("nightshade_berry_parfait", () -> new ParfaitItem(new Item.Properties()));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_COOKIE = HELPER.createItem("nightshade_berry_cookie", () -> new Item(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_COOKIE)));

    //Elmond Flavor
    public static final RegistryObject<Item> ELMOND = HELPER.createItem("elmond", () -> new ElmondItem(new Item.Properties()));
    public static final RegistryObject<Item> CARMOTINE = HELPER.createItem("carmotine", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ABANDONED_CORE = HELPER.createItem("abandoned_core", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> WARZIPAN = HELPER.createItem("warzipan", () -> new Item(new Item.Properties().food(ExquisitoFoods.WARZIPAN)));
    public static final RegistryObject<Item> WARZIPAN_ICE_CREAM = HELPER.createItem("warzipan_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.WARZIPAN_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> WARZIPAN_MILKSHAKE = HELPER.createItem("warzipan_milkshake", () -> new MilkshakeItem(new Item.Properties().food(ExquisitoFoods.WARZIPAN_MILKSHAKE).stacksTo(16)));

    public static final RegistryObject<Item> JELLY_RING_WARZIPAN = HELPER.createItem("jelly_ring_warzipan", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING_WARZIPAN)));
    public static final RegistryObject<Item> ZURE_BERRY_WARZIPAN = HELPER.createItem("zure_berry_warzipan", () -> new Item(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_WARZIPAN)));
    public static final RegistryObject<Item> ETHER_BULB_WARZIPAN = HELPER.createItem("ether_bulb_warzipan", () -> new Item(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_WARZIPAN)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_WARZIPAN = HELPER.createItem("nightshade_berry_warzipan", () -> new Item(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_WARZIPAN)));

    public static final RegistryObject<Item> BELOVED_BATTENBERG_CAKE = HELPER.createItem("beloved_battenberg_cake", () -> new Item(new Item.Properties().food(ExquisitoFoods.BELOVED_BATTENBERG_CAKE)));
    public static final RegistryObject<Item> BELOVED_BATTENBERG_CAKE_SLICE = HELPER.createItem("beloved_battenberg_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.BELOVED_BATTENBERG_CAKE_SLICE)));
    public static final RegistryObject<Item> ENLIGHTENED_BATTENBERG_CAKE = HELPER.createItem("enlightened_battenberg_cake", () -> new Item(new Item.Properties().food(ExquisitoFoods.ENLIGHTENED_BATTENBERG_CAKE)));
    public static final RegistryObject<Item> ENLIGHTENED_BATTENBERG_CAKE_SLICE = HELPER.createItem("enlightened_battenberg_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.ENLIGHTENED_BATTENBERG_CAKE_SLICE)));
    public static final RegistryObject<Item> EXQUISITE_BATTENBERG_CAKE = HELPER.createItem("exquisite_battenberg_cake", () -> new Item(new Item.Properties().food(ExquisitoFoods.EXQUISITE_BATTENBERG_CAKE)));
    public static final RegistryObject<Item> EXQUISITE_BATTENBERG_CAKE_SLICE = HELPER.createItem("exquisite_battenberg_cake_slice", () -> new Item(new Item.Properties().food(ExquisitoFoods.EXQUISITE_BATTENBERG_CAKE_SLICE)));
    public static final RegistryObject<Item> RESPITEFUL_BATTENBERG_CAKE = HELPER.createItem("respiteful_battenberg_cake", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SURREAL_BATTENBERG_CAKE = HELPER.createItem("surreal_battenberg_cake", () -> new Item(new Item.Properties()));

    //Mix
    public static final RegistryObject<Item> JELLY_FILLED_CHOCOLATE = HELPER.createItem("jelly_filled_chocolate", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_FILLED_CHOCOLATE)));
    public static final RegistryObject<Item> HALO_HALO = HELPER.createItem("halo_halo", () -> new IceCreamItem(new Item.Properties().food(ExquisitoFoods.HALO_HALO)));
    public static final RegistryObject<Item> RAW_STALKER_SKEWER = HELPER.createItem("raw_stalker_skewer", () -> new SkewerItem(new Item.Properties().food(ExquisitoFoods.RAW_STALKER_SKEWER)));
    public static final RegistryObject<Item> STALKER_SKEWER = HELPER.createItem("stalker_skewer", () -> new SkewerItem(new Item.Properties().food(ExquisitoFoods.STALKER_SKEWER)));

    //Gummy
    public static final RegistryObject<Item> CHORUS_GUMMY = HELPER.createItem("chorus_gummy", () -> new Item(new Item.Properties().food(ExquisitoFoods.CHORUS_BULB_GUMMY)));
    public static final RegistryObject<Item> JELLY_RING_GUMMY = HELPER.createItem("jelly_ring_gummy", () -> new Item(new Item.Properties().food(ExquisitoFoods.JELLY_RING_GUMMY)));
    public static final RegistryObject<Item> ZURE_BERRY_GUMMY = HELPER.createItem("zure_berry_gummy", () -> new Item(new Item.Properties().food(ExquisitoFoods.ZURE_BERRY_GUMMY)));
    public static final RegistryObject<Item> ETHER_BULB_GUMMY = HELPER.createItem("ether_bulb_gummy", () -> new Item(new Item.Properties().food(ExquisitoFoods.ETHER_BULB_GUMMY)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_GUMMY = HELPER.createItem("nightshade_berry_gummy", () -> new Item(new Item.Properties().food(ExquisitoFoods.NIGHTSHADE_BERRY_GUMMY)));
    public static final RegistryObject<Item> WARZIPAN_GUMMY = HELPER.createItem("warzipan_gummy", () -> new Item(new Item.Properties().food(ExquisitoFoods.WARZIPAN_GUMMY)));

    //Other
    public static final RegistryObject<Item> SPACE_DIVING_ICON = HELPER.createItem("space_diving_icon", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EMBRYO_ARMOR_TRIM_SMITHING_TEMPLATE = HELPER.createItem("embryo_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(ExquisitoTrimPatterns.EMBRYO));
    public static final RegistryObject<Item> KNOT_ARMOR_TRIM_SMITHING_TEMPLATE = HELPER.createItem("knot_armor_trim_smithing_template", () -> SmithingTemplateItem.createArmorTrimTemplate(ExquisitoTrimPatterns.KNOT));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(Exquisito.MODID)
                .predicate(event -> ExquisitoConfig.Common.CHORUS_FLAVOR.get() && event.getTabKey() == FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.PUMPKIN_PIE), CHORUS_KHANOM_CHAN)
                .addItemsBefore(of(Items.MILK_BUCKET), HALO_HALO)
                .addItemsAfter(of(Items.MILK_BUCKET), CHORUS_MILKSHAKE, CHORUS_ICE_CREAM)
                .addItemsAfter(of(Items.CAKE), CHORUS_CAKE)
                .addItemsAfter(of(Items.COOKIE), CHORUS_COOKIE)

                .predicate(event -> ExquisitoConfig.Common.ELMOND_FLAVOR.get() && event.getTabKey() == FOOD_AND_DRINKS)
                .addItemsBefore(of(Items.COOKIE), WARZIPAN, JELLY_RING_WARZIPAN, ZURE_BERRY_WARZIPAN, ETHER_BULB_WARZIPAN, NIGHTSHADE_BERRY_WARZIPAN)
                .addItemsAfter(of(Items.MILK_BUCKET), WARZIPAN_MILKSHAKE, WARZIPAN_ICE_CREAM)
                .addItemsAfter(of(Items.PUMPKIN_PIE), BELOVED_BATTENBERG_CAKE, EXQUISITE_BATTENBERG_CAKE)
                .addItemsAfter(modLoaded(EXQUISITE_BATTENBERG_CAKE, ModCompat.EED), ENLIGHTENED_BATTENBERG_CAKE)

                .predicate(event -> ModList.get().isLoaded(ModCompat.EED) && ExquisitoConfig.Common.ZURE_BERRY_FLAVOR.get() && event.getTabKey() == FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.COOKED_RABBIT), RAW_STALKER_SKEWER, STALKER_SKEWER)
                .addItemsAfter(of(Items.RABBIT_STEW), ENDERNEATH_SALAD)
                .addItemsAfter(of(Items.MILK_BUCKET), ZURE_BERRY_MILKSHAKE, ZURE_BERRY_ICE_CREAM)
                .addItemsAfter(of(Items.CAKE), ZURE_BERRY_CAKE)
                .addItemsAfter(of(Items.COOKIE), ZURE_BERRY_COOKIE)

                .predicate(event -> ModList.get().isLoaded(ModCompat.EED) && ExquisitoConfig.Common.JELLY_RING_FLAVOR.get() && event.getTabKey() == FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.COOKIE), JELLY_RING, JELLY_FILLED_CHOCOLATE)
                .addItemsAfter(of(Items.RABBIT_STEW), FUSCHIA_SMOOTHIE_BOWL)
                .addItemsAfter(of(Items.MILK_BUCKET), JELLY_RING_MILKSHAKE, JELLY_RING_ICE_CREAM)
                .addItemsAfter(of(Items.CAKE), JELLY_RING_CAKE)
                .addItemsAfter(of(Items.COOKIE), JELLY_RING_COOKIE)

                .predicate(event -> ExquisitoConfig.Common.ETHER_BULB_FLAVOR.get() && event.getTabKey() == FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.GLOW_BERRIES), STARCLOUD_BULBS)
                .addItemsAfter(of(Items.PUMPKIN_PIE), ETHER_LOLLIPOP)
                .addItemsBefore(of(Items.MILK_BUCKET), ETHER_BULB_PARFAIT)
                .addItemsAfter(of(Items.MILK_BUCKET), ETHER_BULB_MILKSHAKE, ETHER_BULB_ICE_CREAM)
                .addItemsAfter(of(Items.CAKE), ETHER_BULB_CAKE)
                .addItemsAfter(of(Items.COOKIE), ETHER_BULB_COOKIE)

                .predicate(event -> ExquisitoConfig.Common.NIGHTSHADE_BERRY_FLAVOR.get() && event.getTabKey() == FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.GLOW_BERRIES), MIDNIGHT_BERRIES)
                .addItemsAfter(of(Items.PUMPKIN_PIE), NIGHTSHADE_LOLLIPOP)
                .addItemsBefore(of(Items.MILK_BUCKET), NIGHTSHADE_BERRY_PARFAIT)
                .addItemsAfter(of(Items.MILK_BUCKET), NIGHTSHADE_BERRY_MILKSHAKE, NIGHTSHADE_BERRY_ICE_CREAM)
                .addItemsAfter(of(Items.CAKE), NIGHTSHADE_BERRY_CAKE)
                .addItemsAfter(of(Items.COOKIE), NIGHTSHADE_BERRY_COOKIE)

                .predicate(event -> ExquisitoConfig.Common.ELMOND_FLAVOR.get() && event.getTabKey() == INGREDIENTS)
                .addItemsAfter(of(Items.HEART_OF_THE_SEA), ABANDONED_CORE)
                .addItemsAfter(of(Items.POPPED_CHORUS_FRUIT), CARMOTINE)
                .addItemsAfter(of(Items.SLIME_BALL), ELMOND)
                .addItemsAfter(of(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE), EMBRYO_ARMOR_TRIM_SMITHING_TEMPLATE, KNOT_ARMOR_TRIM_SMITHING_TEMPLATE)

                .predicate(event -> ModList.get().isLoaded(ModCompat.FD) && event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey())
                .addItemsAfter(ofID(ModCompat.CAKE_SLICE), CHORUS_CAKE_SLICE)
                .addItemsAfter(modLoaded(CHORUS_CAKE_SLICE, ModCompat.EED), JELLY_RING_CAKE_SLICE, ZURE_BERRY_CAKE_SLICE)
                .addItemsAfter(modLoaded(CHORUS_CAKE_SLICE), ETHER_BULB_CAKE_SLICE, NIGHTSHADE_BERRY_CAKE_SLICE)

                .addItemsAfter(ofID(ModCompat.PIE_SLICE), BELOVED_BATTENBERG_CAKE_SLICE, EXQUISITE_BATTENBERG_CAKE_SLICE)
                .addItemsAfter(modLoaded(EXQUISITE_BATTENBERG_CAKE_SLICE, ModCompat.EED), ENLIGHTENED_BATTENBERG_CAKE_SLICE)

                .predicate(event -> ModList.get().isLoaded(ModCompat.CR) && event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey())
                .addItemsBefore(ofID(ModCompat.CAKE_SLICE), CHORUS_GUMMY, WARZIPAN_GUMMY)
                .addItemsAfter(modLoaded(WARZIPAN_GUMMY, ModCompat.EED), JELLY_RING_GUMMY, ZURE_BERRY_GUMMY)
                .addItemsAfter(modLoaded(WARZIPAN_GUMMY), ETHER_BULB_GUMMY, NIGHTSHADE_BERRY_GUMMY)
        ;
    }

    public static Predicate<ItemStack> modLoaded(ItemLike item, String... modids) {
        return stack -> of(item).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }

    public static Predicate<ItemStack> modLoaded(RegistryObject<Item> item, String... modids) {
        return stack -> item.get() != null && of(item.get()).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }

    public static Predicate<ItemStack> ofID(ResourceLocation location, String... modids) {
        return stack -> (BlockSubRegistryHelper.areModsLoaded(modids) && of(ForgeRegistries.ITEMS.getValue(location)).test(stack));
    }

    static class ExquisitoFoods {
        //Ice Creams
        public static final FoodProperties CHORUS_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 1200), 1.0F).build();
        public static final FoodProperties JELLY_RING_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 600), 1.0F).build();
        public static final FoodProperties ZURE_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), -1, 2), 1.0F).build();
        public static final FoodProperties ETHER_BULB_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 600, 2), 1.0F).build();
        public static final FoodProperties NIGHTSHADE_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 600), 1.0F).build();
        public static final FoodProperties WARZIPAN_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 600, 2), 1.0F).build();

        //Cakes
        public static final FoodProperties CHORUS_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 300), 1.0F).fast().build();
        public static final FoodProperties ETHER_BULB_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 400), 1.0F).fast().build();
        public static final FoodProperties JELLY_RING_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 400), 1.0F).fast().build();
        public static final FoodProperties ZURE_BERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), -1), 1.0F).fast().build();
        public static final FoodProperties NIGHTSHADE_BERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 300), 1.0F).fast().build();

        //Cookies
        public static final FoodProperties CHORUS_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 300), 1.0F).fast().build();
        public static final FoodProperties JELLY_RING_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 100), 1.0F).fast().build();
        public static final FoodProperties ZURE_BERRY_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 100), 1.0F).fast().build();
        public static final FoodProperties ETHER_BULB_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 300), 1.0F).fast().build();
        public static final FoodProperties NIGHTSHADE_BERRY_COOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 100), 1.0F).fast().build();

        //Warzipan
        public static final FoodProperties WARZIPAN = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 400), 1.0F).build();

        public static final FoodProperties ZURE_BERRY_WARZIPAN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 200), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 600), 1.0F).build();
        public static final FoodProperties JELLY_RING_WARZIPAN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 200), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 200), 1.0F).build();
        public static final FoodProperties ETHER_BULB_WARZIPAN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 200), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 400), 1.0F).build();
        public static final FoodProperties NIGHTSHADE_BERRY_WARZIPAN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 200), 1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 200), 1.0F).build();

        public static final FoodProperties ENLIGHTENED_BATTENBERG_CAKE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.DIVER_DOWN.get(), 600), 1.0F).build();
        public static final FoodProperties ENLIGHTENED_BATTENBERG_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.DIVER_DOWN.get(), 200), 1.0F).fast().build();
        public static final FoodProperties BELOVED_BATTENBERG_CAKE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.LOVE_DELUXE.get(), 600), 1.0F).build();
        public static final FoodProperties BELOVED_BATTENBERG_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.LOVE_DELUXE.get(), 200), 1.0F).fast().build();
        public static final FoodProperties EXQUISITE_BATTENBERG_CAKE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.MONKEY_MAJIK.get(), 600), 1.0F).build();
        public static final FoodProperties EXQUISITE_BATTENBERG_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).effect(() -> new MobEffectInstance(ExquisitoEffects.MONKEY_MAJIK.get(), 200), 1.0F).fast().build();

        //Gummies
        public static final FoodProperties CHORUS_BULB_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 300), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties JELLY_RING_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties ZURE_BERRY_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties ETHER_BULB_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 200, 2), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties NIGHTSHADE_BERRY_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 200, 1), 1.0F).alwaysEat().fast().build();
        public static final FoodProperties WARZIPAN_GUMMY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 200, 2), 1.0F).alwaysEat().fast().build();

        //Milkshakes
        public static final FoodProperties CHORUS_MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 600), 1.0F).alwaysEat().build();
        public static final FoodProperties JELLY_RING_MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 300), 1.0F).alwaysEat().build();
        public static final FoodProperties ZURE_BERRY_MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 1200), 1.0F).alwaysEat().build();
        public static final FoodProperties ETHER_BULB_MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 400), 1.0F).alwaysEat().build();
        public static final FoodProperties NIGHTSHADE_BERRY_MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 200), 1.0F).alwaysEat().build();
        public static final FoodProperties WARZIPAN_MILKSHAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.MODULATION.get(), 600), 1.0F).alwaysEat().build();

        //Others
        public static final FoodProperties HALO_HALO = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 600), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 600), 1.0F).build();
        public static final FoodProperties CHORUS_KHANOM_CHAN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.RESONANCE.get(), 900), 1.0F).build();
        public static final FoodProperties ETHER_LOLLIPOP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 300), 1.0F).build();
        public static final FoodProperties NIGHTSHADE_LOLLIPOP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 60), 1.0F).build();
        public static final FoodProperties FUSCHIA_SMOOTHIE_BOWL = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 600), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 800), 1.0F).build();
        public static final FoodProperties ENDERNEATH_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), -1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1.0F).build();
        public static final FoodProperties JELLY_FILLED_CHOCOLATE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 300,1), 1.0F).build();
        public static final FoodProperties RAW_STALKER_SKEWER = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), -1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200,1), 1.0F).build();
        public static final FoodProperties STALKER_SKEWER = (new FoodProperties.Builder()).nutrition(9).saturationMod(1.0F).effect(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), -1, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200,2), 1.0F).build();

        public static final FoodProperties JELLY_RING = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(ExquisitoEffects.FUCHSIA_GOO.get(), 200), 1.0F).fast().build();
        public static final FoodProperties MIDNIGHT_BERRIES = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.MORGOTH.get(), 200), 1.0F).build();
        public static final FoodProperties STARCLOUD_BULBS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 200), 1.0F).build();
    }
}
