package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.block.custom.GarlicCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
        blockWithItem(ModBlocks.END_SILVER_ORE);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.SILVER_BRICKS);

        blockWithItem(ModBlocks.HEARTWOOD_PLANKS);
        blockWithItem(ModBlocks.DUSKWOOD_PLANKS);

        logBlock((RotatedPillarBlock) ModBlocks.HEARTWOOD_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.HEARTWOOD_WOOD.get()), blockTexture(ModBlocks.HEARTWOOD_LOG.get()), blockTexture(ModBlocks.HEARTWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.ANCIENT_OAK_WOOD.get()), blockTexture(Blocks.OAK_LOG), blockTexture(Blocks.OAK_LOG));
        blockItem(ModBlocks.HEARTWOOD_LOG);
        blockItem(ModBlocks.HEARTWOOD_WOOD);
        blockItem(ModBlocks.ANCIENT_OAK_WOOD);

        logBlock((RotatedPillarBlock) ModBlocks.DUSKWOOD_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_DUSKWOOD_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.DUSKWOOD_WOOD.get()), blockTexture(ModBlocks.DUSKWOOD_LOG.get()), blockTexture(ModBlocks.DUSKWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DUSKWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DUSKWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_DUSKWOOD_LOG.get()));
        blockItem(ModBlocks.DUSKWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_DUSKWOOD_LOG);
        blockItem(ModBlocks.DUSKWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_DUSKWOOD_WOOD);
        leavesBlock(ModBlocks.DUSKWOOD_LEAVES_ORANGE);
        leavesBlock(ModBlocks.DUSKWOOD_LEAVES_RED);
        leavesBlock(ModBlocks.DUSKWOOD_LEAVES_BLACK);
        saplingBlock(ModBlocks.DUSKWOOD_SAPLING_ORANGE);
        saplingBlock(ModBlocks.DUSKWOOD_SAPLING_RED);
        saplingBlock(ModBlocks.DUSKWOOD_SAPLING_BLACK);



        blockItem(ModBlocks.HEARTWOOD_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.DUSKWOOD_TRAPDOOR, "_bottom");

        stairsBlock(ModBlocks.POLISHED_HEMATITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        stairsBlock(ModBlocks.HEMATITE_BRICK_STAIRS.get(), blockTexture(ModBlocks.HEMATITE_BRICKS.get()));
        stairsBlock(ModBlocks.HEARTWOOD_STAIRS.get(), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()));
        stairsBlock(ModBlocks.DUSKWOOD_STAIRS.get(), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.POLISHED_HEMATITE_STAIRS);
        blockItem(ModBlocks.HEMATITE_BRICK_STAIRS);
        blockItem(ModBlocks.HEARTWOOD_STAIRS);
        blockItem(ModBlocks.DUSKWOOD_STAIRS);

        slabBlock(ModBlocks.POLISHED_HEMATITE_SLAB.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        slabBlock(ModBlocks.HEMATITE_BRICK_SLAB.get(), blockTexture(ModBlocks.HEMATITE_BRICKS.get()), blockTexture(ModBlocks.HEMATITE_BRICKS.get()));
        slabBlock(ModBlocks.HEARTWOOD_SLAB.get(), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()));
        slabBlock(ModBlocks.DUSKWOOD_SLAB.get(), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.POLISHED_HEMATITE_SLAB);
        blockItem(ModBlocks.HEMATITE_BRICK_SLAB);
        blockItem(ModBlocks.HEARTWOOD_SLAB);
        blockItem(ModBlocks.DUSKWOOD_SLAB);

        pressurePlateBlock(ModBlocks.HEARTWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()));
        pressurePlateBlock(ModBlocks.DUSKWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.HEARTWOOD_PRESSURE_PLATE);
        blockItem(ModBlocks.DUSKWOOD_PRESSURE_PLATE);

        buttonBlock(ModBlocks.HEARTWOOD_BUTTON.get(), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()));
        buttonBlock(ModBlocks.DUSKWOOD_BUTTON.get(), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()));

        wallBlock(ModBlocks.POLISHED_HEMATITE_WALL.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        wallBlock(ModBlocks.HEMATITE_BRICK_WALL.get(), blockTexture(ModBlocks.HEMATITE_BRICKS.get()));
        fenceBlock(ModBlocks.HEARTWOOD_FENCE.get(), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()));
        fenceGateBlock(ModBlocks.HEARTWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.HEARTWOOD_PLANKS.get()));
        fenceBlock(ModBlocks.DUSKWOOD_FENCE.get(), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()));
        fenceGateBlock(ModBlocks.DUSKWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.DUSKWOOD_PLANKS.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.HEARTWOOD_FENCE_GATE);
        blockItem(ModBlocks.DUSKWOOD_FENCE_GATE);

        doorBlockWithRenderType(ModBlocks.HEARTWOOD_DOOR.get(), modLoc("block/heartwood_door_bottom"), modLoc("block/heartwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.HEARTWOOD_TRAPDOOR.get(), modLoc("block/heartwood_trapdoor"), true, "cutout");
        doorBlockWithRenderType(ModBlocks.DUSKWOOD_DOOR.get(), modLoc("block/duskwood_door_bottom"), modLoc("block/duskwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.DUSKWOOD_TRAPDOOR.get(), modLoc("block/duskwood_trapdoor"), true, "cutout");

        makeCrop(((CropBlock) ModBlocks.GARLIC_CROP.get()), "garlic_crop_stage", "garlic_crop_stage");
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
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
