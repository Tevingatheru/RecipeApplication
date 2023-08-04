package com.millenial.recipeapplication.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe

/**
 * Room database for managing recipe-related data.
 *
 * This class defines the database using Room annotations.
 * interface for performing operations related to Category data.
 */
@Database(
    entities = [Category::class, Recipe::class, Ingredient::class, Instruction::class],
    version = 1,
    exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    /**
     * Provides access to the Category data operations.
     *
     * @return An instance of [CategoryDao].
     */
    abstract fun categoryDao(): CategoryDao

    /**
     * Provides access to the Recipe data operations.
     *
     * @return An instance of [RecipeDao].
     */
    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        /**
         * Retrieves an instance of [RecipeDatabase].
         *
         * This method returns a singleton instance of [RecipeDatabase], creating it if necessary.
         *
         * @param context The application context.
         * @return An instance of [RecipeDatabase].
         */
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
