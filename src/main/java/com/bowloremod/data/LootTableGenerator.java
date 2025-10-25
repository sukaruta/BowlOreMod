package com.bowloremod.data;

import com.bowloremod.asset.block.init.Blocks;
import com.bowloremod.asset.item.init.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(Blocks.BOWL_ORE, oreDrops(Blocks.BOWL_ORE, Items.RAW_BOWL));
        addDrop(Blocks.DEEPSLATE_BOWL_ORE, oreDrops(Blocks.DEEPSLATE_BOWL_ORE, Items.RAW_BOWL));
    }
}
