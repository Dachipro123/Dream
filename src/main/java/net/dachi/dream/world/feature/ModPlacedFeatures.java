package net.dachi.dream.world.feature;

import net.dachi.dream.Dream;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Dream.MOD_ID);


    public static final RegistryObject<PlacedFeature> DREAM_ORE_PLACED = PLACED_FEATURES.register("dream_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DREAM_ORE.getHolder().get(),
                    commonOrePlacement(7, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> END_DREAM_ORE_PLACED = PLACED_FEATURES.register("end_dream_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_DREAM_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_DREAM_ORE_PLACED = PLACED_FEATURES.register("nether_dream_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_DREAM_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> RED_ROSE_PLACED = PLACED_FEATURES.register("red_rose_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RED_ROSE.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    //public static final RegistryObject<PlacedFeature> DREAM_PATCH_PLACED = PLACED_FEATURES.register("dream_patch_placed",
    //        () -> new PlacedFeature(ModConfiguredFeatures.DREAM_PATCH.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(1),
    //                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
