package com.millenial.recipeapplication.model.room

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.model.categoryList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
//    val allCategories: List<Category> = runBlocking { categoryDao.getAll() }

    companion object {
        private const val TAG = "CategoryRepository"
    }

    @WorkerThread
    suspend fun insertAll() {
        if (!this.isEmpty()) {
            withContext(Dispatchers.IO) {
                categoryDao.saveAll(categoryList())
                Log.d(TAG, "Insertion completed")
            }
        }
    }

    @WorkerThread
    suspend fun getAll(): List<Category> {
        Log.d(TAG, "Getting categories")

        return withContext(Dispatchers.IO){
            categoryDao.getAll()
        }
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
