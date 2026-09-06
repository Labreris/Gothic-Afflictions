package net.larchfen.gothicafflictions.worldgen.tree;

import net.larchfen.gothicafflictions.GothicAfflictions;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTrunkPlacers {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, GothicAfflictions.MOD_ID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<ModTrunkPlacer>> MOD_TRUNK_PLACER =
            TRUNK_PLACERS.register(
                    "mod_trunk",
                    () -> new TrunkPlacerType<>(
                            ModTrunkPlacer.CODEC
                    )
            );
}
