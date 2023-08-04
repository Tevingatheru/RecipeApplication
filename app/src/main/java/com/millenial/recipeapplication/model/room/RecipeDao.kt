package com.millenial.recipeapplication.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients

/**
 * Data Access Object (DAO) for recipes, ingredients, and instructions.
 * Defines methods to interact with the database tables related to recipes.
 */
@Dao
interface RecipeDao {
    /**
     * Insert a list of recipes along with their associated data.
     *
     * @param recipes List of recipes to insert.
     */
    @Insert
    @Transaction
    fun saveAll(recipes: List<Recipe>)


    /**
     * Insert a list of recipe ingredients.
     *
     * @param ingredients List of ingredients to insert.
     */
    @Insert
    @Transaction
    fun saveRecipeIngredients(ingredients: List<Ingredient>)

    /**
     * Insert a list of recipe instructions.
     *
     * @param instruction List of instructions to insert.
     */
    @Insert
    @Transaction
    fun saveRecipeInstructions(instruction: List<Instruction>)

    /**
     * Retrieve a recipe along with its associated instructions and ingredients by recipe code.
     *
     * @param recipeCode Code of the recipe to retrieve.
     * @return RecipeWithInstructionAndIngredients object containing recipe, instructions, and ingredients.
     */
    @Query("SELECT * FROM recipes WHERE code = :recipeCode")
    @Transaction
    fun getRecipeWithInstructionAndIngredientsByRecipeId(recipeCode: String)
            : RecipeWithInstructionAndIngredients?
}
