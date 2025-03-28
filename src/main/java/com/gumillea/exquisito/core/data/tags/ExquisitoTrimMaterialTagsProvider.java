package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoTrimMaterials;
import com.teamabnormals.blueprint.core.other.tags.BlueprintTrimMaterialTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ExquisitoTrimMaterialTagsProvider extends TagsProvider<TrimMaterial> {

    public ExquisitoTrimMaterialTagsProvider(PackOutput output, CompletableFuture<Provider> provider, ExistingFileHelper helper) {
        super(output, Registries.TRIM_MATERIAL, provider, Exquisito.MODID, helper);
    }

    @Override
    public void addTags(Provider provider) {
        this.tag(BlueprintTrimMaterialTags.GENERATES_OVERRIDES).add(
                ExquisitoTrimMaterials.CARMOTINE,
                ExquisitoTrimMaterials.CHORUS
        );
    }

}