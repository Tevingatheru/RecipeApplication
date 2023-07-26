package com.millenial.recipeapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Recipe(
    val name: String,
    val code: String,
    val image: Int,
    val instructions: List<Instruction>,
    val ingredients: List<Ingredient>,
    val categoryType: CategoryTypes
    ): Parcelable{


}


