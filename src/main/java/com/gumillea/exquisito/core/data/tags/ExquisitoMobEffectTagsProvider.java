package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanMobEffectTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class ExquisitoMobEffectTagsProvider extends ForgeRegistryTagsProvider<MobEffect> {
    public ExquisitoMobEffectTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ForgeRegistries.MOB_EFFECTS, Exquisito.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(NeapolitanMobEffectTags.UNAFFECTED_BY_VANILLA_SCENT).add(ExquisitoEffects.LOVE_DELUXE.get());
    }

}
