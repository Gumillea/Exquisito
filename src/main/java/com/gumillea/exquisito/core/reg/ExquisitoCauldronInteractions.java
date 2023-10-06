package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.core.Exquisito;
import com.teamabnormals.blueprint.core.api.BlueprintCauldronInteraction;
import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.resources.ResourceLocation;

public class ExquisitoCauldronInteractions extends NeapolitanCauldronInteractions {
    public static BlueprintCauldronInteraction CHORUS_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Exquisito.MODID, "chorus_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction JELLY_RING_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Exquisito.MODID, "jelly_ring_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction ZURE_BERRY_MILKSHAKE = BlueprintCauldronInteraction.register(new ResourceLocation(Exquisito.MODID, "zure_berry_milkshake"), CauldronInteraction.newInteractionMap());

    public static void registerCauldronInteractions() {
            addMilkshakeInteractions(ExquisitoItems.CHORUS_MILKSHAKE.get(), ExquisitoBlocks.CHORUS_MILKSHAKE_CAULDRON.get(), ExquisitoItems.CHORUS_ICE_CREAM.get(), CHORUS_MILKSHAKE.map());
            addMilkshakeInteractions(ExquisitoItems.JELLY_RING_MILKSHAKE.get(), ExquisitoBlocks.JELLY_RING_MILKSHAKE_CAULDRON.get(), ExquisitoItems.JELLY_RING_ICE_CREAM.get(), JELLY_RING_MILKSHAKE.map());
            addMilkshakeInteractions(ExquisitoItems.ZURE_BERRY_MILKSHAKE.get(), ExquisitoBlocks.ZURE_BERRY_MILKSHAKE_CAULDRON.get(), ExquisitoItems.ZURE_BERRY_ICE_CREAM.get(), ZURE_BERRY_MILKSHAKE.map());
    }

}
