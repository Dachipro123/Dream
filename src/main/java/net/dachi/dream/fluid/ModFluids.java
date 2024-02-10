package net.dachi.dream.fluid;

import net.dachi.dream.Dream;
import net.dachi.dream.block.ModBlocks;
import net.dachi.dream.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Dream.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_DREAMY_WATER = FLUIDS.register("dreamy_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.DREAMY_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DREAMY_WATER = FLUIDS.register("flowing_dreamy_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DREAMY_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties DREAMY_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.DREAMY_WATER_FLUID_TYPE, SOURCE_DREAMY_WATER, FLOWING_DREAMY_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.DREAMY_WATER_BLOCK).bucket(ModItems.DREAMY_WATER_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
