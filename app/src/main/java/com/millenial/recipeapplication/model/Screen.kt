package com.millenial.recipeapplication.model

sealed class Screen(val route: String) {
    object Main: Screen("main")
    object Category: Screen("category")
    object Recipe: Screen("recipe")
    object Detail: Screen("detail")
}
