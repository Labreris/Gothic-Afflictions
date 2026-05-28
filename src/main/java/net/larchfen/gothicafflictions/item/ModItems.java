package net.larchfen.gothicafflictions.item;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.item.custom.ChiselItem;
import net.larchfen.gothicafflictions.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GothicAfflictions.MOD_ID);

        // NEW ITEMS GO IN HERE. 1. ADD IT HERE 2. ADD TO CREATIVE TAB 3. ADD ASSETS 4. ADD DATA-GEN ENTRY 5. ADD TRANSLATION
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

        public static final DeferredItem<Item> BLOODSTONE = ITEMS.register("bloodstone",
                () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> GARLIC = ITEMS.register("garlic",
                () -> new Item(new Item.Properties().food(ModFoodProperties.GARLIC)));

        // TESTING ITEM FOR FUEL CODE
        public static final DeferredItem<Item> ALCHEMICAL_FLAME = ITEMS.register("alchemical_flame",
                () -> new FuelItem(new Item.Properties(),800));
        // TESTING ITEM FOR FUEL CODE
        public static final DeferredItem<Item> BURNING_ALKAHEST = ITEMS.register("burning_alkahest",
                () -> new Item(new Item.Properties()));

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
}
