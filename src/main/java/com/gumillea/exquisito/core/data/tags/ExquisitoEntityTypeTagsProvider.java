package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.gumillea.exquisito.core.util.tags.ExquisitoEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ExquisitoEntityTypeTagsProvider extends EntityTypeTagsProvider {

    public ExquisitoEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Exquisito.MODID, helper);
    }
    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(ExquisitoEntityTypeTags.RESONANCE_IMMUNE).add(
                EntityType.BAT,
                EntityType.ENDERMAN,
                EntityType.GHAST,
                EntityType.PHANTOM,
                EntityType.SHULKER)
                .addOptional(ModCompat.STALKER_RESOURCE)
                .addOptional(ModCompat.SQUELCHER_RESOURCE)
                .addTag(Tags.EntityTypes.BOSSES);
        this.tag(ExquisitoEntityTypeTags.FUCHSIA_GOO_IMMUNE).add(
                EntityType.GHAST,
                EntityType.PHANTOM,
                EntityType.SHULKER,
                EntityType.WARDEN)
                .addOptional(ModCompat.RINGLING_RESOURCE)
                .addTag(Tags.EntityTypes.BOSSES);
    }
}
