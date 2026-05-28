package net.larchfen.gothicafflictions.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120), 0.5f).build();
}
