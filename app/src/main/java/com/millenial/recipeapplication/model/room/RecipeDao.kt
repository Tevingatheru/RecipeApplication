package com.millenial.recipeapplication.model.room

import androidx.room.Dao
import androidx.room.Insert
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe

@Dao
interface RecipeDao {
    @Insert
    fun saveAll(recipes: List<Recipe>)
    @Insert
    fun saveRecipeIngredients(ingredients: List<Ingredient>)
    @Insert
    fun saveRecipeInstructions(instruction: List<Instruction>)
}
