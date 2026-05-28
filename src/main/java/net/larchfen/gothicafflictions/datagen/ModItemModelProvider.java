package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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

    }
}
