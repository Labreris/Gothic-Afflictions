package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.block.custom.GarlicCropBlock;
import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.DUSKWOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_DUSKWOOD_LOG.get());
        dropSelf(ModBlocks.DUSKWOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_DUSKWOOD_WOOD.get());
        dropSelf(ModBlocks.DUSKWOOD_SAPLING_ORANGE.get());
        dropSelf(ModBlocks.DUSKWOOD_SAPLING_RED.get());
        dropSelf(ModBlocks.DUSKWOOD_SAPLING_BLACK.get());


        add(ModBlocks.DUSKWOOD_LEAVES_ORANGE.get(), block ->
                createLeavesDrops(block, ModBlocks.DUSKWOOD_SAPLING_ORANGE.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.DUSKWOOD_LEAVES_RED.get(), block ->
                createLeavesDrops(block, ModBlocks.DUSKWOOD_SAPLING_RED.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.DUSKWOOD_LEAVES_BLACK.get(), block ->
                createLeavesDrops(block, ModBlocks.DUSKWOOD_SAPLING_BLACK.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.CHISELED_POLISHED_HEMATITE.get());
        dropSelf(ModBlocks.HEMATITE_BRICKS.get());
        dropSelf(ModBlocks.HEMATITE_BRICK_WALL.get());
        dropSelf(ModBlocks.POLISHED_HEMATITE_WALL.get());

        dropSelf(ModBlocks.HEARTWOOD_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.HEARTWOOD_BUTTON.get());
        dropSelf(ModBlocks.HEARTWOOD_FENCE.get());
        dropSelf(ModBlocks.HEARTWOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.HEARTWOOD_STAIRS.get());
        dropSelf(ModBlocks.HEARTWOOD_PLANKS.get());
        dropSelf(ModBlocks.HEARTWOOD_LOG.get());
        dropSelf(ModBlocks.HEARTWOOD_WOOD.get());
        dropSelf(ModBlocks.HEARTWOOD_TRAPDOOR.get());

        dropSelf(ModBlocks.DUSKWOOD_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.DUSKWOOD_BUTTON.get());
        dropSelf(ModBlocks.DUSKWOOD_FENCE.get());
        dropSelf(ModBlocks.DUSKWOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.DUSKWOOD_STAIRS.get());
        dropSelf(ModBlocks.DUSKWOOD_PLANKS.get());
        dropSelf(ModBlocks.DUSKWOOD_LOG.get());
        dropSelf(ModBlocks.DUSKWOOD_WOOD.get());
        dropSelf(ModBlocks.DUSKWOOD_TRAPDOOR.get());

        dropSelf(ModBlocks.HEMATITE_PILLAR.get());
        dropSelf(ModBlocks.POLISHED_HEMATITE.get());
        dropSelf(ModBlocks.HEMATITE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_HEMATITE_STAIRS.get());


        add(ModBlocks.POLISHED_HEMATITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_HEMATITE_SLAB.get()));
        add(ModBlocks.HEMATITE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HEMATITE_BRICK_SLAB.get()));

        add(ModBlocks.HEARTWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HEARTWOOD_SLAB.get()));
        add(ModBlocks.DUSKWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DUSKWOOD_SLAB.get()));

        dropSelf(ModBlocks.TALCUM_BLOCK.get());
        dropSelf(ModBlocks.SANGUINITE_BLOCK.get());

        dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.SILVER_BRICKS.get());



        add(ModBlocks.HEARTWOOD_DOOR.get(), this::createDoorTable);

        add(ModBlocks.DUSKWOOD_DOOR.get(), this::createDoorTable);

        dropOther(ModBlocks.ANCIENT_OAK_WOOD.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_2.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_3.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_4.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_5.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_6.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_7.get(), Blocks.OAK_LOG.asItem());
        dropOther(ModBlocks.ANCIENT_OAK_LOG_8.get(), Blocks.OAK_LOG.asItem());


        // FOR ORES WITH A SIMPLE 1 ITEM DROP
        add(ModBlocks.HEMATITE_ORE.get(),
                block -> createOreDrop(ModBlocks.HEMATITE_ORE.get(), ModItems.HEMATITE.get()));
        add(ModBlocks.DEEPSLATE_HEMATITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_HEMATITE_ORE.get(), ModItems.HEMATITE.get()));
        add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.END_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.END_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        // FOR ORES THAT DROP MULTIPLES OF ONE ITEM
        add(ModBlocks.TALCUM_ORE.get(),
                block -> createOreDrop(ModBlocks.TALCUM_ORE.get(), ModItems.TALCUM.get()));
        add(ModBlocks.CALCITE_TALCUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CALCITE_TALCUM_ORE.get(), ModItems.TALCUM.get()));

        // FOR GARLIC CROPS
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GARLIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 3));
        this.add(ModBlocks.GARLIC_CROP.get(), this.createCropDrops(ModBlocks.GARLIC_CROP.get(),
                ModItems.GARLIC.get(), ModItems.GARLIC_SEEDS.get(), lootItemConditionBuilder));

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
