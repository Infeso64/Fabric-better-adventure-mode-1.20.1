package net.infeso.betteradventuremode.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.infeso.betteradventuremode.BetterAdventureMode;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BetterAdventureMode.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterAdventureMode.LOGGER.info("Registering Mod Items for " + BetterAdventureMode.MOD_ID);

    }
}
