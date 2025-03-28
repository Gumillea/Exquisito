package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoPaintingVariants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.concurrent.CompletableFuture;

public class ExquisitoPaintingVariantTagsProvider extends PaintingVariantTagsProvider {

    public ExquisitoPaintingVariantTagsProvider(PackOutput output, CompletableFuture<Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Exquisito.MODID, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        TagAppender<PaintingVariant> appender = this.tag(PaintingVariantTags.PLACEABLE);
        for (RegistryObject<PaintingVariant> variant : ExquisitoPaintingVariants.PAINTING_VARIANTS.getEntries()) {
            appender.add(variant.getKey());
        }
    }
}