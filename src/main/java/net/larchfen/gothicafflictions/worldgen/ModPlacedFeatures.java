package net.larchfen.gothicafflictions.worldgen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> HEMATITE_ORE_PLACED_KEY = registerKey("hematite_ore_placed");
    public static final ResourceKey<PlacedFeature> TALCUM_ORE_PLACED_KEY = registerKey("talcum_ore_placed");
    public static final ResourceKey<PlacedFeature> CALCITE_TALCUM_ORE_PLACED_KEY = registerKey("calcite_talcum_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> END_SILVER_ORE_PLACED_KEY = registerKey("end_silver_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HEMATITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_HEMATITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)))
        );
        register(context, TALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TALCUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(320)))
        );
        register(context, CALCITE_TALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CALCITE_TALCUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(128,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(32),
                                VerticalAnchor.absolute(256)))
        );
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-160),
                                VerticalAnchor.aboveBottom(160)))
        );
        register(context, END_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(120)))
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
