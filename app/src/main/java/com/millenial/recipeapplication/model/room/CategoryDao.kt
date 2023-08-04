package com.millenial.recipeapplication.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.millenial.recipeapplication.model.Category

/**
 * Data Access Object (DAO) for Category data.
 *
 * This interface defines methods for performing CRUD operations on Category data in the database.
 */
@Dao
interface CategoryDao {
    /**
     * Saves a list of categories to the database.
     *
     * @param categories The list of categories to save.
     */
    @Insert
    fun saveAll(categories: List<Category>)

    /**
     * Retrieves all categories from the database.
     *
     * @return A list of categories.
     */
    @Query("SELECT * FROM categories")
    fun getAll(): List<Category>

    /**
     * Checks if the database is empty.
     *
     * @return `true` if the database is empty, `false` otherwise.
     */
    @Query("SELECT COUNT(*) FROM categories")
    fun isEmpty(): Boolean
}