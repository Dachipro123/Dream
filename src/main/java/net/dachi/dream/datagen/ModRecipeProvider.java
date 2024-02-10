package net.dachi.dream.datagen;

import net.dachi.dream.block.ModBlocks;
import net.dachi.dream.item.ModItems;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.DREAM_INGOT.get())
                .requires(ModBlocks.DREAM_BLOCK.get())
                .unlockedBy("has_dream_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.DREAM_BLOCK.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.DREAM_BLOCK.get())
                .define('C', ModItems.DREAM_INGOT.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .unlockedBy("has_dream", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.DREAM_INGOT.get()).build()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.NIGHTMARE_LIGHTER.get())
                .define('X', ModItems.DREAM_LIGHTER.get())
                .define('C', ModBlocks.NIGHTMARE_BLOCK.get())
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .unlockedBy("has_night", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.DREAM_LIGHTER.get()).build()))
                .save(pFinishedRecipeConsumer);

    }
}
