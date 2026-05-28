package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.HEMATITE_BLOCK.get())
                .add(ModBlocks.HEMATITE_PILLAR.get())
                .add(ModBlocks.HEMATITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_HEMATITE_ORE.get())
                .add(ModBlocks.POLISHED_HEMATITE.get())
                .add(ModBlocks.HEMATITE_BRICKS.get())
                .add(ModBlocks.TALCUM_BLOCK.get())
                .add(ModBlocks.TALCUM_ORE.get())
                .add(ModBlocks.CALCITE_TALCUM_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.HEMATITE_BLOCK.get())
                .add(ModBlocks.HEMATITE_PILLAR.get())
                .add(ModBlocks.HEMATITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_HEMATITE_ORE.get())
                .add(ModBlocks.POLISHED_HEMATITE.get())
                .add(ModBlocks.HEMATITE_BRICKS.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SANGUINITE_BLOCK.get());
    }
}
