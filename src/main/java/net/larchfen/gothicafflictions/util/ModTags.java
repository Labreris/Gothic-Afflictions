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
        public static final TagKey<Block> HEMATITE_BLOCKS = createTag("hematite_blocks");

        // METHODS
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, name));
        }
    }

    public static class Items {

        // This probably needs to be cleaned up/have better names in the future
        public static final TagKey<Item> POLISHED_HEMATITE_ITEMS = createTag("polished_hematite_items");

        // METHODS
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, name));
        }
    }
}
