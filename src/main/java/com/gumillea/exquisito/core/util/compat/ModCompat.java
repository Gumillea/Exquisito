package com.gumillea.exquisito.core.util.compat;

import com.teamabnormals.berry_good.core.registry.BGItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

import java.util.Objects;

public class ModCompat {
    public static final String B = "byg";
    public static final String BG = "berry_good";
    public static final String BE = "betterend";
    public static final String CR = "collectorsreap";
    public static final String DF = "delightful";
    public static final String ED = "ends_delight";
    public static final String EED = "enlightened_end";
    public static final String FD = "farmersdelight";
    public static final String UE = "unusualend";
    public static final String ERD = "endersdelight";
    public static final String VC = "vanillacookbook";

    //Resource Locations
    public static ResourceLocation RINGLING_RESOURCE = new ResourceLocation(EED, "ringling");
    public static ResourceLocation STALKER_RESOURCE = new ResourceLocation(EED, "stalker");
    public static ResourceLocation SQUELCHER_RESOURCE = new ResourceLocation(EED, "squelcher");

    public static ResourceLocation NIGHTSHADE_BERRY = new ResourceLocation(B, "nightshade_berries");
    public static ResourceLocation ETHER_BULB = new ResourceLocation(B, "ether_bulbs");
    public static ResourceLocation BLOSSOM_BERRY = new ResourceLocation(BE, "blossom_berry");
    public static ResourceLocation SHADOW_BERRY = new ResourceLocation(BE, "shadow_berry_raw");

    public static final ResourceLocation CAKE_SLICE = new ResourceLocation(ModCompat.FD, "cake_slice");
    public static final ResourceLocation PIE_SLICE = new ResourceLocation(ModCompat.FD, "chocolate_pie_slice");
    public static final ResourceLocation GUMMY = new ResourceLocation(ModCompat.CR, "lime_gummy");


}

