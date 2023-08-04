package com.millenial.recipeapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.millenial.recipeapplication.R
import com.millenial.recipeapplication.model.CategoryTypes
import com.millenial.recipeapplication.model.Ingredient
import com.millenial.recipeapplication.model.Instruction
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.RecipeWithInstructionAndIngredients
import com.millenial.recipeapplication.model.room.RecipeDatabase
import com.millenial.recipeapplication.model.room.RecipeRepository
import com.millenial.recipeapplication.ui.theme.Purple40
import com.millenial.recipeapplication.ui.theme.RecipeApplicationTheme
import com.millenial.recipeapplication.viewModel.RecipeDetailViewModel
import com.millenial.recipeapplication.viewModel.factory.RepositoryViewModelFactory

class RecipeDetailActivity : ComponentActivity() {
    companion object {
        const val TAG: String = "RecipeDetailActivity"
    }

    private lateinit var recipeDetailViewModel: RecipeDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recipe: Recipe? = intent.getParcelableExtra<Recipe>("RECIPE", Recipe::class.java)

        val recipeRepository = RecipeRepository(RecipeDatabase.getDatabase(this).recipeDao())
        val viewModelFactory = RepositoryViewModelFactory(recipeRepository)
        recipeDetailViewModel = ViewModelProvider(this, viewModelFactory).get(RecipeDetailViewModel::class.java)

        val recipeWithInstructionAndIngredients = getRecipeWithInstructionAndIngredientsByRecipe(recipe)
        recipeDetailViewModel.setRecipe(recipeWithInstructionAndIngredients)
        setContent {
            RecipeApplicationTheme {
                RecipeDetailScreen(recipeDetailViewModel)
            }
        }
    }

    private fun getRecipeWithInstructionAndIngredientsByRecipe(recipe: Recipe?): RecipeWithInstructionAndIngredients {
        val recipeCode = recipe?.code!!
        return recipeDetailViewModel.getRecipeWithInstructionAndIngredientsById(recipeCode)!!
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(recipeViewModel: RecipeDetailViewModel) {
    val context = LocalContext.current
    val recipe: RecipeWithInstructionAndIngredients? = recipeViewModel.recipe.value
    val recipeName: String = recipe?.recipe!!.name ?: "Recipe Detail"

    Column {
        TopAppBar(
            title = { Text(text = recipeName) },
            navigationIcon = {
                IconButton(onClick = {
                    context.startActivity(Intent(context, RecipeActivity::class.java))
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            Card {
                RecipeContent(recipeWithInstructionAndIngredients = recipe)
            }
        }
    }
}

@Composable
fun RecipeContent(recipeWithInstructionAndIngredients: RecipeWithInstructionAndIngredients?) {
    if (recipeWithInstructionAndIngredients != null) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                RecipeImage(recipeWithInstructionAndIngredients.recipe!!.image)
            }
            item {
                IngredientTitle()
            }

            items(recipeWithInstructionAndIngredients.ingredients!!) { ingredient ->
                RecipeIngredientItem(ingredient)
            }
            item {
                InstructionTitle()
            }
            items(recipeWithInstructionAndIngredients.instructions!!) { instruction ->
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
        text = "${ingredient.amount ?: ""} ${requiredString(ingredient.required!!)} ${ingredient.description}" ,
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
        text = instruction.instruction!!,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailScreen() {
    val recipe = RecipeWithInstructionAndIngredients(
        recipe = Recipe(
            name = "Avocado Toast with Poached Eggs",
            code = "B01",
            image = R.drawable.avocado_toast_with_poached_eggs,
            categoryType = CategoryTypes.BREAKFAST
        ),
        instructions = listOf(
            Instruction(step = 0, instruction = "Toast the bread slices until golden brown."),
            Instruction(step = 1, instruction = "While the bread is toasting, slice the avocado and mash it with a fork in a bowl. Season with salt and pepper."),
            Instruction(step = 2, instruction = "Poach the eggs in boiling water for about 3-4 minutes until the whites are set but the yolks are still runny."),
            Instruction(step = 3, instruction = "Spread the mashed avocado on each toast and top with a poached egg."),
            Instruction(step = 4, instruction = "Add optional toppings if desired and serve immediately.")
        ),
        ingredients = listOf(
            Ingredient(amount = 2.0, description = "slices of whole-grain bread"),
            Ingredient(amount = 1.0, description = "ripe avocado"),
            Ingredient(amount = 2.0, description = "large eggs"),
            Ingredient(amount = 1.0, description = "Salt and pepper to taste"),
            Ingredient(amount = 1.0, description = "sliced tomatoes, microgreens, hot sauce")
        )
    )
    val recipeViewModel = RecipeDetailViewModel(RecipeRepository(RecipeDatabase.getDatabase(
        LocalContext.current).recipeDao()))
    recipeViewModel.setRecipe(recipe)
    RecipeApplicationTheme {
        RecipeDetailScreen(
            recipeViewModel =  recipeViewModel
        )
    }
}
