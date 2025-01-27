package com.duck123acb.obamiummod.worldgen;

import com.duck123acb.obamiummod.ObamiumMod;
import com.duck123acb.obamiummod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_OBAMIUM_ORE_KEY = registerKey("obamium_ore");
//    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BIDENITE_ORE_KEY = registerKey("bidenite_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.OBAMIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(stoneReplaceables, ModBlocks.BIDENITE_ORE.get().defaultBlockState())
        );

        register(context, OVERWORLD_OBAMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ObamiumMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
