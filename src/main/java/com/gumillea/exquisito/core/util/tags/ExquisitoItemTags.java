package com.gumillea.exquisito.core.util.tags;

import com.gumillea.exquisito.core.Exquisito;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ExquisitoItemTags {
    public static final TagKey<Item> MIDNIGHT_INGREDIENTS = itemTag("midnight_ingredients");
    public static final TagKey<Item> STARCLOUD_INGREDIENTS = itemTag("starcloud_ingredients");

    public static final TagKey<Item> RESONANCE_FOODS = itemTag("resonance_foods");

    public static final TagKey<Item> FRUITS = TagUtil.itemTag("forge", "fruits");

    private static TagKey<Item> itemTag(String name) {
        return TagUtil.itemTag(Exquisito.MODID, name);
    }
}
