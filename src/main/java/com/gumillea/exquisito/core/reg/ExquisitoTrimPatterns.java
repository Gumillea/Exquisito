package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.core.Exquisito;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.ForgeRegistries;

public class ExquisitoTrimPatterns {
    public static final ResourceKey<TrimPattern> EMBRYO = createKey("embryo");
    public static final ResourceKey<TrimPattern> KNOT = createKey("knot");

    public static void bootstrap(BootstapContext<TrimPattern> context) {
        register(context, EMBRYO, ExquisitoItems.EMBRYO_ARMOR_TRIM_SMITHING_TEMPLATE.get());
        register(context, KNOT, ExquisitoItems.KNOT_ARMOR_TRIM_SMITHING_TEMPLATE.get());
    }

    public static ResourceKey<TrimPattern> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation(Exquisito.MODID, name));
    }

    private static void register(BootstapContext<TrimPattern> context, ResourceKey<TrimPattern> key, Item item) {
        context.register(key, new TrimPattern(key.location(), ForgeRegistries.ITEMS.getHolder(item).get(), Component.translatable(Util.makeDescriptionId("trim_pattern", key.location()))));
    }
}
