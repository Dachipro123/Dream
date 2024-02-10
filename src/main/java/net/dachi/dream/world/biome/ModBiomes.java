package net.dachi.dream.world.biome;

import net.dachi.dream.Dream;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBiomes {
    public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, Dream.MOD_ID);
    public static final RegistryObject<Biome> DREAM_BIOME = REGISTRY.register("dream_biome", DreamBiome::createBiome);
    public static final RegistryObject<Biome> NIGHTMARE_BIOME = REGISTRY.register("nightmare_biome", NightmareBiome::createBiome);
}

