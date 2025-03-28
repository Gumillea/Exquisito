package com.gumillea.exquisito.core.util.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ExquisitoEntityTypeTags {
    public static final TagKey<EntityType<?>> RESONANCE_IMMUNE = entityTypeTag("immune_from_resonance");
    public static final TagKey<EntityType<?>> FUCHSIA_GOO_IMMUNE = entityTypeTag("immune_from_fuchsia_goo");

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagUtil.entityTypeTag(Exquisito.MODID, name);
    }
}
