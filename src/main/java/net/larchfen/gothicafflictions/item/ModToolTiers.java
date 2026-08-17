package net.larchfen.gothicafflictions.item;

import net.larchfen.gothicafflictions.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier SILVER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL,
            190, 6, 2, 19, () -> Ingredient.of(ModItems.SILVER_INGOT));

    public static final Tier SANGUINITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SANGUINITE_TOOL,
            3666, 7, 5.0F, 14, () -> Ingredient.of(ModItems.SANGUINITE_INGOT));
}
