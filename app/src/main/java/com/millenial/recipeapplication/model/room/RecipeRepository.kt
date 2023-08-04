package com.millenial.recipeapplication.model.room

import android.util.Log
import androidx.annotation.WorkerThread
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients
import com.millenial.recipeapplication.model.recipeListForBreakfast
import com.millenial.recipeapplication.model.recipeListForLunch
import com.millenial.recipeapplication.model.recipeListForSupper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository(
    private val recipeDao: RecipeDao
) {
    companion object {
        private const val TAG = "RecipeRepository"
    }

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

    private suspend fun insertInstruction(recipeList: ArrayList<RecipeWithInstructionAndIngredients>) {
        val instructions: List<Instruction> = ArrayList()
        recipeList.mapIndexed { index, it -> it.instructions }.forEach { instruction ->
            instructions.plus(instruction)
        }

        recipeDao.saveRecipeInstructions(instruction = instructions)
    }

    private suspend fun insertIngredients(recipeList: ArrayList<RecipeWithInstructionAndIngredients>) {
        val ingredients: List<Ingredient> = ArrayList()
        recipeList.mapIndexed { index, it -> it.ingredients }.forEach { ingredient ->
            ingredients.plus(ingredient)
        }

        recipeDao.saveRecipeIngredients(ingredients = ingredients)
    }

    private suspend fun insertRecipes(recipes: List<Recipe>) {
        recipeDao.saveAll(recipes = recipes)
        Log.d(TAG, "Recipes Inserted")
    }

    @WorkerThread
    suspend fun getRecipeWithInstructionAndIngredientsById(recipeCode: String): RecipeWithInstructionAndIngredients? {
        return withContext(Dispatchers.IO){
            recipeDao.getRecipeWithInstructionAndIngredientsByRecipeId(recipeCode)
        }
    }
}
