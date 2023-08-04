package com.millenial.recipeapplication.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.millenial.recipeapplication.model.room.RecipeRepository
import com.millenial.recipeapplication.viewModel.RecipeDetailViewModel

class RepositoryViewModelFactory(
    private val recipeRepository: RecipeRepository
): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipeDetailViewModel(recipeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}