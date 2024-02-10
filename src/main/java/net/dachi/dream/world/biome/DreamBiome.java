package net.dachi.dream.world.biome;

import net.dachi.dream.block.ModBlocks;
import net.dachi.dream.world.feature.ModConfiguredFeatures;
import net.dachi.dream.world.tree.foliage.DreamFoliagePlacer;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DreamBiome {
    public static Biome createBiome() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-13369345).waterColor(-13369345).waterFogColor(-13369345)
                .skyColor(-13369345).foliageColorOverride(-13369345).grassColorOverride(-13369345).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
       //biomeGenerationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES,
       //        PlacementUtils.register("dream:dream_block_patch", ModConfiguredFeatures.DREAM_PATCH.getHolder().get(),List.of(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(1),
       //                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("dream:tree_dream_biome",
                FeatureUtils.register("dream:tree_dream_biome", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.DREAM_LOG.get().defaultBlockState()),
                                new StraightTrunkPlacer(3, 2, 0), BlockStateProvider.simple(ModBlocks.DREAM_BLOCK.get().defaultBlockState()),
                                new DreamFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).build()),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
        //biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,PlacementUtils.register("huge_brown_mushroom", (Holder<? extends ConfiguredFeature<?, ?>>) Feature.HUGE_BROWN_MUSHROOM,
        //        new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(true))
        //                .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 3)));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("dream:grass_dream_biome", VegetationFeatures.PATCH_GRASS,
                        List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("dream:flower_dream_biome", VegetationFeatures.FLOWER_DEFAULT, List.of(CountPlacement.of(4),
                        RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.5f).specialEffects(effects)
                .mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
    }
}

