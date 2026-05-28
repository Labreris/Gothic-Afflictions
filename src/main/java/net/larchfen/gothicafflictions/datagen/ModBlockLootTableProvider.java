package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.HEMATITE_BLOCK.get());
        dropSelf(ModBlocks.HEMATITE_BRICKS.get());
        dropSelf(ModBlocks.HEMATITE_PILLAR.get());
        dropSelf(ModBlocks.POLISHED_HEMATITE.get());
        dropSelf(ModBlocks.POLISHED_HEMATITE_WALL.get());
        dropSelf(ModBlocks.POLISHED_HEMATITE_STAIRS.get());
        add(ModBlocks.POLISHED_HEMATITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_HEMATITE_SLAB.get()));

        dropSelf(ModBlocks.TALCUM_BLOCK.get());

        dropSelf(ModBlocks.SANGUINITE_BLOCK.get());

        // FOR ORES WITH A SIMPLE 1 ITEM DROP
        add(ModBlocks.HEMATITE_ORE.get(),
                block -> createOreDrop(ModBlocks.HEMATITE_ORE.get(), ModItems.HEMATITE.get()));
        add(ModBlocks.DEEPSLATE_HEMATITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_HEMATITE_ORE.get(), ModItems.HEMATITE.get()));

        // FOR ORES THAT DROP MULTIPLES OF ONE ITEM
        add(ModBlocks.TALCUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.TALCUM_ORE.get(), ModItems.TALCUM.get(),1,3));
        add(ModBlocks.CALCITE_TALCUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.CALCITE_TALCUM_ORE.get(), ModItems.TALCUM.get(),1,3));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
