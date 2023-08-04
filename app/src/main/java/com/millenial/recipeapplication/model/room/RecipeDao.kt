package com.millenial.recipeapplication.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients

@Dao
interface RecipeDao {
    @Insert
    @Transaction
    fun saveAll(recipes: List<Recipe>)

    @Insert
    @Transaction
    fun saveRecipeIngredients(ingredients: List<Ingredient>)

    @Insert
    @Transaction
    fun saveRecipeInstructions(instruction: List<Instruction>)

    @Query("SELECT * FROM recipes WHERE code = :recipeCode")
    @Transaction
    fun getRecipeWithInstructionAndIngredientsByRecipeId(recipeCode: String)
    : RecipeWithInstructionAndIngredients?
}
