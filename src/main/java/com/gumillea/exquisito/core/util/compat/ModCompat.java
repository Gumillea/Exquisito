package com.gumillea.exquisito.core.util.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;

public class ModCompat {
    public static final String B = "byg";
    public static final String DF = "delightful";
    public static final String ED = "ends_delight";
    public static final String EED = "enlightened_end";
    public static final String UE = "unusualend";
    public static final String ERD = "endersdelight";
    public static final String VC = "vanillacookbook";

    //Resource Locations
    public static ResourceLocation RINGLING_RESOURCE = new ResourceLocation(EED, "ringling");
    public static ResourceLocation STALKER_RESOURCE = new ResourceLocation(EED, "stalker");
    public static ResourceLocation SQUELCHER_RESOURCE = new ResourceLocation(EED, "squelcher");

    //Tabs
    public static final CreativeModeTab ENLIGHTEND_ITEM = ((ModList.get().isLoaded(EED)) ? (CreativeModeTab.TAB_FOOD) : null);
    public static final CreativeModeTab ENLIGHTEND_ITEM_ALTERNATE = ((ModList.get().isLoaded(EED)) ? null : (CreativeModeTab.TAB_FOOD));
    public static final CreativeModeTab ENLIGHTEND_BLOCK = ((ModList.get().isLoaded(EED)) ? (CreativeModeTab.TAB_BUILDING_BLOCKS) : null);
    public static final CreativeModeTab BYG_ITEM = ((ModList.get().isLoaded(B)) ? (CreativeModeTab.TAB_FOOD) : null);
    public static final CreativeModeTab BYG_ITEM_ALTERNATE = ((ModList.get().isLoaded(B)) ? null : (CreativeModeTab.TAB_FOOD));
    public static final CreativeModeTab BYG_BLOCK = ((ModList.get().isLoaded(B)) ? (CreativeModeTab.TAB_BUILDING_BLOCKS) : null);
}

