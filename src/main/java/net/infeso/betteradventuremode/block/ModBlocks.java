package net.infeso.betteradventuremode.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.infeso.betteradventuremode.BetterAdventureMode;
import net.infeso.betteradventuremode.block.custom.BaseMarkerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    public static final Block BASE_MARKER = registerBlock("base_marker",
            new BaseMarkerBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(BetterAdventureMode.MOD_ID,name),block);
    }
    public static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(BetterAdventureMode.MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }
    public static void registerModBlocks()
    {
        BetterAdventureMode.LOGGER.info("Registering ModBlocks for "+ BetterAdventureMode.MOD_ID);
    }
}
