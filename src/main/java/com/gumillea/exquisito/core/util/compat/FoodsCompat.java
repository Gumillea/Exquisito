package com.gumillea.exquisito.core.util.compat;

import cn.foggyhillside.endsdelight.item.FoodList;
import com.gumillea.exquisito.core.ExquisitoConfig;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FoodsCompat {
    public static void modifyFoods() {
        List<FoodProperties> chorusFoods = new ArrayList<>();
        MobEffect resonance = ExquisitoEffects.RESONANCE.get();
        MobEffect fg = ExquisitoEffects.FUCHSIA_GOO.get();
        MobEffect m = ExquisitoEffects.MORGOTH.get();

        if (ExquisitoConfig.Common.FOOD_MODIFICATION.get()) {
            chorusFoods.add(Foods.CHORUS_FRUIT);

            if (ModList.get().isLoaded(ModCompat.EED) && (ExquisitoConfig.Common.ENLIGHTEND_MODIFICATION.get())) {
                Objects.requireNonNull(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.EED, "azure_berries")))
                        .foodProperties).effects.add(Pair.of(() -> new MobEffectInstance(ExquisitoEffects.SPACE_DIVING.get(), 300), 1.0F));
            }

            if (ModList.get().isLoaded(ModCompat.ED) && ExquisitoConfig.Common.ENDS_DELIGHT_MODIFICATION.get()) {
                List<FoodProperties> endsDelightFoods = Arrays.asList(
                        FoodList.BubbleTea,
                        FoodList.ChorusCookie,
                        FoodList.ChorusFruitGrain,
                        FoodList.ChorusFruitPopsicle,
                        FoodList.ChorusFruitWine,
                        FoodList.ChorusFruitMilkTea,
                        FoodList.EnderSauce,
                        FoodList.EndMixedSalad,
                        FoodList.StuffedRiceCake
                );
                chorusFoods.addAll(endsDelightFoods);

                FoodList.ChorusCookie.fastFood = true;
                FoodList.StirFriedShulkerMeat.effects.add(Pair.of(() -> new MobEffectInstance(resonance, 100), 1.0F));
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.ED, "chorus_fruit_pie_slice"))).foodProperties = (new FoodProperties.Builder())
                        .nutrition(3).saturationMod(0.3f).fast()
                        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600), 1.0F)
                        .effect(() -> new MobEffectInstance(resonance, 200), 1.0F).build();
            }

            if (ModList.get().isLoaded(ModCompat.UE) && ExquisitoConfig.Common.UNUSUAL_END_MODIFICATION.get()) {
                List<FoodProperties> unusualEndFoods = Arrays.asList(
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.UE, "chorus_pie"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.UE, "chorus_juice"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.UE, "ender_stew"))).foodProperties
                );
                chorusFoods.addAll(unusualEndFoods);
            }

            if (ModList.get().isLoaded(ModCompat.B) && ExquisitoConfig.Common.BYG_MODIFICATION.get()) {
                Objects.requireNonNull(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.B, "ether_bulbs")))
                        .foodProperties).effects.add(Pair.of(() -> new MobEffectInstance(ExquisitoEffects.EARENDEL.get(), 200), 1.0F));
                Objects.requireNonNull(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.B, "nightshade_berries")))
                        .foodProperties).effects.add(Pair.of(() -> new MobEffectInstance(m, 200), 1.0F));
                Objects.requireNonNull(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.B, "nightshade_berry_pie")))
                        .foodProperties).effects.add(Pair.of(() -> new MobEffectInstance(m, 200,1), 1.0F));

                if (ModList.get().isLoaded(ModCompat.DF)) {
                    Objects.requireNonNull(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.DF, "nightshade_berry_pie_slice")))
                            .foodProperties).effects.add(Pair.of(() -> new MobEffectInstance(m, 400), 1.0F));
                }
            }

            if (ModList.get().isLoaded(ModCompat.ERD) && ExquisitoConfig.Common.ENDERS_DELIGHT_MODIFICATION.get()) {
                List<FoodProperties> endersDelightFoods = Arrays.asList(
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.ERD, "crispy_skewer"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.ERD, "chorus_stew"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.ERD, "crawling_sandwich"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.ERD, "stuffed_shulker_bowl"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.ERD, "chorus_juice"))).foodProperties
                );
                chorusFoods.addAll(endersDelightFoods);
            }

            if (ModList.get().isLoaded(ModCompat.VC) && ExquisitoConfig.Common.VC_MODIFICATION.get()) {
                List<FoodProperties> VCFoods = Arrays.asList(
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.VC, "chorus_cake_slice"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.VC, "chorus_juice"))).foodProperties,
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModCompat.VC, "chorus_soda"))).foodProperties
                );
                chorusFoods.addAll(VCFoods);
            }

            for (FoodProperties properties : chorusFoods) {
                if (properties.getNutrition() < 5){
                    properties.effects.add(Pair.of(() -> new MobEffectInstance(resonance, 200), 1.0F));
                } else {
                    properties.effects.add(Pair.of(() -> new MobEffectInstance(resonance, 400), 1.0F));
                }
            }
        }
    }
}