package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, GothicAfflictions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.POLISHED_HEMATITE_ITEMS)
                .add(
                        ModBlocks.POLISHED_HEMATITE.get().asItem(),
                        ModBlocks.HEMATITE_BRICKS.get().asItem(),
                        ModBlocks.HEMATITE_PILLAR.get().asItem(),
                        ModBlocks.POLISHED_HEMATITE_STAIRS.get().asItem(),
                        ModBlocks.POLISHED_HEMATITE_WALL.get().asItem()
                );

    }
}
