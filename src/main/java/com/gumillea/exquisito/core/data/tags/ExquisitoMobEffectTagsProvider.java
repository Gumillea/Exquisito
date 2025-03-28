package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanMobEffectTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

public class ExquisitoMobEffectTagsProvider extends IntrinsicHolderTagsProvider<MobEffect> {
    public ExquisitoMobEffectTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, Registries.MOB_EFFECT, provider, (effect) -> (ResourceKey)ForgeRegistries.MOB_EFFECTS.getResourceKey(effect).get(), Exquisito.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(NeapolitanMobEffectTags.UNAFFECTED_BY_VANILLA_SCENT).add(ExquisitoEffects.LOVE_DELUXE.get());
    }

}
