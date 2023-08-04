package com.millenial.recipeapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ingredients")
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = 0,
    var amount: Double? = null,
    var description: String? = null,
    var required: Boolean? = null
    ): Parcelable {

    constructor(amount: Double, description: String) :
            this(amount = amount, description = description, required = true)
    constructor(description: String, required: Boolean) : this(
        amount = null, description = description, required = required
    )
}
