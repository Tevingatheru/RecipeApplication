package com.millenial.recipeapplication.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.millenial.recipeapplication.model.repository.RecipeRepository
import com.millenial.recipeapplication.viewModel.RecipeDetailViewModel

/**
 * ViewModelFactory class responsible for creating instances of the RecipeDetailViewModel.
 *
 * @param recipeRepository The repository providing data access and operations for recipes and associated data.
 */
class RepositoryViewModelFactory(
    private val recipeRepository: RecipeRepository
): ViewModelProvider.Factory
{
    /**
     * Create an instance of the specified ViewModel class.
     *
     * @param modelClass The class of the ViewModel to create.
     * @return An instance of the specified ViewModel class.
     * @throws IllegalArgumentException if the provided ViewModel class is unknown.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipeDetailViewModel(recipeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}