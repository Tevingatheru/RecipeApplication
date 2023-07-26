package com.millenial.recipeapplication.model


import com.millenial.recipeapplication.R

fun categoryList(): List<Category> {
    val breakfast = R.drawable.breakfast
    val lunch = R.drawable.lunch
    val supper = R.drawable.supper
    return listOf(
        Category(CategoryTypes.BREAKFAST, breakfast),
        Category(CategoryTypes.LUNCH, lunch),
        Category(CategoryTypes.SUPPER, supper)
    )
}