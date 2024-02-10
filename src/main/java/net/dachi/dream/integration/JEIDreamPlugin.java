package net.dachi.dream.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.dachi.dream.Dream;
import net.dachi.dream.recipe.DreamForgerRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDreamPlugin implements IModPlugin {
    public static RecipeType<DreamForgerRecipe> FORGER_TYPE =
            new RecipeType<>(DreamForgerRecipeCategory.UID, DreamForgerRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Dream.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                DreamForgerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<DreamForgerRecipe> recipesInfusing = rm.getAllRecipesFor(DreamForgerRecipe.Type.INSTANCE);
        registration.addRecipes(FORGER_TYPE, recipesInfusing);
    }
}
