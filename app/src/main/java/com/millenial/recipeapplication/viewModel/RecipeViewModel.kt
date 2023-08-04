package com.millenial.recipeapplication.viewModel

import androidx.lifecycle.ViewModel
import com.millenial.recipeapplication.model.CategoryTypes
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients
import com.millenial.recipeapplication.model.recipeListForBreakfast
import com.millenial.recipeapplication.model.recipeListForLunch
import com.millenial.recipeapplication.model.recipeListForSupper

class RecipeViewModel() : ViewModel() {

    fun getRecipes(categoryName: String): List<Recipe> {
        var recipes: List<Recipe> = ArrayList()

        when (categoryName) {
            CategoryTypes.BREAKFAST.type -> {
                recipes = recipeListForBreakfast().map { it.recipe!! }
            }

            CategoryTypes.LUNCH.type -> {
                recipes = recipeListForLunch().map { it.recipe!! }
            }

            CategoryTypes.SUPPER.type -> {
                recipes = recipeListForSupper().map { it.recipe!! }
            }
        }
        return recipes
    }
}
