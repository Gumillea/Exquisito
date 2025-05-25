package com.gumillea.exquisito.core.util.compat;

import net.minecraft.resources.ResourceLocation;

public class ModCompat {
    public static final String AU = "autumnity";
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
    public static ResourceLocation RINGLING_RESOURCE = id(EED, "ringling");
    public static ResourceLocation STALKER_RESOURCE = id(EED, "stalker");
    public static ResourceLocation SQUELCHER_RESOURCE = id(EED, "squelcher");

    public static ResourceLocation NIGHTSHADE_BERRY = id(B, "nightshade_berries");
    public static ResourceLocation ETHER_BULB = id(B, "ether_bulbs");
    public static ResourceLocation BLOSSOM_BERRY = id(BE, "blossom_berry");
    public static ResourceLocation SHADOW_BERRY = id(BE, "shadow_berry_raw");
    public static ResourceLocation CHORUS_FRUIT_GRAIN = id(ED, "chorus_fruit_grain");

    public static final ResourceLocation CAKE_SLICE = id(FD, "cake_slice");
    public static final ResourceLocation PIE_SLICE = id(FD, "chocolate_pie_slice");
    public static final ResourceLocation GUMMY = id(CR, "lime_gummy");

    public static ResourceLocation id (String modid, String path) {
        return new ResourceLocation(modid, path);
    }


}

