package com.gumillea.exquisito.common.block;

import com.teamabnormals.blueprint.core.util.item.filling.TargetedItemCategoryFiller;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.SlabBlock;

public class CarmotineSlabBlock extends SlabBlock {
    public CarmotineSlabBlock(Properties properties) {
        super(properties);
    }
    private static final TargetedItemCategoryFiller FILLER = new TargetedItemCategoryFiller(() -> Items.PURPUR_STAIRS);

    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        FILLER.fillItem(this.asItem(), tab, list);
    }
}
