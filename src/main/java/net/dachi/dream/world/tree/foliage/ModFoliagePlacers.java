package net.dachi.dream.world.tree.foliage;

import net.dachi.dream.Dream;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Dream.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<DreamFoliagePlacer>> DREAM_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("dream_foliage_placer", () -> new FoliagePlacerType<>(DreamFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}