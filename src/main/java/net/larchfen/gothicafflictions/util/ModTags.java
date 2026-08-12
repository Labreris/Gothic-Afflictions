package net.larchfen.gothicafflictions.util;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {

        //MAIN BLOCK CATEGORIES
        // BLOCK TAG CHECKLIST: 1. ADD IT HERE, 2. ADD TO ModBlockTagProvider
        public static final TagKey<Block> HEMATITE_BLOCKS = createTag("hematite_blocks");

        public static final TagKey<Block> NEEDS_SILVER_TOOL = createTag("needs_silver_tool");
        public static final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");

        public static final TagKey<Block> NEEDS_SANGUINITE_TOOL = createTag("needs_sanguinite_tool");
        public static final TagKey<Block> INCORRECT_FOR_SANGUINITE_TOOL = createTag("incorrect_for_sanguinite_tool");

        // METHODS
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, name));
        }
    }

    public static class Items {

        // ITEM TAG CHECKLIST: 1. ADD IT HERE, 2. ADD TO ModItemTagProvider
        public static final TagKey<Item> STONECUTTABLE_HEMATITE = createTag("stonecuttable_hematite");

        public static final TagKey<Item> MORTAR_CRUSHABLE_ITEMS = createTag("mortar_crushable_items");

        // METHODS
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, name));
        }
    }
}
