package com.millenial.recipeapplication.model.room

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.model.categoryList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    val allCategories: LiveData<List<Category>> = categoryDao.getAll()

    companion object {
        private const val TAG = "CategoryRepository"
    }

    @WorkerThread
    suspend fun insertAll() {
        withContext(Dispatchers.IO) {
            categoryDao.saveAll(categoryList())
            Log.d(TAG, "Insertion completed")
        }
    }

    @WorkerThread
    suspend fun getAll(): LiveData<List<Category>> {
        Log.d(TAG, "Getting categories")
        return categoryDao.getAll()
    }

    @WorkerThread
    suspend fun isEmpty(): Boolean {
        return withContext(Dispatchers.IO) {
            val exists = categoryDao.isEmpty()
            Log.d(TAG, "Check if categories exist: $exists")
            exists
        }
    }
}
