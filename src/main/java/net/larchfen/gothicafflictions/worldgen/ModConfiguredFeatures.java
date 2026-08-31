package net.larchfen.gothicafflictions.worldgen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_HEMATITE_ORE_KEY = registerKey("hematite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SILVER_ORE_KEY = registerKey("end_silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TALCUM_ORE_KEY = registerKey("talcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CALCITE_TALCUM_ORE_KEY = registerKey("calcite_talcum_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_OAK_KEY = registerKey("ancient_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_DARK_OAK_KEY = registerKey("ancient_dark_oak");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        // DEFINE RULES FOR ORE REPLACING
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest calciteReplaceables = new BlockMatchTest(Blocks.CALCITE);
        RuleTest end_stoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        // Hematite ores in the overworld get put in a list (stone/deepslate variants)
        List<OreConfiguration.TargetBlockState> overworldHematiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.HEMATITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_HEMATITE_ORE.get().defaultBlockState())
        );
        // Silver ores in overworld list
        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
        );

        // Talcum ore list (maybe redundant) Does not include calcite talcum ore because it needs some slightly different code
        // So I separated them into two.
        List<OreConfiguration.TargetBlockState> overworldTalcumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TALCUM_ORE.get().defaultBlockState())
        );

        // All the ores get configured (Note: Talcum is split into two)
        register(context, OVERWORLD_HEMATITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldHematiteOres, 6));

        register(context, OVERWORLD_TALCUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTalcumOres, 6));
        register(context, OVERWORLD_CALCITE_TALCUM_ORE_KEY, Feature.ORE, new OreConfiguration(calciteReplaceables,
                ModBlocks.CALCITE_TALCUM_ORE.get().defaultBlockState(), 4));

        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 7));
        register(context, END_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(end_stoneReplaceables,
                ModBlocks.END_SILVER_ORE.get().defaultBlockState(), 13));

        // TREES
        register(context, ANCIENT_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new GiantTrunkPlacer(6, 6, 8),

                BlockStateProvider.simple(Blocks.OAK_LEAVES),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ANCIENT_DARK_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HEARTWOOD_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),

                BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
