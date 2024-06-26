package net.infeso.betteradventuremode;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.infeso.betteradventuremode.block.ModBlocks;
import net.infeso.betteradventuremode.item.ModItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterAdventureMode implements ModInitializer {
	public static final String MOD_ID = "betteradventuremode";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
	}
}