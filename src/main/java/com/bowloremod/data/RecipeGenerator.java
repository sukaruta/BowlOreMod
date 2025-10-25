package com.bowloremod.data;

import com.bowloremod.asset.item.init.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(Items.RAW_BOWL), RecipeCategory.MISC, net.minecraft.item.Items.BOWL,
                0.7f, 200, "bowl");
        offerBlasting(exporter, List.of(Items.RAW_BOWL), RecipeCategory.MISC, net.minecraft.item.Items.BOWL,
                0.7f, 100, "bowl");

        // JUST AN EXAMPLE
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RAW_BOWL)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', net.minecraft.item.Items.STONE)
                .input('C', net.minecraft.item.Items.BOWL)
                .criterion(FabricRecipeProvider.hasItem(net.minecraft.item.Items.STONE),
                        FabricRecipeProvider.conditionsFromItem(net.minecraft.item.Items.STONE))
                .criterion(FabricRecipeProvider.hasItem(net.minecraft.item.Items.BOWL),
                        FabricRecipeProvider.conditionsFromItem(net.minecraft.item.Items.BOWL))
                .offerTo(exporter, Identifier.of(FabricRecipeProvider.getRecipeName(Items.RAW_BOWL)));
    }
}
