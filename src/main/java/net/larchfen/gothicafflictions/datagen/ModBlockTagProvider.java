package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GothicAfflictions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.HEARTWOOD_LOG.get())
                .add(ModBlocks.HEARTWOOD_PLANKS.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_1.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_2.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_3.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_4.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_5.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_6.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_7.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_8.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHISELED_POLISHED_HEMATITE.get())
                .add(ModBlocks.HEMATITE_PILLAR.get())
                .add(ModBlocks.HEMATITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_HEMATITE_ORE.get())
                .add(ModBlocks.POLISHED_HEMATITE.get())
                .add(ModBlocks.HEMATITE_BRICKS.get())
                .add(ModBlocks.HEMATITE_BRICK_STAIRS.get())
                .add(ModBlocks.HEMATITE_BRICK_SLAB.get())
                .add(ModBlocks.HEMATITE_BRICK_WALL.get())
                .add(ModBlocks.TALCUM_BLOCK.get())
                .add(ModBlocks.TALCUM_ORE.get())
                .add(ModBlocks.CALCITE_TALCUM_ORE.get())
                .add(ModBlocks.SANGUINITE_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.END_SILVER_ORE.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.SILVER_BLOCK.get());


        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CHISELED_POLISHED_HEMATITE.get())
                .add(ModBlocks.HEMATITE_PILLAR.get())
                .add(ModBlocks.HEMATITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_HEMATITE_ORE.get())
                .add(ModBlocks.POLISHED_HEMATITE.get())
                .add(ModBlocks.HEMATITE_BRICKS.get())
                .add(ModBlocks.HEMATITE_BRICK_STAIRS.get())
                .add(ModBlocks.HEMATITE_BRICK_SLAB.get())
                .add(ModBlocks.HEMATITE_BRICK_WALL.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SANGUINITE_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.END_SILVER_ORE.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.SILVER_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_SILVER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_SILVER_TOOL);

        tag(BlockTags.WALLS)
                .add(ModBlocks.POLISHED_HEMATITE_WALL.get())
                .add(ModBlocks.HEMATITE_BRICK_WALL.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.HEARTWOOD_PLANKS.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.HEARTWOOD_LOG.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_1.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_2.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_3.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_4.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_5.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_6.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_7.get())
                .add(ModBlocks.ANCIENT_OAK_LOG_8.get());


    }
}
