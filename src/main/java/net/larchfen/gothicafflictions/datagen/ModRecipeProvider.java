package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // BLOCKS RECIPES GO HERE

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TALCUM_BLOCK.get())
                .pattern("TT")
                .pattern("TT")
                .define('T', ModItems.TALCUM.get())
                .unlockedBy("has_talcum", has(ModItems.TALCUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HEMATITE_BLOCK.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.HEMATITE.get())
                .unlockedBy("has_hematite", has(ModItems.HEMATITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_HEMATITE.get())
                .pattern("HH")
                .pattern("HH")
                .define('H', ModItems.HEMATITE.get())
                .unlockedBy("has_hematite", has(ModItems.HEMATITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HEMATITE_BRICKS.get(), 4)
                .pattern("PP")
                .pattern("PP")
                .define('P', ModBlocks.POLISHED_HEMATITE.get())
                .unlockedBy("has_polished_hematite", has(ModBlocks.POLISHED_HEMATITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HEMATITE_PILLAR.get(), 2)
                .pattern("P")
                .pattern("P")
                .define('P', ModBlocks.POLISHED_HEMATITE.get())
                .unlockedBy("has_polished_hematite", has(ModBlocks.POLISHED_HEMATITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SANGUINITE_BLOCK.get())
                .requires(ModItems.SANGUINITE_INGOT, 9)
                .unlockedBy("has_sanguinite_ingot", has(ModItems.SANGUINITE_INGOT)).save(recipeOutput);

        // ITEM RECIPES GO HERE

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TALCUM.get(), 4)
                .requires(ModBlocks.TALCUM_BLOCK)
                .unlockedBy("has_talcum_block", has(ModBlocks.TALCUM_BLOCK)).save(recipeOutput, "gothicafflictions:talcum_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEMATITE.get(), 9)
                .requires(ModBlocks.HEMATITE_BLOCK)
                .unlockedBy("has_hematite_block", has(ModBlocks.HEMATITE_BLOCK)).save(recipeOutput, "gothicafflictions:hematite_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEMATITE.get(), 1)
                .requires(ModItems.HEMATITE_NUGGET, 9)
                .unlockedBy("has_hematite_nugget", has(ModItems.HEMATITE_NUGGET)).save(recipeOutput, "gothicafflictions:hematite_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEMATITE_NUGGET.get(), 9)
                .requires(ModItems.HEMATITE)
                .unlockedBy("has_hematite", has(ModItems.HEMATITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SANGUINITE_INGOT.get(), 9)
                .requires(ModBlocks.SANGUINITE_BLOCK)
                .unlockedBy("has_sanguinite_block", has(ModBlocks.SANGUINITE_BLOCK)).save(recipeOutput, "gothicafflictions:sanguinite_ingot_from_block");

        // SMELTING RECIPES GO HERE

        List<ItemLike> HEMATITE_SMELTABLES = List.of(ModBlocks.HEMATITE_ORE, ModBlocks.DEEPSLATE_HEMATITE_ORE);
        oreSmelting(recipeOutput, HEMATITE_SMELTABLES, RecipeCategory.MISC, ModItems.HEMATITE.get(), 0.25f, 200, "hematite");
        oreBlasting(recipeOutput, HEMATITE_SMELTABLES, RecipeCategory.MISC, ModItems.HEMATITE.get(), 0.25f, 100, "hematite");
    }
        protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTime, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                           List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for(ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                        .save(recipeOutput, GothicAfflictions.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
            }
    }
}
