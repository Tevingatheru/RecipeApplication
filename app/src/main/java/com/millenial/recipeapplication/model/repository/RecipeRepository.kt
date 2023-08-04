package com.millenial.recipeapplication.model.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients
import com.millenial.recipeapplication.model.recipeListForBreakfast
import com.millenial.recipeapplication.model.recipeListForLunch
import com.millenial.recipeapplication.model.recipeListForSupper
import com.millenial.recipeapplication.model.room.RecipeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository class responsible for managing data operations related to recipes and their associated data.
 *
 * @param recipeDao The Data Access Object (DAO) for recipes, ingredients, and instructions.
 */
class RecipeRepository(
    private val recipeDao: RecipeDao
) {
    companion object {
        private const val TAG = "RecipeRepository"
    }

    /**
     * Insert a list of recipes along with their associated data into the database.
     */
    @WorkerThread
    suspend fun insertAll() {
        val recipeList = ArrayList<RecipeWithInstructionAndIngredients>()
        recipeList.addAll(recipeListForBreakfast())
        recipeList.addAll(recipeListForLunch())
        recipeList.addAll(recipeListForSupper())
        Log.d(TAG, "recipes: ${recipeList.joinToString(separator = ", ") { it.recipe!!.name }}")
        val recipes: List<Recipe> = recipeList.map { it.recipe!! }.toList()
        withContext(Dispatchers.IO) {
            insertRecipes(recipes)
            insertIngredients(recipeList)
            insertInstruction(recipeList)
        }
    }

    /**
     * Retrieve a recipe along with its associated instructions and ingredients by recipe code.
     *
     * @param recipeCode Code of the recipe to retrieve.
     * @return RecipeWithInstructionAndIngredients object containing recipe, instructions, and ingredients.
     */
    @WorkerThread
    suspend fun getRecipeWithInstructionAndIngredientsByCode(recipeCode: String): RecipeWithInstructionAndIngredients? {
        return withContext(Dispatchers.IO){
            recipeDao.getRecipeWithInstructionAndIngredientsByRecipeId(recipeCode)
        }
    }

    private suspend fun insertInstruction(recipeList: ArrayList<RecipeWithInstructionAndIngredients>) {
        var instructions: List<Instruction> = ArrayList()
        recipeList.map { it -> it.instructions }.forEach { instruction ->
            instructions = instructions.plus(instruction!!)
        }

        recipeDao.saveRecipeInstructions(instruction = instructions)
    }

    private suspend fun insertIngredients(recipeList: ArrayList<RecipeWithInstructionAndIngredients>) {
        val ingredients: List<Ingredient> = recipeList.flatMap { it.ingredients ?: emptyList() }

        recipeDao.saveRecipeIngredients(ingredients = ingredients)
    }

    private suspend fun insertRecipes(recipes: List<Recipe>) {
        recipeDao.saveAll(recipes = recipes)
        Log.d(TAG, "Recipes Inserted")
    }
}
