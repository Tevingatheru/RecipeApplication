package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String,
    var code: String,
    var image: Int,
    var categoryType: CategoryTypes
): Parcelable{

}

data class RecipeWithInstructionAndIngredients(
    @Embedded
    var recipe: Recipe?,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    var instructions: List<Instruction>?,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    var ingredients: List<Ingredient>?,

    )