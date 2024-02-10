package net.dachi.dream.datagen.loot;


import net.dachi.dream.block.ModBlocks;
import net.dachi.dream.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockLootTables extends BlockLoot {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[] { 0.05F, 0.0625F, 0.083333336F, 0.1F };

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.DREAM_BLOCK.get());
        this.dropSelf(ModBlocks.NIGHTMARE_BLOCK.get());
        //this.dropSelf(ModBlocks.RAW_DREAM_BLOCK.get());

        this.add(ModBlocks.DREAM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DREAM_ORE.get(), ModItems.DREAM_INGOT.get()));
        this.add(ModBlocks.DEEPSLATE_DREAM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_DREAM_ORE.get(), ModItems.DREAM_INGOT.get()));
        this.add(ModBlocks.NETHERRACK_DREAM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_DREAM_ORE.get(), ModItems.DREAM_INGOT.get()));
        this.add(ModBlocks.ENDSTONE_DREAM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_DREAM_ORE.get(), ModItems.DREAM_INGOT.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
