package com.millenial.recipeapplication.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.millenial.recipeapplication.model.Category

@Dao
interface CategoryDao {
    @Insert
    fun saveAll(categories: List<Category>)

    @Query("SELECT * FROM categories")
    fun getAll(): LiveData<List<Category>>

    @Query("SELECT COUNT(*) FROM categories")
    fun isEmpty(): Boolean
}