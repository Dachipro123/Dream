package net.dachi.dream;

import com.mojang.logging.LogUtils;
import net.dachi.dream.block.ModBlocks;
import net.dachi.dream.block.entity.ModBlockEntities;
import net.dachi.dream.entity.ModEntityTypes;
import net.dachi.dream.entity.client.FlyingHorseRenderer;
import net.dachi.dream.entity.client.NightmareBlazeRenderer;
import net.dachi.dream.entity.client.NightmareBossRenderer;
import net.dachi.dream.entity.client.StalkerRenderer;
import net.dachi.dream.fluid.ModFluidTypes;
import net.dachi.dream.fluid.ModFluids;
import net.dachi.dream.item.ModItems;
import net.dachi.dream.networking.ModMessages;
import net.dachi.dream.particle.ModParticleTypes;
import net.dachi.dream.recipe.ModRecipes;
import net.dachi.dream.screen.DreamForgerScreen;
import net.dachi.dream.screen.ModMenuTypes;
import net.dachi.dream.villager.ModVillagers;
import net.dachi.dream.world.biome.ModBiomes;
import net.dachi.dream.world.dimension.ModDimensions;
import net.dachi.dream.world.feature.ModConfiguredFeatures;
import net.dachi.dream.world.feature.ModPlacedFeatures;
import net.dachi.dream.world.tree.foliage.ModFoliagePlacers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Dream.MOD_ID)
public class Dream
{
    public static final String MOD_ID = "dream";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Dream()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModBiomes.REGISTRY.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);
        ModDimensions.register();
        ModParticleTypes.register(modEventBus);
        ModFoliagePlacers.register(modEventBus);

        GeckoLib.initialize();


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.NIGHTMARE_BLAZE.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.RED_ROSE.getId(), ModBlocks.POTTED_RED_ROSE);

            ModMessages.register();
            ModVillagers.registerPOIs();
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_DREAMY_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_DREAMY_WATER.get(), RenderType.translucent());
            EntityRenderers.register(ModEntityTypes.NIGHTMARE_BOSS.get(), NightmareBossRenderer::new);
            EntityRenderers.register(ModEntityTypes.NIGHTMARE_BLAZE.get(), NightmareBlazeRenderer::new);
            EntityRenderers.register(ModEntityTypes.FLYING_HORSE.get(), FlyingHorseRenderer::new);
            EntityRenderers.register(ModEntityTypes.STALKER.get(), StalkerRenderer::new);

            MenuScreens.register(ModMenuTypes.DREAM_FORGER_MENU.get(), DreamForgerScreen::new);

        }
    }

}
