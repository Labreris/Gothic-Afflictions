package net.larchfen.gothicafflictions.block;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.custom.ColumnBlock;
import net.larchfen.gothicafflictions.block.custom.GarlicCropBlock;
import net.larchfen.gothicafflictions.block.custom.ModFlammableRotatedPillarBlock;
import net.larchfen.gothicafflictions.block.custom.WideColumnBlock;
import net.larchfen.gothicafflictions.item.ModItems;
import net.larchfen.gothicafflictions.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(GothicAfflictions.MOD_ID);

    // NEW BLOCKS GO HERE:
    // ORDER OF THINGS TO DO PER NEW BLOCK:
    // 1. ADD IT HERE 2. ADD TO CREATIVE MENU 3. ADD IT IN CORRECT DATAGEN CLASSES 4. ADD ASSETS 5. ADD TRANSLATION
    // 6. ADD RECIPES AND LOOTTABLE 7. ADD MINEABILITY

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_1 = registerBlock("ancient_oak_log_1",
            () -> new WideColumnBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_2 = registerBlock("ancient_oak_log_2",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_3 = registerBlock("ancient_oak_log_3",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_4 = registerBlock("ancient_oak_log_4",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_5 = registerBlock("ancient_oak_log_5",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_6 = registerBlock("ancient_oak_log_6",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_7 = registerBlock("ancient_oak_log_7",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> ANCIENT_OAK_LOG_8 = registerBlock("ancient_oak_log_8",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> HEARTWOOD_LOG = registerBlock("heartwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
            ));

    public static final DeferredBlock<Block> HEARTWOOD_WOOD = registerBlock("heartwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_WOOD)
            ));

    public static final DeferredBlock<Block> HEARTWOOD_PLANKS = registerBlock("heartwood_planks",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            }
            );

    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.RAW_GOLD_BLOCK)
            ));

    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GOLD_BLOCK)
            ));

    public static final DeferredBlock<Block> SANGUINITE_BLOCK = registerBlock("sanguinite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
            ));

    public static final DeferredBlock<Block> TALCUM_BLOCK = registerBlock("talcum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> CHISELED_POLISHED_HEMATITE = registerBlock("chiseled_polished_hematite",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.IRON_BLOCK)
            ));

    public static final DeferredBlock<Block> HEMATITE_BRICKS = registerBlock("hematite_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> POLISHED_HEMATITE = registerBlock("polished_hematite",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.IRON_BLOCK)
            ));

    public static final DeferredBlock<Block> HEMATITE_PILLAR = registerBlock("hematite_pillar",
            () -> new ColumnBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.IRON_BLOCK)
            ));

    public static final DeferredBlock<StairBlock> POLISHED_HEMATITE_STAIRS = registerBlock("polished_hematite_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_HEMATITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<SlabBlock> POLISHED_HEMATITE_SLAB = registerBlock("polished_hematite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));

    public static final DeferredBlock<WallBlock> POLISHED_HEMATITE_WALL = registerBlock("polished_hematite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<StairBlock> HEMATITE_BRICK_STAIRS = registerBlock("hematite_brick_stairs",
            () -> new StairBlock(ModBlocks.HEMATITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));

    public static final DeferredBlock<SlabBlock> HEMATITE_BRICK_SLAB = registerBlock("hematite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<WallBlock> HEMATITE_BRICK_WALL = registerBlock("hematite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GOLD_ORE)
            ));

    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)
            ));

    public static final DeferredBlock<Block> END_SILVER_ORE = registerBlock("end_silver_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GOLD_ORE)
            ));

    public static final DeferredBlock<Block> HEMATITE_ORE = registerBlock("hematite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DEEPSLATE_HEMATITE_ORE = registerBlock("deepslate_hematite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            ));

    public static final DeferredBlock<Block> TALCUM_ORE = registerBlock("talcum_ore",
            () -> new DropExperienceBlock(UniformInt.of(4, 8), BlockBehaviour.Properties.of()
                    .strength(1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> CALCITE_TALCUM_ORE = registerBlock("calcite_talcum_ore",
            () -> new DropExperienceBlock(UniformInt.of(4, 8), BlockBehaviour.Properties.of()
                    .strength(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)
            ));

    // IMPORTANT FOR CROP BLOCKS: Use BLOCKS.register instead of registerBlock because we do not want an autogenerated block item
    // When we do it this way, we can instead make the crop block drop the seed that it is supposed to drop instead of itself.
    public static final DeferredBlock<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
