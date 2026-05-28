package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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

        blockWithItem(ModBlocks.TALCUM_BLOCK);
        blockWithItem(ModBlocks.TALCUM_ORE);
        blockWithItem(ModBlocks.CALCITE_TALCUM_ORE);

        blockWithItem(ModBlocks.SANGUINITE_BLOCK);


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}
