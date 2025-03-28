package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.core.Exquisito;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class ExquisitoTrimMaterials {
    public static final ResourceKey<TrimMaterial> CARMOTINE = createKey("carmotine");
    public static final ResourceKey<TrimMaterial> CHORUS = createKey("chorus");
    public static void bootstrap(BootstapContext<TrimMaterial> context) {
        register(context, CARMOTINE, ExquisitoItems.CARMOTINE.get(), Style.EMPTY.withColor(0xE1597F), Map.of());
        register(context, CHORUS, Items.POPPED_CHORUS_FRUIT, Style.EMPTY.withColor(0x643C64), Map.of());
    }

    private static ResourceKey<TrimMaterial> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(Exquisito.MODID, name));
    }

    private static void register(BootstapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Item item, Style style, Map<ArmorMaterials, String> overrides) {
        ResourceLocation location = key.location();
        context.register(key, new TrimMaterial(location.getNamespace() + "_" + location.getPath(), ForgeRegistries.ITEMS.getHolder(item).get(), -1.0F, overrides, Component.translatable(Util.makeDescriptionId("trim_material", location)).withStyle(style)));
    }

}
