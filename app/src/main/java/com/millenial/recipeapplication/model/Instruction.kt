package com.millenial.recipeapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Instruction(
    val step: Int,
    val instruction: String
) : Parcelable {
}
