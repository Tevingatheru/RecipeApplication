package com.millenial.recipeapplication.viewModel

import androidx.lifecycle.ViewModel
import com.millenial.recipeapplication.model.CategoryTypes
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients
import com.millenial.recipeapplication.model.recipeListForBreakfast
import com.millenial.recipeapplication.model.recipeListForLunch
import com.millenial.recipeapplication.model.recipeListForSupper

class RecipeViewModel() : ViewModel() {

    fun getRecipes(categoryName: String): List<RecipeWithInstructionAndIngredients> {
        var recipes: List<RecipeWithInstructionAndIngredients> = ArrayList()

        when (categoryName) {
            CategoryTypes.BREAKFAST.type -> {
                recipes = recipeListForBreakfast()
            }

            CategoryTypes.LUNCH.type -> {
                recipes = recipeListForLunch()
            }

            CategoryTypes.SUPPER.type -> {
                recipes = recipeListForSupper()
            }
        }
        return recipes
    }
}
