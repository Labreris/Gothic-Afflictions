package net.larchfen.gothicafflictions.util;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.component.ModDataComponents;
import net.larchfen.gothicafflictions.item.ModItems;
import net.larchfen.gothicafflictions.item.custom.ScepterItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties() {

        // ItemProperties.register(ModItems.SANGUINITE_SCEPTER.get(), ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, "used"),
                // (itemStack, clientLevel, livingEntity, i) -> itemStack.get() != false ? 1f : 0f);
    }
}
