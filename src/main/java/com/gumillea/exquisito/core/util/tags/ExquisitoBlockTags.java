package com.gumillea.exquisito.core.util.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ExquisitoBlockTags {
    public static final TagKey<Block> ENNEGEL_REPLACEABLE = blockTag("ennegel_replaceable");
    private static TagKey<Block> blockTag(String name) {
        return TagUtil.blockTag(Exquisito.MODID, name);
    }
}
