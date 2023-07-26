package com.millenial.recipeapplication.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.model.categoryList

class CategoryViewModel(): ViewModel() {
    // List of categories (recipes)
    val categories: List<Category> = categoryList()

    // LiveData to hold the clicked category
    private val _clickedCategory = MutableLiveData<Category>()
    val clickedCategory: LiveData<Category>
        get() = _clickedCategory

    // Function to handle category card click event
    fun onCategoryCardClick(category: Category) {
        _clickedCategory.value = category
    }

    // Function to reset the clicked category after handling the click event
    fun onCategoryCardClickCompleted() {
        _clickedCategory.value = null
    }
}