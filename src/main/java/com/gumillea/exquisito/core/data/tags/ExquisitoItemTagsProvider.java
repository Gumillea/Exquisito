package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ExquisitoItemTagsProvider extends ItemTagsProvider {
    public ExquisitoItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, Exquisito.MODID, existingFileHelper);
    }
    @Override
    public void addTags() {
        this.tag(NeapolitanItemTags.ICE_CREAM).add(
               ExquisitoItems.CHORUS_ICE_CREAM.get(),
               ExquisitoItems.JELLY_RING_ICE_CREAM.get(),
               ExquisitoItems.ETHER_BULB_ICE_CREAM.get(),
               ExquisitoItems.ZURE_BERRY_ICE_CREAM.get(),
               ExquisitoItems.NIGHTSHADE_BERRY_ICE_CREAM.get(),
               ExquisitoItems.ETHER_BULB_ICE_CREAM.get()
        );
        this.tag(Tags.Items.SLIMEBALLS).add(
                ExquisitoItems.ELMOND.get()
        );
    }
}

