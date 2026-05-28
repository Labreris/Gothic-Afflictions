package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GothicAfflictions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // FOR BASIC ITEMS (WITH NON-COMPLEX MODELS) COPY THIS
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.MORTAR_AND_PESTLE.get());

        basicItem(ModItems.HEMATITE.get());
        basicItem(ModItems.HEMATITE_NUGGET.get());
        basicItem(ModItems.HEMATITE_POWDER.get());

        basicItem(ModItems.TALCUM.get());
        basicItem(ModItems.TALCUM_POWDER.get());

        basicItem(ModItems.SANGUINITE_INGOT.get());

        basicItem(ModItems.SILVER_INGOT.get());

        basicItem(ModItems.BLOODSTONE.get());

        basicItem(ModItems.GARLIC.get());

        basicItem(ModItems.ALCHEMICAL_FLAME.get());
        basicItem(ModItems.BURNING_ALKAHEST.get());

        wallItem(ModBlocks.POLISHED_HEMATITE_WALL, ModBlocks.POLISHED_HEMATITE);

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
