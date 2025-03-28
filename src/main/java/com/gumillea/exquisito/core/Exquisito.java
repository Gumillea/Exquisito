package com.gumillea.exquisito.core;

import com.gumillea.exquisito.core.data.ExquisitoDatapackBuiltinEntriesProvider;
import com.gumillea.exquisito.core.data.ExquisitoSpriteSourceProvider;
import com.gumillea.exquisito.core.data.modifiers.ExquisitoLootModifierProvider;
import com.gumillea.exquisito.core.data.tags.*;
import com.gumillea.exquisito.core.reg.*;
import com.gumillea.exquisito.core.util.compat.FoodsCompat;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.gallery.core.data.client.GalleryAssetsRemolderProvider;
import com.teamabnormals.gallery.core.data.client.GalleryItemModelProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(Exquisito.MODID)
@Mod.EventBusSubscriber(modid = Exquisito.MODID)
public class Exquisito
{
    public static final String MODID = "exquisito";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);
    public Exquisito()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);
        ExquisitoEffects.EFFECTS.register(modEventBus);
        ExquisitoPaintingVariants.PAINTING_VARIANTS.register(modEventBus);
        ExquisitoLootConditions.LOOT_CONDITION_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::gatherData);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            ExquisitoItems.setupTabEditors();
            ExquisitoBlocks.setupTabEditors();
        });

        context.registerConfig(ModConfig.Type.COMMON, ExquisitoConfig.COMMON_SPEC);
        context.registerConfig(ModConfig.Type.CLIENT, ExquisitoConfig.CLIENT_SPEC);

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ExquisitoCauldronInteractions.registerCauldronInteractions();
            ExquisitoCompostableItems.registerCompostableItems();
            FoodsCompat.modifyFoods();
        });
    }

    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean includeServer = event.includeServer();

        ExquisitoDatapackBuiltinEntriesProvider datapackEntries = new ExquisitoDatapackBuiltinEntriesProvider(output, provider);
        generator.addProvider(includeServer, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        ExquisitoBlockTagsProvider blockTagsProvider = new ExquisitoBlockTagsProvider(output, provider, helper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new ExquisitoItemTagsProvider(output, provider, blockTagsProvider.contentsGetter(), helper));
        generator.addProvider(includeServer, new ExquisitoEntityTypeTagsProvider(output, provider, helper));
        generator.addProvider(includeServer, new ExquisitoMobEffectTagsProvider(output, provider, helper));
        generator.addProvider(includeServer, new ExquisitoBiomeTagsProvider(output, provider, helper));
        generator.addProvider(includeServer, new ExquisitoLootModifierProvider(output, provider));
        generator.addProvider(includeServer, new ExquisitoTrimMaterialTagsProvider(output, provider, helper));
        generator.addProvider(includeServer, new ExquisitoPaintingVariantTagsProvider(output, provider, helper));

        boolean client = event.includeClient();
        generator.addProvider(client, new ExquisitoSpriteSourceProvider(output, helper));
        generator.addProvider(client, new GalleryItemModelProvider(MODID, output, helper));
        generator.addProvider(client, new GalleryAssetsRemolderProvider(MODID, output, provider));
    }
}
