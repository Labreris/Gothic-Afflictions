package net.larchfen.gothicafflictions.datagen;

import net.larchfen.gothicafflictions.GothicAfflictions;
import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.item.ModItems;
import net.larchfen.gothicafflictions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    // LIST FOR STONECUTTER OUTPUTS
    private static final List<ItemLike> POLISHED_HEMATITE_STONECUTTING_OUTPUT = List.of(
            ModBlocks.POLISHED_HEMATITE_STAIRS.get().asItem(),
            ModBlocks.POLISHED_HEMATITE_SLAB.get().asItem(),
            ModBlocks.POLISHED_HEMATITE_WALL.get().asItem(),

            ModBlocks.CHISELED_POLISHED_HEMATITE.get().asItem(),
            ModBlocks.HEMATITE_BRICKS.get().asItem(),
            ModBlocks.HEMATITE_BRICK_STAIRS.get().asItem(),
            ModBlocks.HEMATITE_BRICK_SLAB.get().asItem(),
            ModBlocks.HEMATITE_BRICK_WALL.get().asItem(),

            ModBlocks.HEMATITE_PILLAR.get().asItem()
            );

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // ITEM RECIPES GO HERE

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TALCUM.get(), 4)
                .requires(ModBlocks.TALCUM_BLOCK)
                .unlockedBy("has_talcum_block", has(ModBlocks.TALCUM_BLOCK)).save(recipeOutput, "gothicafflictions:talcum_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SILVER.get(), 9)
                .requires(ModBlocks.RAW_SILVER_BLOCK)
                .unlockedBy("has_raw_silver_block", has(ModBlocks.RAW_SILVER_BLOCK)).save(recipeOutput, "gothicafflictions:raw_silver_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK)
                .unlockedBy("has_silver_block", has(ModBlocks.SILVER_BLOCK)).save(recipeOutput, "gothicafflictions:silver_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 9)
                .requires(ModItems.SILVER_INGOT)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 1)
                .requires(ModItems.SILVER_NUGGET, 9)
                .unlockedBy("has_silver_nugget", has(ModItems.SILVER_NUGGET)).save(recipeOutput, "gothicafflictions:silver_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEMATITE.get(), 1)
                .requires(ModItems.HEMATITE_NUGGET, 9)
                .unlockedBy("has_hematite_nugget", has(ModItems.HEMATITE_NUGGET)).save(recipeOutput, "gothicafflictions:hematite_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEMATITE_NUGGET.get(), 9)
                .requires(ModItems.HEMATITE)
                .unlockedBy("has_hematite", has(ModItems.HEMATITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SANGUINITE_INGOT.get(), 9)
                .requires(ModBlocks.SANGUINITE_BLOCK)
                .unlockedBy("has_sanguinite_block", has(ModBlocks.SANGUINITE_BLOCK)).save(recipeOutput, "gothicafflictions:sanguinite_ingot_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_SWORD.get())
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_AXE.get())
                .pattern("##")
                .pattern("#S")
                .pattern(" S")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput, "gothicafflictions:silver_axe_left");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_AXE.get())
                .pattern("##")
                .pattern("S#")
                .pattern("S ")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput, "gothicafflictions:silver_axe_right");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_SHOVEL.get())
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_HOE.get())
                .pattern("##")
                .pattern("S ")
                .pattern("S ")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput, "gothicafflictions:silver_hoe_right");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_HOE.get())
                .pattern("##")
                .pattern(" S")
                .pattern(" S")
                .define('#', ModItems.SILVER_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput, "gothicafflictions:silver_hoe_left");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_HAMMER.get())
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .define('#', ModBlocks.SILVER_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_silver_block", has(ModBlocks.SILVER_BLOCK)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SANGUINITE_SWORD.get())
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .define('#', ModItems.SANGUINITE_INGOT.get())
                .define('S', ModItems.SILVER_INGOT)
                .unlockedBy("has_sanguinite_ingot", has(ModItems.SANGUINITE_INGOT)).save(recipeOutput);

        // BLOCKS RECIPES GO HERE

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TALCUM_BLOCK.get())
                .pattern("TT")
                .pattern("TT")
                .define('T', ModItems.TALCUM.get())
                .unlockedBy("has_talcum", has(ModItems.TALCUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_POLISHED_HEMATITE.get())
                .pattern("H")
                .pattern("H")
                .define('H', ModBlocks.POLISHED_HEMATITE_SLAB.get())
                .unlockedBy("has_polished_hematite_slab", has(ModBlocks.POLISHED_HEMATITE_SLAB)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_POLISHED_HEMATITE.get())
                .pattern("H")
                .pattern("H")
                .define('H', ModBlocks.HEMATITE_BRICK_SLAB.get())
                .unlockedBy("has_hematite_brick_slab", has(ModBlocks.HEMATITE_BRICK_SLAB)).save(recipeOutput, "gothicafflictions:chiseled_polished_hematite_from_brick");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SILVER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_SILVER.get())
                .unlockedBy("has_raw_silver", has(ModItems.RAW_SILVER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_HEMATITE.get(), 4)
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

        // NON-BLOCK BLOCK RECIPES GO HERE

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_HEMATITE_WALL.get(), ModBlocks.POLISHED_HEMATITE.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEMATITE_BRICK_WALL.get(), ModBlocks.HEMATITE_BRICKS.get());

        stairBuilder(ModBlocks.POLISHED_HEMATITE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_HEMATITE)).group("polished_hematite")
                .unlockedBy("has_polished_hematite", has(ModBlocks.POLISHED_HEMATITE)).save(recipeOutput);
        stairBuilder(ModBlocks.HEMATITE_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.HEMATITE_BRICKS)).group("hematite_bricks")
                .unlockedBy("has_hematite_bricks", has(ModBlocks.HEMATITE_BRICKS)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_HEMATITE_SLAB.get(), ModBlocks.POLISHED_HEMATITE.get());
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEMATITE_BRICK_SLAB.get(), ModBlocks.HEMATITE_BRICKS.get());

        // STONECUTTING RECIPES

        stonecutTagToOutputListPlusSlabs(POLISHED_HEMATITE_STONECUTTING_OUTPUT, "stonecuttable_hematite", ModTags.Items.STONECUTTABLE_HEMATITE, recipeOutput);

        // SMELTING RECIPES GO HERE
        List<ItemLike> HEMATITE_SMELTABLES = List.of(ModBlocks.HEMATITE_ORE, ModBlocks.DEEPSLATE_HEMATITE_ORE);
        oreSmelting(recipeOutput, HEMATITE_SMELTABLES, RecipeCategory.MISC, ModItems.HEMATITE.get(), 0.25f, 200, "hematite");
        oreBlasting(recipeOutput, HEMATITE_SMELTABLES, RecipeCategory.MISC, ModItems.HEMATITE.get(), 0.25f, 100, "hematite");

        List<ItemLike> TALCUM_SMELTABLES = List.of(ModBlocks.TALCUM_ORE, ModBlocks.CALCITE_TALCUM_ORE);
        oreSmelting(recipeOutput, TALCUM_SMELTABLES, RecipeCategory.MISC, ModItems.TALCUM.get(), 0.25f, 200, "talcum");
        oreBlasting(recipeOutput, TALCUM_SMELTABLES, RecipeCategory.MISC, ModItems.TALCUM.get(), 0.25f, 100, "talcum");

        List<ItemLike> SILVER_SMELTABLES = List.of(ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER);
        oreSmelting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 200, "silver");
        oreBlasting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 100, "silver");
    }
        // SMELTING RECIPE MAKING LOGIC
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

    protected static void stonecutInputItemOutputList(List<ItemLike> stonecutOutputList, String inputTagName, Block inputItem, RecipeOutput recipeOutput) {
        Ingredient ingredient = Ingredient.of(inputItem);

        for (ItemLike itemLike : stonecutOutputList) {
            Item itemName = itemLike.asItem();
            String id = BuiltInRegistries.ITEM.getKey(itemName).getPath();

            stonecutToAmount(ingredient, RecipeCategory.MISC, itemLike, 1)
                    .unlockedBy(getHasName(ModItems.CHISEL.get()), has(ModItems.CHISEL.get()))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, inputTagName + "_stonecut_to_" + id));
        }
    }

    protected static void stonecutTagToOutputListPlusSlabs(List<ItemLike> stonecutOutputList, String inputTagName, TagKey<Item> inputTag, RecipeOutput recipeOutput) {
        Ingredient ingredient = Ingredient.of(inputTag);

        for (ItemLike itemInIndice : stonecutOutputList) {

            Item itemName = itemInIndice.asItem();
            String id = BuiltInRegistries.ITEM.getKey(itemName).getPath();

            //If the ItemLike output is a slab,
            //Create stonecutter recipe producing twice the amount of output
            //Else, function normally

            if ((itemInIndice instanceof BlockItem blockItem) && (blockItem.getBlock() instanceof SlabBlock)) { //Whether it is a slab block, or inherits from the SlabBlock class (currently, no block classes inherit from SlabBlocks)
                stonecutToAmount(ingredient, RecipeCategory.MISC, itemInIndice, 2) //Any block from the inputTag can produce two slabs from the stonecutOutputList
                        .unlockedBy(getHasName(ModItems.CHISEL.get()), has(ModItems.CHISEL.get()))
                        .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, inputTagName + "_stonecut_to_" + id));
            } else {
                stonecutToAmount(ingredient, RecipeCategory.MISC, itemInIndice, 1)
                        .unlockedBy(getHasName(ModItems.CHISEL.get()), has(ModItems.CHISEL.get()))
                        .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(GothicAfflictions.MOD_ID, inputTagName + "_stonecut_to_" + id));
            }
        }
    }
        // STONECUTTER RECIPE MAKING METHOD
        public static SingleItemRecipeBuilder stonecutToAmount(Ingredient ingredient, RecipeCategory category, ItemLike result, int resultCount) {
        return new SingleItemRecipeBuilder(category, StonecutterRecipe::new, ingredient, result, resultCount);
        }
}

