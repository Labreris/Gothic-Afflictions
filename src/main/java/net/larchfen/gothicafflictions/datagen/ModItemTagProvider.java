package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.item.ModItems;
import net.larchfen.gothicafflictions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

        tag(ModTags.Items.STONECUTTABLE_HEMATITE)
                .add(
                        ModBlocks.POLISHED_HEMATITE.get().asItem(),
                        ModBlocks.CHISELED_POLISHED_HEMATITE.get().asItem(),
                        ModBlocks.HEMATITE_BRICKS.get().asItem(),
                        ModBlocks.HEMATITE_BRICK_STAIRS.get().asItem(),
                        ModBlocks.HEMATITE_BRICK_WALL.get().asItem(),
                        ModBlocks.HEMATITE_PILLAR.get().asItem(),
                        ModBlocks.POLISHED_HEMATITE_STAIRS.get().asItem(),
                        ModBlocks.POLISHED_HEMATITE_WALL.get().asItem()
                );

        tag(ModTags.Items.MORTAR_CRUSHABLE_ITEMS)
                .add(
                        ModItems.SILVER_NUGGET.get().asItem(),
                        ModItems.HEMATITE_NUGGET.get().asItem(),
                        ModItems.TALCUM.get().asItem(),
                        Items.IRON_NUGGET.asItem(),
                        Items.GOLD_NUGGET.asItem()
                );
        tag(ItemTags.SWORDS)
                .add(
                        ModItems.SILVER_SWORD.get(),
                        ModItems.SANGUINITE_SWORD.get(),
                        ModItems.SANGUINITE_SCEPTER.get());
        tag(ItemTags.PICKAXES)
                .add(
                        ModItems.SILVER_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(
                        ModItems.SILVER_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(
                        ModItems.SILVER_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(
                        ModItems.SILVER_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SILVER_HELMET.get())
                .add(ModItems.SILVER_CHESTPLATE.get())
                .add(ModItems.SILVER_LEGGINGS.get())
                .add(ModItems.SILVER_BOOTS.get());
    }
}
