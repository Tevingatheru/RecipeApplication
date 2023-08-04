package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ingredients",
    foreignKeys = [ForeignKey(entity = Recipe::class,
        parentColumns = arrayOf("recipeId"),
        childColumns = arrayOf("recipeId"),
        onDelete = CASCADE
    )])
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    var ingredientId: Long? = null,
    var amount: Double? = null,
    var description: String? = null,
    var required: Boolean? = null,
    var recipeId: Long? = null
): Parcelable {

    constructor(amount: Double, description: String) :
            this(amount = amount, description = description, required = true)
    constructor(description: String, required: Boolean) : this(
        amount = null, description = description, required = required
    )
}
