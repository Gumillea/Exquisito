package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.ExquisitoConfig;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExquisitoLootConditions {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITION_TYPES = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, Exquisito.MODID);
    public static final RegistryObject<LootItemConditionType> CONFIG = LOOT_CONDITION_TYPES.register("config", () -> DataUtil.registerConfigCondition(Exquisito.MODID, ExquisitoConfig.COMMON));
}
