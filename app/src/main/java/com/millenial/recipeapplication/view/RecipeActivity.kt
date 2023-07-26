package com.millenial.recipeapplication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millenial.recipeapplication.model.Recipe
import com.millenial.recipeapplication.model.recipeListForBreakfast
import com.millenial.recipeapplication.ui.theme.Purple40
import com.millenial.recipeapplication.view.RecipeActivity.Companion.TAG
import com.millenial.recipeapplication.view.RecipeActivity.Companion.recipeCodeValue
import com.millenial.recipeapplication.ui.theme.RecipeApplicationTheme
import com.millenial.recipeapplication.viewModel.RecipeViewModel

class RecipeActivity : ComponentActivity() {
    companion object {
        fun getApplicationContext(): Context? {
            return getApplicationContext()
        }

        var recipeCodeValue: String? = null
        const val TAG: String = "RecipeActivity"
        lateinit var  categoryName: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryName = intent.getStringExtra(CategoryActivity.categoryVarName)!!

        Log.i(TAG, "Category name received: $categoryName")

        setContent {
            RecipeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = RecipeViewModel()
                    val recipes: List<Recipe> = viewModel.getRecipes(categoryName = RecipeActivity.categoryName)

                    ListView(recipes)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListView(recipes: List<Recipe>) {

    if (recipes.isEmpty()) {
        NoRecipesView()
        return
    }

    val launcher = rememberLauncherForActivityResult(
            contract = RecipeDetailActivityContract()
        ) {
            Log.i(TAG, "Card clicked ${recipeCodeValue}")
        }
    val context = LocalContext.current
    val title = RecipeActivity.categoryName + " List"

    Column {
        TopAppBar(
            title = {  Text(text = title) },
            navigationIcon = {
                IconButton(onClick = {
                    context.startActivity(Intent(context, CategoryActivity::class.java))
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
        Scaffold(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
        ) {
            ListLayout(recipes, launcher)
        }
    }

}

@Composable
private fun ListLayout(
    recipes: List<Recipe>,
    launcher: ManagedActivityResultLauncher<Recipe, Unit>
) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = Purple40,
            background = Color.Gray,
        )
    ) {
        LazyColumn {
            items(recipes) { recipe ->
                RecipeCard(recipe = recipe,
                    onClick = {
                        launcher.launch(recipe)
                    })
            }
        }
    }
}

@Composable
fun NoRecipesView() {
    Toast.makeText(RecipeActivity.getApplicationContext(), "No Recipe", Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
    MaterialTheme (
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = Purple40,
            background = Color.Gray,
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = onClick
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    recipe.image.let { image ->
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = recipe.name,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}

class RecipeDetailActivityContract : ActivityResultContract<Recipe, Unit>() {
    override fun createIntent(context: Context, recipe: Recipe): Intent {
        return Intent(context, RecipeDetailActivity::class.java).apply {
            putExtra("RECIPE", recipe)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Unit {
        // No result needed in this case
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    RecipeApplicationTheme {
        ListView(recipeListForBreakfast())
    }
}