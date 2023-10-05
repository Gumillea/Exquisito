package com.gumillea.exquisito.core.data.modifiers;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolEntriesModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Arrays;

public class ExquisitoLootModifierProvider extends LootModifierProvider {

    public ExquisitoLootModifierProvider(DataGenerator generator) {
        super(generator, Exquisito.MODID);
    }

    @Override
    protected void registerEntries() {
        this.entry("end_city").selects(BuiltInLootTables.END_CITY_TREASURE).addModifier(new LootPoolEntriesModifier(false, 0, Arrays.asList(createLootEntry(ExquisitoItems.WARZIPAN.get(), 3, 2, 7), createLootEntry(ExquisitoItems.CHORUS_KHANOM_CHAN.get(), 5, 1, 10))));
    }

    private static LootPoolEntryContainer createLootEntry(ItemLike item, int weight, int min, int max) {
        return LootItem.lootTableItem(item).setWeight(weight).apply(SetItemCountFunction.setCount(UniformGenerator.between((float)min, (float)max))).build();
    }
}
