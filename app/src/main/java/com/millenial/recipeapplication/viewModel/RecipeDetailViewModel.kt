package com.millenial.recipeapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients

class RecipeDetailViewModel : ViewModel() {
    private val _recipe = MutableLiveData<RecipeWithInstructionAndIngredients>()
    val recipe: LiveData<RecipeWithInstructionAndIngredients> get() = _recipe

    fun setRecipe(recipe: RecipeWithInstructionAndIngredients?) {
        _recipe.value = recipe!!
    }
}
