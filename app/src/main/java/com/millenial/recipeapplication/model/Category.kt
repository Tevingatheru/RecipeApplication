package com.millenial.recipeapplication.model


class Category(val name: CategoryTypes, val image: Int?) {

}

enum class CategoryTypes(val type: String) {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    SUPPER("Dinner")
}