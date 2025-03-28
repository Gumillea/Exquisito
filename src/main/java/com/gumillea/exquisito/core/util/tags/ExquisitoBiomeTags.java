package com.gumillea.exquisito.core.util.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ExquisitoBiomeTags {
    public static final TagKey<Biome> HAS_INVERTED_RUINS = biomeTag("has_structure/inverted_ruins");

    private static TagKey<Biome> biomeTag(String name) {
        return TagUtil.biomeTag(Exquisito.MODID, name);
    }
}
