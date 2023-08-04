package com.millenial.recipeapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients
import com.millenial.recipeapplication.model.room.RecipeRepository
import kotlinx.coroutines.runBlocking

class RecipeDetailViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _recipe = MutableLiveData<RecipeWithInstructionAndIngredients>()
    val recipe: LiveData<RecipeWithInstructionAndIngredients> get() = _recipe

    fun setRecipe(recipeWithInstructionAndIngredients: RecipeWithInstructionAndIngredients?) {
        _recipe.value = recipeWithInstructionAndIngredients!!
    }
    fun getRecipeWithInstructionAndIngredientsById(recipeCode: String): RecipeWithInstructionAndIngredients? {
        return runBlocking { recipeRepository.getRecipeWithInstructionAndIngredientsById(recipeCode) }
    }
}
