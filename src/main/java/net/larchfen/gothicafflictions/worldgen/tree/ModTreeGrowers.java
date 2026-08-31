package net.larchfen.gothicafflictions.worldgen.tree;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower ANCIENT_OAK = new TreeGrower(GothicAfflictions.MOD_ID + ":ancient_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ANCIENT_OAK_KEY), Optional.empty());

    public static final TreeGrower ANCIENT_DARK_OAK = new TreeGrower(GothicAfflictions.MOD_ID + ":ancient_dark_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ANCIENT_DARK_OAK_KEY), Optional.empty());
}
