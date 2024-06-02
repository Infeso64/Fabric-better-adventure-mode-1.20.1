package net.infeso.betteradventuremode;

import net.fabricmc.api.ModInitializer;

import net.infeso.betteradventuremode.item.ModItemGroups;
import net.infeso.betteradventuremode.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterAdventureMode implements ModInitializer {
	public static final String MOD_ID = "betteradventuremode";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.registerModItem();
		ModItemGroups.registerItemGroups();
	}
}