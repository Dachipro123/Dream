package net.dachi.dream.block;

import net.dachi.dream.Dream;
import net.dachi.dream.block.custom.*;
import net.dachi.dream.creativetab.ModCreativeModeTab;
import net.dachi.dream.fluid.ModFluids;
import net.dachi.dream.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.FlowerBlock.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Dream.MOD_ID);

    public static final RegistryObject<Block> DREAM_BLOCK = registerBlock("dream_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> DREAM_ORE = registerBlock("dream_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops()
                    .strength(1.5F),
                    UniformInt.of(3,7)),ModCreativeModeTab.DREAM_TAB);
    public static final RegistryObject<Block> DEEPSLATE_DREAM_ORE = registerBlock("deepslate_dream_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> ENDSTONE_DREAM_ORE = registerBlock("endstone_dream_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> NETHERRACK_DREAM_ORE = registerBlock("netherrack_dream_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops(),
                    UniformInt.of(7, 10)), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> RED_ROSE = registerBlock("red_rose",
            () -> new FlowerBlock(MobEffects.GLOWING, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> POTTED_RED_ROSE = BLOCKS.register("potted_red_rose",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.RED_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> NIGHTMARE_BLOCK = registerBlock("nightmare_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> DREAM_COMPLECT = registerBlock("dream_complect",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);
    public static final RegistryObject<Block> DREAM_RAINBOW = registerBlock("dream_rainbow",
            () -> new DreamRainbow(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> DREAM_POT = registerBlock("dream_pot",
            () -> new DreamPot(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> NIGHTMARE_COMPLECT = registerBlock("nightmare_complect",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> NIGHTMARE_BOSS_SPAWN_BLOCK = registerBlock("nightmare_boss_spawn_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<Block> DREAM_FORGER = registerBlock("dream_forger",
            () -> new DreamForger(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);

    public static final RegistryObject<LiquidBlock> DREAMY_WATER_BLOCK = BLOCKS.register("dreamy_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_DREAMY_WATER,BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Block> DREAM_PORTAL = registerBlockWithoutBlockItem("dream_portal",
            DreamPortalBlock::new);
    public static final RegistryObject<Block> NIGHTMARE_PORTAL = registerBlockWithoutBlockItem("nightmare_portal",
            NightmarePortalBlock::new);
    public static final RegistryObject<Block> DREAM_STONE = registerBlock("dream_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);
    public static final RegistryObject<Block> DREAM_MUSHROOM = registerBlock("dream_mushroom",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);
    public static final RegistryObject<Block> DREAM_LOG = registerBlock("dream_log",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);
    public static final RegistryObject<Block> NIGHTMARE_LOG = registerBlock("nightmare_log",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.5F).requiresCorrectToolForDrops()), ModCreativeModeTab.DREAM_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
