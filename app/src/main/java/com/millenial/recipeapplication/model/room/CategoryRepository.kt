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

/**
 * Repository for managing Category data.
 *
 * This class provides methods for inserting, retrieving, and checking the existence of Category items
 * in the underlying database using the provided [CategoryDao].
 *
 * @param categoryDao The DAO interface for Category operations.
 */
class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    companion object {
        private const val TAG = "CategoryRepository"
    }

    /**
     * Inserts a list of categories into the database.
     *
     * This method inserts the provided categories into the database using a background thread.
     * It checks if the database is already populated before inserting.
     */
    @WorkerThread
    suspend fun insertAll() {
        if (!this.isEmpty()) {
            withContext(Dispatchers.IO) {
                categoryDao.saveAll(categoryList())
                Log.d(TAG, "Insertion completed")
            }
        }
    }

    /**
     * Retrieves all categories from the database.
     *
     * This method fetches all categories from the database using a background thread.
     *
     * @return A list of categories.
     */
    @WorkerThread
    suspend fun getAll(): List<Category> {
        Log.d(TAG, "Getting categories")

        return withContext(Dispatchers.IO){
            categoryDao.getAll()
        }
    }

    /**
     * Checks if the database is empty.
     *
     * This method checks if the database has any categories using a background thread.
     *
     * @return `true` if the database is empty, `false` otherwise.
     */
    @WorkerThread
    suspend fun isEmpty(): Boolean {
        return withContext(Dispatchers.IO) {
            val exists = categoryDao.isEmpty()
            Log.d(TAG, "Check if categories exist: $exists")
            exists
        }
    }
}
