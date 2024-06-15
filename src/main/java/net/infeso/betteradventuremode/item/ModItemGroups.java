package net.infeso.betteradventuremode.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.infeso.betteradventuremode.BetterAdventureMode;
import net.infeso.betteradventuremode.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BETTERADVENTUREMODE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BetterAdventureMode.MOD_ID, "base_marker"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.name"))
                    .icon(() -> new ItemStack(ModBlocks.BASE_MARKER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BASE_MARKER);
                    }).build());


    public static void registerItemGroups() {
        BetterAdventureMode.LOGGER.info("Registering Item Groups for " + BetterAdventureMode.MOD_ID);
    }
}
