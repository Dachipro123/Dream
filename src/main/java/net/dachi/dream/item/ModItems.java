package net.dachi.dream.item;

import net.dachi.dream.Dream;
import net.dachi.dream.creativetab.ModCreativeModeTab;
import net.dachi.dream.entity.ModEntityTypes;
import net.dachi.dream.fluid.ModFluids;
import net.dachi.dream.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, Dream.MOD_ID);

    //private static CreativeModeTab ModCreativeModeTab = net.dachi.dream.creativetab.ModCreativeModeTab.DREAM_TAB;
    public static final RegistryObject<Item> DREAM_INGOT = ITEMS.register("dream_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> NIGHTMARE_PIECE = ITEMS.register("nightmare_piece",
            () -> new NightmarePieceItem(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_PIECE = ITEMS.register("dream_piece",
            () -> new DreamPieceItem(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_CHUNK = ITEMS.register("dream_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> NIGHTMARE_CHUNK = ITEMS.register("nightmare_chunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_LIGHTER = ITEMS.register("dream_lighter", DreamLighter::new);
    public static final RegistryObject<Item> NIGHTMARE_LIGHTER = ITEMS.register("nightmare_lighter", NightmareLighter::new);
    public static final RegistryObject<Item> NIGHTMARE_BLAZE_SPAWN_EGG = ITEMS.register("nightmare_blaze_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NIGHTMARE_BLAZE, 000000, 808080,
                    new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_SWORD = ITEMS.register("dream_sword",
            () -> new SwordItem(ModTiers.DREAM, 100, 100f,
                    new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_PICKAXE = ITEMS.register("dream_pickaxe",
            () -> new PickaxeItem(ModTiers.DREAM, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_SHOVEL = ITEMS.register("dream_shovel",
            () -> new ShovelItem(ModTiers.DREAM, 0, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_AXE = ITEMS.register("dream_axe",
            () -> new AxeItem(ModTiers.DREAM, 4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_HOE = ITEMS.register("dream_hoe",
            () -> new HoeItem(ModTiers.DREAM, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> LIGHTNING_SUCKER = ITEMS.register("lightning_sucker",
            () -> new LightningSucker(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_FLIGHT = ITEMS.register("dream_flight",
            () -> new DreamFlight(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));
    public static final RegistryObject<Item> DREAM_POWER = ITEMS.register("dream_power",
            () -> new DreamPower(new Item.Properties().tab(ModCreativeModeTab.DREAM_TAB)));

    public static final RegistryObject<Item> DREAMY_WATER_BUCKET = ITEMS.register("dreamy_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_DREAMY_WATER,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ModCreativeModeTab.DREAM_TAB)));




    //ModItemGroup.DREAM_MOD_TAB


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
