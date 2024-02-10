package net.dachi.dream.world.dimension;

import net.dachi.dream.Dream;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> DREAM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Dream.MOD_ID, "dream"));
    public static final ResourceKey<DimensionType> DREAM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(Dream.MOD_ID, "dream_type"));
    public static final ResourceKey<Level> NIGHTMARE_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Dream.MOD_ID, "nightmare"));
    public static final ResourceKey<DimensionType> NIGHTMARE_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(Dream.MOD_ID, "nightmare_type"));


    public static void register() {
        System.out.println("Registering ModDimensions for " + Dream.MOD_ID);
    }
}
