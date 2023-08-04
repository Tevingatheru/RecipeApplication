package com.millenial.recipeapplication.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe

@Database(
    entities = [Category::class],
    version = 1,
    exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getDatabase(context : Context): RecipeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java ,
                    "recipe_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
