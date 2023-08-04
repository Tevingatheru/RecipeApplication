package com.millenial.recipeapplication.model

import androidx.room.Embedded
import androidx.room.Relation

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
    var ingredients: List<Ingredient>?

)