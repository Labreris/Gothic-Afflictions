package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.BURNING_ALKAHEST.getId(), new FurnaceFuel(3200), false)
                .add(ModItems.ALCHEMICAL_FLAME.getId(), new FurnaceFuel(1600), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.GARLIC_SEEDS.getId(), new Compostable(0.25f), false)
                .add(ModItems.GARLIC.getId(), new Compostable(0.45f), false);
    }
}
