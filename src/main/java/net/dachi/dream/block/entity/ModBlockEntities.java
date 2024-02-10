package net.dachi.dream.block.entity;

import net.dachi.dream.Dream;
import net.dachi.dream.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Dream.MOD_ID);

    public static final RegistryObject<BlockEntityType<DreamForgerBlockEntity>> DREAM_FORGER =
            BLOCK_ENTITIES.register("dream_forger", () ->
                    BlockEntityType.Builder.of(DreamForgerBlockEntity::new,
                            ModBlocks.DREAM_FORGER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
