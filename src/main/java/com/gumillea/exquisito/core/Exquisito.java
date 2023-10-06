package com.gumillea.exquisito.core;

import com.gumillea.exquisito.core.data.modifiers.ExquisitoLootModifierProvider;
import com.gumillea.exquisito.core.data.tags.ExquisitoBlockTagsProvider;
import com.gumillea.exquisito.core.data.tags.ExquisitoEntityTypeTagsProvider;
import com.gumillea.exquisito.core.data.tags.ExquisitoItemTagsProvider;
import com.gumillea.exquisito.core.reg.ExquisitoCauldronInteractions;
import com.gumillea.exquisito.core.reg.ExquisitoCompostableItems;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.gumillea.exquisito.core.reg.ExquisitoLootConditions;
import com.gumillea.exquisito.core.util.compat.FoodsCompat;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Exquisito.MODID)
@Mod.EventBusSubscriber(modid = Exquisito.MODID)
public class Exquisito
{
    public static final String MODID = "exquisito";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);
    public Exquisito()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);
        ExquisitoEffects.EFFECTS.register(modEventBus);
        ExquisitoLootConditions.LOOT_CONDITION_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::gatherData);

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
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        boolean includeServer = event.includeServer();
        ExquisitoBlockTagsProvider blockTagsProvider = new ExquisitoBlockTagsProvider(generator, existingFileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new ExquisitoItemTagsProvider(generator, blockTagsProvider, existingFileHelper));
        generator.addProvider(includeServer, new ExquisitoEntityTypeTagsProvider(generator, existingFileHelper));
        generator.addProvider(includeServer, new ExquisitoLootModifierProvider(generator));
    }
}
