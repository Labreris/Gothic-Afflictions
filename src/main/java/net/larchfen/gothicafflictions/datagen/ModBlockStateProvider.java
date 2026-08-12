package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.block.custom.GarlicCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GothicAfflictions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // FOR BLOCKS THAT ARE SIMPLE CUBES, JUST COPY THIS FOR IT.
        blockWithItem(ModBlocks.CHISELED_POLISHED_HEMATITE);
        blockWithItem(ModBlocks.HEMATITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_HEMATITE_ORE);
        blockWithItem(ModBlocks.HEMATITE_BRICKS);
        blockWithItem(ModBlocks.POLISHED_HEMATITE);

        blockWithItem(ModBlocks.TALCUM_BLOCK);
        blockWithItem(ModBlocks.TALCUM_ORE);
        blockWithItem(ModBlocks.CALCITE_TALCUM_ORE);

        blockWithItem(ModBlocks.SANGUINITE_BLOCK);

        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);
        blockWithItem(ModBlocks.SILVER_BLOCK);

        stairsBlock(ModBlocks.POLISHED_HEMATITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        stairsBlock(ModBlocks.HEMATITE_BRICK_STAIRS.get(), blockTexture(ModBlocks.HEMATITE_BRICKS.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.POLISHED_HEMATITE_STAIRS);
        blockItem(ModBlocks.HEMATITE_BRICK_STAIRS);

        slabBlock(ModBlocks.POLISHED_HEMATITE_SLAB.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        slabBlock(ModBlocks.HEMATITE_BRICK_SLAB.get(), blockTexture(ModBlocks.HEMATITE_BRICKS.get()), blockTexture(ModBlocks.HEMATITE_BRICKS.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.POLISHED_HEMATITE_SLAB);
        blockItem(ModBlocks.HEMATITE_BRICK_SLAB);

        wallBlock(ModBlocks.POLISHED_HEMATITE_WALL.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        wallBlock(ModBlocks.HEMATITE_BRICK_WALL.get(), blockTexture(ModBlocks.HEMATITE_BRICKS.get()));

        makeCrop(((CropBlock) ModBlocks.GARLIC_CROP.get()), "garlic_crop_stage", "garlic_crop_stage");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GarlicCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, "block/" + textureName + state.getValue(((GarlicCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gothicafflictions:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gothicafflictions:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}
