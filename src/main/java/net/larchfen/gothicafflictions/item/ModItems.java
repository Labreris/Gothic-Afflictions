package net.larchfen.gothicafflictions.item;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.item.custom.ChiselItem;
import net.larchfen.gothicafflictions.item.custom.HammerItem;
import net.larchfen.gothicafflictions.item.custom.ScepterItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GothicAfflictions.MOD_ID);

        // NEW ITEMS GO IN HERE. 1. ADD IT HERE 2. ADD TO CREATIVE TAB 3. ADD ASSETS 4. ADD DATA-GEN ENTRIES 5. ADD TRANSLATION
        // 6. ADD RECIPES (IF ANY)

        // TESTING ITEM REMOVE LATER
        public static final DeferredItem<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle",
                () -> new Item(new Item.Properties()));
        // TESTING ITEM FOR "ADVANCED" ITEM CODE
        public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
                () -> new ChiselItem(new Item.Properties().durability(32)));

        public static final DeferredItem<Item> HEMATITE = ITEMS.register("hematite",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> HEMATITE_NUGGET = ITEMS.register("hematite_nugget",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> HEMATITE_POWDER = ITEMS.register("hematite_powder",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> TALCUM = ITEMS.register("talcum",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> TALCUM_POWDER = ITEMS.register("talcum_powder",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> SANGUINITE_INGOT = ITEMS.register("sanguinite_ingot",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> BLOODSTONE = ITEMS.register("bloodstone",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> GARLIC_SEEDS = ITEMS.register("garlic_seeds",
                () -> new ItemNameBlockItem(ModBlocks.GARLIC_CROP.get(), new Item.Properties()));

        public static final DeferredItem<Item> GARLIC = ITEMS.register("garlic",
                () -> new Item(new Item.Properties().food(ModFoodProperties.GARLIC)));

        public static final DeferredItem<SwordItem> RITUAL_DAGGER = ITEMS.register("ritual_dagger",
                () -> new SwordItem(Tiers.STONE, new Item.Properties()
                        .attributes(SwordItem.createAttributes(Tiers.STONE, 2, -2.4f)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.ritual_dagger.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        // SILVER TOOLS
        public static final DeferredItem<SwordItem> SILVER_SWORD = ITEMS.register("silver_sword",
                () -> new SwordItem(ModToolTiers.SILVER, new Item.Properties()
                        .attributes(SwordItem.createAttributes(ModToolTiers.SILVER, 3, -2.4f)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_held_item.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<PickaxeItem> SILVER_PICKAXE = ITEMS.register("silver_pickaxe",
                () -> new PickaxeItem(ModToolTiers.SILVER, new Item.Properties()
                        .attributes(PickaxeItem.createAttributes(ModToolTiers.SILVER, 1.0f, -2.8f)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_held_item.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<ShovelItem> SILVER_SHOVEL = ITEMS.register("silver_shovel",
                () -> new ShovelItem(ModToolTiers.SILVER, new Item.Properties()
                        .attributes(ShovelItem.createAttributes(ModToolTiers.SILVER, 1.5f, -3.0f)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_held_item.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<AxeItem> SILVER_AXE = ITEMS.register("silver_axe",
                () -> new AxeItem(ModToolTiers.SILVER, new Item.Properties()
                        .attributes(AxeItem.createAttributes(ModToolTiers.SILVER, 6, -3.1f)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_held_item.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<HoeItem> SILVER_HOE = ITEMS.register("silver_hoe",
                () -> new HoeItem(ModToolTiers.SILVER, new Item.Properties()
                        .attributes(HoeItem.createAttributes(ModToolTiers.SILVER, -2.0f, -1)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_held_item.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<HammerItem> SILVER_HAMMER = ITEMS.register("silver_hammer",
                () -> new HammerItem(ModToolTiers.SILVER, new Item.Properties()
                        .attributes(PickaxeItem.createAttributes(ModToolTiers.SILVER, 7, -3.5f)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_held_item.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        // SILVER ARMOR

        public static final DeferredItem<ArmorItem> SILVER_HELMET = ITEMS.register("silver_helmet",
                () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                        new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_armor.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<ArmorItem> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate",
                () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                        new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(11)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_armor.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<ArmorItem> SILVER_LEGGINGS = ITEMS.register("silver_leggings",
                () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                        new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(11)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_armor.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        public static final DeferredItem<ArmorItem> SILVER_BOOTS = ITEMS.register("silver_boots",
                () -> new ArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                        new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(11)))
                {
                        @Override
                        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.gothic_afflictions.silver_armor.tooltip"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                        }
                });

        // SANGUINITE TOOLS (MIGHT REPLACE LATER)

        public static final DeferredItem<SwordItem> SANGUINITE_SWORD = ITEMS.register("sanguinite_sword",
                () -> new SwordItem(ModToolTiers.SANGUINITE, new Item.Properties()
                        .attributes(SwordItem.createAttributes(ModToolTiers.SANGUINITE, 3, -2.4f))));

        public static final DeferredItem<ScepterItem> SANGUINITE_SCEPTER = ITEMS.register("sanguinite_scepter",
                () -> new ScepterItem(ModToolTiers.SANGUINITE, new Item.Properties()
                        .attributes(ScepterItem.createAttributes(ModToolTiers.SANGUINITE, 3, -2.4f))));

        // TESTING ITEM FOR FUEL CODE
        public static final DeferredItem<Item> ALCHEMICAL_FLAME = ITEMS.register("alchemical_flame",
                () -> new Item(new Item.Properties()));
        // TESTING ITEM FOR FUEL CODE
        public static final DeferredItem<Item> BURNING_ALKAHEST = ITEMS.register("burning_alkahest",
                () -> new Item(new Item.Properties()));

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
}
