package com.gumillea.exquisito.core.reg;

import com.gumillea.exquisito.common.effect.WarzipanEffect;
import com.gumillea.exquisito.common.effect.EarendelEffect;
import com.gumillea.exquisito.common.effect.FuchsiaGooEffect;
import com.gumillea.exquisito.common.effect.MorgothEffect;
import com.gumillea.exquisito.core.Exquisito;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExquisitoEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Exquisito.MODID);
    public static final RegistryObject<MobEffect> DIVER_DOWN = EFFECTS.register("diver_down", () -> new WarzipanEffect(MobEffectCategory.BENEFICIAL, 0x4896B3));
    public static final RegistryObject<MobEffect> EARENDEL = EFFECTS.register("earendel", EarendelEffect::new);
    public static final RegistryObject<MobEffect> FUCHSIA_GOO = EFFECTS.register("fuchsia_goo", FuchsiaGooEffect::new);
    public static final RegistryObject<MobEffect> LOVE_DELUXE = EFFECTS.register("love_deluxe", () -> new WarzipanEffect(MobEffectCategory.BENEFICIAL, 0xD389C3));
    public static final RegistryObject<MobEffect> MORGOTH = EFFECTS.register("morgoth", MorgothEffect::new);
    public static final RegistryObject<MobEffect> MODULATION = EFFECTS.register("modulation", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0xFBD1BC));
    public static final RegistryObject<MobEffect> RESONANCE = EFFECTS.register("resonance", () -> new BlueprintMobEffect(MobEffectCategory.NEUTRAL, 0xBA9BBA));
    public static final RegistryObject<MobEffect> SPACE_DIVING = EFFECTS.register("space_diving", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 0x5ED5E2));

}
