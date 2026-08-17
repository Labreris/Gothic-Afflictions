package net.larchfen.gothicafflictions.item;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GothicAfflictions.MOD_ID);

    public static final Supplier<CreativeModeTab> GOTHIC_AFFLICTIONS_ITEMS_TAB = CREATIVE_MODE_TAB.register("gothic_afflictions_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BLOODSTONE.get()))
                    .title(Component.translatable("creativetab.gothicafflictions.gothic_affliction_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                      //CREATIVE MODE TAB ITEMS GO HERE

                        output.accept(ModItems.MORTAR_AND_PESTLE);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.HEMATITE);
                        output.accept(ModItems.HEMATITE_NUGGET);
                        output.accept(ModItems.HEMATITE_POWDER);
                        output.accept(ModItems.TALCUM);
                        output.accept(ModItems.TALCUM_POWDER);
                        output.accept(ModItems.SANGUINITE_INGOT);
                        output.accept(ModItems.RAW_SILVER);
                        output.accept(ModItems.SILVER_INGOT);
                        output.accept(ModItems.SILVER_NUGGET);
                        output.accept(ModItems.BLOODSTONE);
                        output.accept(ModItems.GARLIC);
                        output.accept(ModItems.GARLIC_SEEDS);
                        output.accept(ModItems.ALCHEMICAL_FLAME);
                        output.accept(ModItems.BURNING_ALKAHEST);

                        output.accept(ModItems.SILVER_SWORD);
                        output.accept(ModItems.SILVER_PICKAXE);
                        output.accept(ModItems.SILVER_AXE);
                        output.accept(ModItems.SILVER_SHOVEL);
                        output.accept(ModItems.SILVER_HOE);

                        output.accept(ModItems.SILVER_HAMMER);

                        output.accept(ModItems.SILVER_HELMET);
                        output.accept(ModItems.SILVER_CHESTPLATE);
                        output.accept(ModItems.SILVER_LEGGINGS);
                        output.accept(ModItems.SILVER_BOOTS);

                        output.accept(ModItems.SANGUINITE_SWORD);
                        output.accept(ModItems.SANGUINITE_SCEPTER);

                    }).build());

    public static final Supplier<CreativeModeTab> GOTHIC_AFFLICTIONS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("gothic_afflictions_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CHISELED_POLISHED_HEMATITE.get()))
                    //BELOW DETERMINES WHICH CREATIVE MENU TAB COMES BEFORE IT
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, "gothic_afflictions_items_tab"))
                    .title(Component.translatable("creativetab.gothicafflictions.gothic_affliction_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //CREATIVE MODE TAB BLOCKS GO HERE

                        output.accept(ModBlocks.HEMATITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_HEMATITE_ORE);
                        output.accept(ModBlocks.CHISELED_POLISHED_HEMATITE);
                        output.accept(ModBlocks.HEMATITE_BRICKS);
                        output.accept(ModBlocks.HEMATITE_BRICK_STAIRS);
                        output.accept(ModBlocks.HEMATITE_BRICK_SLAB);
                        output.accept(ModBlocks.HEMATITE_BRICK_WALL);
                        output.accept(ModBlocks.HEMATITE_PILLAR);
                        output.accept(ModBlocks.POLISHED_HEMATITE);
                        output.accept(ModBlocks.POLISHED_HEMATITE_SLAB);
                        output.accept(ModBlocks.POLISHED_HEMATITE_WALL);
                        output.accept(ModBlocks.POLISHED_HEMATITE_STAIRS);
                        output.accept(ModBlocks.TALCUM_ORE);
                        output.accept(ModBlocks.CALCITE_TALCUM_ORE);
                        output.accept(ModBlocks.TALCUM_BLOCK);
                        output.accept(ModBlocks.SILVER_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
                        output.accept(ModBlocks.END_SILVER_ORE);
                        output.accept(ModBlocks.RAW_SILVER_BLOCK);
                        output.accept(ModBlocks.SILVER_BLOCK);
                        output.accept(ModBlocks.SANGUINITE_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
