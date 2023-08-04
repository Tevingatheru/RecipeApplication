package com.millenial.recipeapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.model.categoryList
import com.millenial.recipeapplication.model.room.CategoryRepository
import kotlinx.coroutines.runBlocking

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
): ViewModel() {
    // List of categories (recipes)
//    val categories: List<Category> = ArrayList()

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

    fun getCategories(): List<Category> {
        return runBlocking {
            val cList = categoryRepository.getAll()
            cList.forEach{category ->
                Log.d("CategoryViewModel", category.name.type)
            }
            cList
        }
    }
}