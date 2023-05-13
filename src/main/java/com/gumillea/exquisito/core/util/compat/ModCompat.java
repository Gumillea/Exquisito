package com.gumillea.exquisito.core.util.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;

public class ModCompat {
    public static final String EED = "enlightened_end";
    public static final String ED = "ends_delight";
    public static final String UE = "unusualend";

    //Resource Locations
    public static ResourceLocation RINGLING_RESOURCE = new ResourceLocation(EED, "big_ringling");
    public static ResourceLocation STALKER_RESOURCE = new ResourceLocation(EED, "stalker");
    public static ResourceLocation SQUELCHER_RESOURCE = new ResourceLocation(EED, "squelcher");

    //Tabs
    public static final CreativeModeTab ENLIGHTEND_ITEM = ((ModList.get().isLoaded(EED)) ? (CreativeModeTab.TAB_FOOD) : null);
    public static final CreativeModeTab ENLIGHTEND_BLOCK = ((ModList.get().isLoaded(EED)) ? (CreativeModeTab.TAB_BUILDING_BLOCKS) : null);
}

