package com.gumillea.exquisito.core.data.modifiers;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolEntriesModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class ExquisitoLootModifierProvider extends LootModifierProvider {

    public ExquisitoLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
        super(Exquisito.MODID, output, provider);
    }

    @Override
    protected void registerEntries(HolderLookup.Provider provider) {
    }

    private static LootPoolEntryContainer createLootEntry(ItemLike item, int weight, int min, int max) {
        return LootItem.lootTableItem(item).setWeight(weight).apply(SetItemCountFunction.setCount(UniformGenerator.between((float)min, (float)max))).build();
    }

}
