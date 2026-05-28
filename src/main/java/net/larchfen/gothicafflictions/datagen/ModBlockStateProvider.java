package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GothicAfflictions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // FOR BLOCKS THAT ARE SIMPLE CUBES, JUST COPY THIS FOR IT.
        blockWithItem(ModBlocks.HEMATITE_BLOCK);
        blockWithItem(ModBlocks.HEMATITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_HEMATITE_ORE);
        blockWithItem(ModBlocks.HEMATITE_BRICKS);
        blockWithItem(ModBlocks.POLISHED_HEMATITE);

        stairsBlock(ModBlocks.POLISHED_HEMATITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        blockItem(ModBlocks.POLISHED_HEMATITE_STAIRS);

        slabBlock(ModBlocks.POLISHED_HEMATITE_SLAB.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));
        // MAKES IT SO THE ITEM MODEL ALSO WORKS
        blockItem(ModBlocks.POLISHED_HEMATITE_SLAB);

        wallBlock(ModBlocks.POLISHED_HEMATITE_WALL.get(), blockTexture(ModBlocks.POLISHED_HEMATITE.get()));

        blockWithItem(ModBlocks.TALCUM_BLOCK);
        blockWithItem(ModBlocks.TALCUM_ORE);
        blockWithItem(ModBlocks.CALCITE_TALCUM_ORE);

        blockWithItem(ModBlocks.SANGUINITE_BLOCK);



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
