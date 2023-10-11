package com.gumillea.exquisito.core.reg;

import com.teamabnormals.blueprint.core.util.DataUtil;

public class ExquisitoCompostableItems {
    public static void registerCompostableItems() {
        registerCompostable();
    }
    private static void registerCompostable() {
        //Cakes
        DataUtil.registerCompostable(ExquisitoItems.CHORUS_CAKE.get(), 1.00F);
        DataUtil.registerCompostable(ExquisitoItems.ETHER_BULB_CAKE.get(), 1.00F);
        DataUtil.registerCompostable(ExquisitoItems.JELLY_RING_CAKE.get(), 1.00F);
        DataUtil.registerCompostable(ExquisitoItems.NIGHTSHADE_BERRY_CAKE.get(), 1.00F);
        DataUtil.registerCompostable(ExquisitoItems.ZURE_BERRY_CAKE.get(), 1.00F);

        //Cookies
        DataUtil.registerCompostable(ExquisitoItems.CHORUS_COOKIE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.ETHER_BULB_COOKIE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.JELLY_RING_COOKIE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.NIGHTSHADE_BERRY_COOKIE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.ZURE_BERRY_COOKIE.get(), 0.85F);

        //Slices
        DataUtil.registerCompostable(ExquisitoItems.CHORUS_CAKE_SLICE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.ETHER_BULB_CAKE_SLICE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.JELLY_RING_CAKE_SLICE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.NIGHTSHADE_BERRY_CAKE_SLICE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.ZURE_BERRY_CAKE_SLICE.get(), 0.85F);

        //Others
        DataUtil.registerCompostable(ExquisitoItems.CHORUS_KHANOM_CHAN.get(), 0.65F);
        DataUtil.registerCompostable(ExquisitoItems.ENLIGHTENED_BATTENBERG_CAKE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.BELOVED_BATTENBERG_CAKE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.JELLY_FILLED_CHOCOLATE.get(), 0.85F);
        DataUtil.registerCompostable(ExquisitoItems.CHOCOLATE_RINGLING.get(), 1.00F);
    }
}
