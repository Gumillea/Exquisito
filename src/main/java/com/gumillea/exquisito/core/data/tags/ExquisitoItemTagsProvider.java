package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.gumillea.exquisito.core.util.compat.ModCompat;
import com.gumillea.exquisito.core.util.tags.ExquisitoItemTags;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
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
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                ExquisitoBlocks.CARMOTINE_BRICKS.get().asItem()
        );

        this.tag(NeapolitanItemTags.ICE_CREAM).add(
               ExquisitoItems.CHORUS_ICE_CREAM.get(),
               ExquisitoItems.JELLY_RING_ICE_CREAM.get(),
               ExquisitoItems.ETHER_BULB_ICE_CREAM.get(),
               ExquisitoItems.ZURE_BERRY_ICE_CREAM.get(),
               ExquisitoItems.NIGHTSHADE_BERRY_ICE_CREAM.get(),
               ExquisitoItems.ETHER_BULB_ICE_CREAM.get()
        );

        this.tag(ExquisitoItemTags.BERRIES).add(
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

        this.tag(ExquisitoItemTags.RESONANCE_SOURCES)
                .addTag(ExquisitoItemTags.CHORUS_FRUITS)
                .addOptional(ed("chorus_fruit_milk_tea"))
                .addOptional(ed("chorus_fruit_popsicle"))
                .addOptional(ed("chorus_fruit_wine"))
                .addOptional(ed("bubble_tea"))
                .addOptional(ed("dragon_breath_and_chorus_soup"))
                .addOptional(ed("end_barbecue_stick"))
                .addOptional(ed("chorus_fruit_pie_slice"))
                .addOptional(ed("assorted_salad"))
                .addOptional(ed("end_mixed_salad"))
                .addOptional(ed("stuffed_rice_cake"))
                .addOptional(ed("chorus_cookie"))
                .addOptional(ed("roasted_dragon_steak"))
                .addOptional(ed("dragon_leg_with_sauce"))
                .addOptional(ed("chorus_sauce"))

                .addOptional(erd("chorus_stew"))
                .addOptional(erd("chorus_stew_wood"))
                .addOptional(erd("chorus_juice"))
                .addOptional(erd("chorus_pie_slice"))

                .addOptional(vc("chorus_soda"))
                .addOptional(vc("chorus_juice"))
                .addOptional(vc("chorus_cake_slice"))

                .addOptional(ModCompat.id(ModCompat.UE, "chorus_pie"))
                .addOptional(ModCompat.id(ModCompat.UE, "ender_stew"))
        ;
    }

    public static ResourceLocation vc (String path) {
        return ModCompat.id(ModCompat.VC, path);
    }

    public static ResourceLocation ed (String path) {
        return ModCompat.id(ModCompat.ED, path);
    }

    public static ResourceLocation erd (String path) {
        return ModCompat.id(ModCompat.ERD, path);
    }

}

