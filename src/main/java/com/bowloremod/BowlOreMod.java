package com.bowloremod;

import com.bowloremod.asset.item.init.Items;
import com.bowloremod.world.gen.WorldGeneration;
import net.fabricmc.api.ModInitializer;
import com.bowloremod.asset.block.init.Blocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BowlOreMod implements ModInitializer {
	public static final String MOD_ID = "bowl-ore-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Items.registerModItems();
		Blocks.registerModBlocks();

		WorldGeneration.generateWorldGen();
	}
}