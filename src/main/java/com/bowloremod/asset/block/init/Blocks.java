package com.bowloremod.asset.block.init;

import com.bowloremod.BowlOreMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


public class Blocks {
    public static final Block BOWL_ORE = registerBlock("bowl_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.COAL_ORE))), ItemGroups.NATURAL);

    public static final Block DEEPSLATE_BOWL_ORE = registerBlock("deepslate_bowl_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.DEEPSLATE_COAL_ORE))), ItemGroups.NATURAL);

    @SuppressWarnings("SameParameterValue")
    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registries.BLOCK, new Identifier(BowlOreMod.MOD_ID, name), block);
    }

    @SuppressWarnings("UnusedReturnValue")
    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> itemGroup) {
        Item item = Registry.register(Registries.ITEM, new Identifier(BowlOreMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        BowlOreMod.LOGGER.info("Registering blocks...");
    }
}
