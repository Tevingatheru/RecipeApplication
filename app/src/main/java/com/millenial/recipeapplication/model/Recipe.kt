package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipes")
class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val code: String,
    val image: Int,
    val instructions: List<Instruction>,
    val ingredients: List<Ingredient>,
    val categoryType: CategoryTypes
    ): Parcelable{

}
