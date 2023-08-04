package com.millenial.recipeapplication.model

import com.millenial.recipeapplication.R

fun categoryList(): List<Category> {
    val breakfast = R.drawable.breakfast
    val lunch = R.drawable.lunch
    val supper = R.drawable.supper
    return listOf(
        Category(name = CategoryTypes.BREAKFAST, image = breakfast),
        Category(name = CategoryTypes.LUNCH, image = lunch),
        Category(name = CategoryTypes.SUPPER, image = supper)
    )
}