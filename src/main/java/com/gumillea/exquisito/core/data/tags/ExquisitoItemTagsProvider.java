package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.gumillea.exquisito.core.util.tags.ExquisitoItemTags;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ExquisitoItemTagsProvider extends ItemTagsProvider {
    public ExquisitoItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(output, provider, lookup, Exquisito.MODID, helper);
    }
    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        this.copy(BlockTags.WALLS, ItemTags.WALLS);

        this.tag(NeapolitanItemTags.ICE_CREAM).add(
               ExquisitoItems.CHORUS_ICE_CREAM.get(),
               ExquisitoItems.JELLY_RING_ICE_CREAM.get(),
               ExquisitoItems.ETHER_BULB_ICE_CREAM.get(),
               ExquisitoItems.ZURE_BERRY_ICE_CREAM.get(),
               ExquisitoItems.NIGHTSHADE_BERRY_ICE_CREAM.get(),
               ExquisitoItems.ETHER_BULB_ICE_CREAM.get()
        );

        this.tag(ExquisitoItemTags.FRUITS).add(
                ExquisitoItems.MIDNIGHT_BERRIES.get(),
                ExquisitoItems.STARCLOUD_BULBS.get()
        );

        this.tag(ItemTags.TRIM_MATERIALS).add(
                ExquisitoItems.CARMOTINE.get(),
                Items.POPPED_CHORUS_FRUIT
        );

        this.tag(ItemTags.TRIM_TEMPLATES).add(
                ExquisitoItems.EMBRYO_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                ExquisitoItems.KNOT_ARMOR_TRIM_SMITHING_TEMPLATE.get()
        );

        this.tag(ExquisitoItemTags.MIDNIGHT_INGREDIENTS).add(
                ExquisitoItems.MIDNIGHT_BERRIES.get())
                .addOptional(ModCompat.NIGHTSHADE_BERRY)
                .addOptional(ModCompat.SHADOW_BERRY);

        this.tag(ExquisitoItemTags.STARCLOUD_INGREDIENTS).add(
                ExquisitoItems.STARCLOUD_BULBS.get())
                .addOptional(ModCompat.BLOSSOM_BERRY)
                .addOptional(ModCompat.ETHER_BULB);

        this.tag(ExquisitoItemTags.CHORUS_FRUITS).add(
                 Items.CHORUS_FRUIT)
                .addOptional(ModCompat.CHORUS_FRUIT_GRAIN);
    }
}

