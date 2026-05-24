package net.larchfen.gothicafflictions.block;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.custom.ColumnBlock;
import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(GothicAfflictions.MOD_ID);

    // NEW BLOCKS GO HERE:
    // ORDER OF THINGS TO DO PER NEW BLOCK: 1. ADD IT HERE 2. ADD TO CREATIVE MENU 3. ADD BLOCKSTATES 4. ADD BLOCK MODEL
    // 5. ADD ITEM MODEL 6. ADD ASSETS 7. ADD TRANSLATION 8. ADD RECIPES AND LOOTTABLE 9. ADD MINEABILITY

    public static final DeferredBlock<Block> HEMATITE_BLOCK = registerBlock("hematite_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> HEMATITE_BRICKS = registerBlock("hematite_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> HEMATITE_PILLAR = registerBlock("hematite_pillar",
            () -> new ColumnBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

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

    public static final DeferredBlock<Block> TALCUM_BLOCK = registerBlock("talcum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.75f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)));

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
