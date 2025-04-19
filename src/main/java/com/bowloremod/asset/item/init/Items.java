package com.bowloremod.asset.item.init;

import com.bowloremod.BowlOreMod;
import com.bowloremod.asset.item.RawBowl;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class Items {
    public static final Item RAW_BOWL = registerItem("raw_bowl", new RawBowl(new FabricItemSettings()));

    @SuppressWarnings("SameParameterValue")
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BowlOreMod.MOD_ID, name), item);
    }

    @SuppressWarnings("SameParameterValue")
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_BOWL);
    }
}
