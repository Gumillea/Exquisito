package com.gumillea.exquisito.core.util.jei;

import com.gumillea.exquisito.core.Exquisito;
import com.gumillea.exquisito.core.reg.ExquisitoItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@JeiPlugin
@ParametersAreNonnullByDefault
public class ExquisitoJEIPlugin implements IModPlugin {
    public static final ResourceLocation ID = new ResourceLocation(Exquisito.MODID, "jei_plugin");

    private static final List<Supplier<Item>> INFO_ITEMS = List.of(
            ExquisitoItems.ELMOND, ExquisitoItems.ABANDONED_CORE
    );

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        for (Supplier<Item> itemSupplier : INFO_ITEMS) {
            Item item = itemSupplier.get();
            ResourceLocation key = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
            String translationKey = "jei." + Exquisito.MODID + "." + key.getPath() + ".desc";

            registration.addIngredientInfo(
                    new ItemStack(item),
                    VanillaTypes.ITEM_STACK,
                    Component.translatable(translationKey)
            );
        }

        registration.addIngredientInfo(
                List.of(
                        new ItemStack(ExquisitoItems.MIDNIGHT_BERRIES.get()),
                        new ItemStack(ExquisitoItems.STARCLOUD_BULBS.get())
                ),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.exquisito.imaginal_crops.desc")
        );
    }
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}

