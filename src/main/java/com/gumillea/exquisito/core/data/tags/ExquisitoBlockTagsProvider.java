package com.gumillea.exquisito.core.data.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoBlocks;
import com.gumillea.exquisito.core.util.tags.ExquisitoBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ExquisitoBlockTagsProvider extends BlockTagsProvider {
    public ExquisitoBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Exquisito.MODID, existingFileHelper);
    }

    @Override
    public void addTags() {
        this.tag(BlockTags.CLIMBABLE).add(
                ExquisitoBlocks.CARMOTINE_LADDER.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                ExquisitoBlocks.CHORUS_ICE_CREAM_BLOCK.get(),
                ExquisitoBlocks.ETHER_BULB_ICE_CREAM_BLOCK.get(),
                ExquisitoBlocks.JELLY_RING_ICE_CREAM_BLOCK.get(),
                ExquisitoBlocks.NIGHTSHADE_BERRY_ICE_CREAM_BLOCK.get(),
                ExquisitoBlocks.ZURE_BERRY_ICE_CREAM_BLOCK.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ExquisitoBlocks.ABANDONED_VESSEL.get(),
                ExquisitoBlocks.CARMOTINE_BLOCK.get(),
                ExquisitoBlocks.CARMOTINE_SLAB.get(),
                ExquisitoBlocks.CARMOTINE_STAIRS.get(),
                ExquisitoBlocks.CARMOTINE_BRICKS.get(),
                ExquisitoBlocks.CARMOTINE_BRICK_SLAB.get(),
                ExquisitoBlocks.CARMOTINE_BRICK_STAIRS.get(),
                ExquisitoBlocks.CARMOTINE_PILLAR.get(),
                ExquisitoBlocks.DESSERT_CHECKERED_BRICKS.get(),
                ExquisitoBlocks.DESSERT_CHECKERED_BRICK_SLAB.get(),
                ExquisitoBlocks.WARZIPAN_BLOCK.get(),
                ExquisitoBlocks.WARZIPAN_BRICKS.get(),
                ExquisitoBlocks.WARZIPAN_BRICK_SLAB.get(),
                ExquisitoBlocks.WEATHERED_CARMOTINE_MURAL.get(),
                ExquisitoBlocks.RUINED_CARMOTINE_MURAL.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                ExquisitoBlocks.ELMOND_BLOCK.get()
        );
        this.tag(BlockTags.SLABS).add(
                ExquisitoBlocks.WARZIPAN_BRICK_SLAB.get(),
                ExquisitoBlocks.DESSERT_CHECKERED_BRICK_SLAB.get(),
                ExquisitoBlocks.CARMOTINE_SLAB.get(),
                ExquisitoBlocks.CARMOTINE_BRICK_SLAB.get()
        );
        this.tag(BlockTags.STAIRS).add(
                ExquisitoBlocks.WARZIPAN_BRICK_STAIRS.get(),
                ExquisitoBlocks.DESSERT_CHECKERED_BRICK_STAIRS.get(),
                ExquisitoBlocks.CARMOTINE_STAIRS.get(),
                ExquisitoBlocks.CARMOTINE_BRICK_STAIRS.get()
        );
        this.tag(ExquisitoBlockTags.ENNEGEL_REPLACEABLE)
                .add(Blocks.END_STONE)
                .addTag(BlockTags.DIRT)
                .addTag(BlockTags.NYLIUM);
    }
}
