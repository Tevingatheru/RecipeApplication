package com.millenial.recipeapplication.model

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeWithInstructionAndIngredients(
    @Embedded
    var recipe: Recipe?,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "instructionId"
    )
    var instructions: List<Instruction>?,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "ingredientId"
    )
    var ingredients: List<Ingredient>?

)