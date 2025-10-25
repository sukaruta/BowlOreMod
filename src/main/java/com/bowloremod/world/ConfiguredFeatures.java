package com.bowloremod.world;

import com.bowloremod.BowlOreMod;
import com.bowloremod.asset.block.init.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BOWL_ORE_KEY = registerKey("bowl_ore");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldBowlOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, Blocks.BOWL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, Blocks.DEEPSLATE_BOWL_ORE.getDefaultState()));

        register(context, BOWL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBowlOres, 12));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BowlOreMod.MOD_ID, name));
    }

    @SuppressWarnings("SameParameterValue")
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
