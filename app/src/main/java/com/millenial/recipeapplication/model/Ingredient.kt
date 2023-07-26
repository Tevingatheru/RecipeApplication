package com.millenial.recipeapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Ingredient(
    val amount: Double?,
    val description: String,
    var required: Boolean
    ): Parcelable {
    constructor(amount: Double, description: String) :
            this(amount, description, true)
    constructor(description: String, required: Boolean) : this(
        null, description, required
    )
}
