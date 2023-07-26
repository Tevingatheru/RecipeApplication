package com.millenial.recipeapplication.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.millenial.recipeapplication.R
import com.millenial.recipeapplication.model.CategoryTypes
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.ui.theme.Purple40
import com.millenial.recipeapplication.ui.theme.RecipeApplicationTheme
import com.millenial.recipeapplication.view.RecipeDetailActivity.Companion.TAG

class RecipeDetailActivity : ComponentActivity() {
    companion object {
        const val TAG: String = "RecipeDetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recipe: Recipe? = intent.getParcelableExtra<Recipe>("RECIPE", Recipe::class.java)
        Log.i(TAG, "Recipe code: ${recipe!!.code}")
        setContent {
            RecipeApplicationTheme {
                RecipeDetailScreen(recipe = recipe)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(recipe: Recipe?) {

    Scaffold(
        topBar = {

            TopAppBar(
                title = { Text(text = recipe?.name ?: "Recipe Detail") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click here */ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        RecipeContent(recipe = recipe)
    }
}

@Composable
fun RecipeContent(recipe: Recipe?) {
    if (recipe != null) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item{
                RecipeImage(recipe.image)
            }
            item {
                IngredientTitle()
            }
            items(recipe.ingredients) { ingredient ->
                RecipeIngredientItem(ingredient)
            }
            item {
                InstructionTitle()
            }
            items(recipe.instructions) { instruction ->
                RecipeInstructionItem(instruction)
            }
        }
    }
}

@Composable
fun RecipeImage(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Recipe image",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun InstructionTitle() {
    Text(
        text = "Instruction",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(16.dp),
        color = Purple40
    )
}

@Composable
private fun IngredientTitle() {
    Text(
        text = "Ingredients",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(16.dp),
        color = Purple40
    )
}

@Composable
fun RecipeIngredientItem(ingredient: Ingredient) {
    Text(
        text = "${ingredient.amount ?: ""}: ${requiredString(ingredient.required)} ${ingredient.description}" ,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(5.dp)
    )
}

private fun requiredString(required: Boolean): String {
    return if(required) {
        ""
    } else
    {
        "(Optional)"
    }
}

@Composable
fun RecipeInstructionItem(instruction: Instruction) {
    Text(
        text = instruction.instruction,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailScreen() {
    RecipeApplicationTheme {
        RecipeDetailScreen(recipe = Recipe(
            name = "Avocado Toast with Poached Eggs",
            code = "B01",
            image = R.drawable.avocado_toast_with_poached_eggs,
            instructions = listOf(
                Instruction(0, "Toast the bread slices until golden brown."),
                Instruction(1, "While the bread is toasting, slice the avocado and mash it with a fork in a bowl. Season with salt and pepper."),
                Instruction(2, "Poach the eggs in boiling water for about 3-4 minutes until the whites are set but the yolks are still runny."),
                Instruction(3,"Spread the mashed avocado on each toast and top with a poached egg."),
                Instruction(4, "Add optional toppings if desired and serve immediately.")
            ),
            ingredients = listOf(
                Ingredient(2.0, "slices of whole-grain bread"),
                Ingredient(1.0, "ripe avocado"),
                Ingredient(2.0, "large eggs"),
                Ingredient(1.0, "Salt and pepper to taste"),
                Ingredient(1.0, "sliced tomatoes, microgreens, hot sauce")
            ), CategoryTypes.LUNCH)
        )
    }
}