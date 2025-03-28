package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.core.Exquisito;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExquisitoPaintingVariants {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Exquisito.MODID);

    public static final RegistryObject<PaintingVariant> OVERLOOK = PAINTING_VARIANTS.register("overlook", () -> new PaintingVariant(64, 64));
}
