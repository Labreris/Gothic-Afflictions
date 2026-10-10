package net.larchfen.gothicafflictions.worldgen.tree;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower DUSKWOOD_ORANGE = new TreeGrower(GothicAfflictions.MOD_ID + ":duskwood_orange",
            Optional.empty(), Optional.of(ModConfiguredFeatures.DUSKWOOD_ORANGE_KEY), Optional.empty());

    public static final TreeGrower DUSKWOOD_RED = new TreeGrower(GothicAfflictions.MOD_ID + ":duskwood_red",
            Optional.empty(), Optional.of(ModConfiguredFeatures.DUSKWOOD_RED_KEY), Optional.empty());

    public static final TreeGrower DUSKWOOD_BLACK = new TreeGrower(GothicAfflictions.MOD_ID + ":duskwood_black",
            Optional.empty(), Optional.of(ModConfiguredFeatures.DUSKWOOD_BLACK_KEY), Optional.empty());



}
