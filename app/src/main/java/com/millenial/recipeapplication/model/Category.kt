package com.millenial.recipeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: CategoryTypes,
    val image: Int?) {

}
