package com.millenial.recipeapplication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.millenial.recipeapplication.model.Category
import com.millenial.recipeapplication.viewModel.factory.CategoryViewModelFactory
import com.millenial.recipeapplication.model.repository.CategoryRepository
import com.millenial.recipeapplication.model.room.RecipeDatabase
import com.millenial.recipeapplication.ui.theme.RecipeApplicationTheme
import com.millenial.recipeapplication.view.CategoryActivity.Companion.categoryVarName
import com.millenial.recipeapplication.viewModel.CategoryViewModel

/**
 * Activity that displays a list of categories using Jetpack Compose.
 */
class CategoryActivity : ComponentActivity() {
    companion object {
        const val TAG: String= "CategoryActivity"
        const val categoryVarName = "CATEGORY_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RecipeApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoryList()
                }
            }
        }
    }
}

/**
 * Composable function that displays a list of categories using a LazyColumn.
 */
@Composable
fun CategoryList() {

    val launcher = rememberLauncherForActivityResult(
        contract = RecipeActivityContract()
    ) {

    }

    val categories: List<Category> = generateCategories()

    LazyColumn {
        items(categories) { category ->
            CategoryCard(
                category = category,
                onClick = {
                    launcher.launch(category.name.type)
                })
        }
    }
}

/**
 * Generates a list of categories using a ViewModel and repository.
 *
 * This function uses a [CategoryViewModel] to fetch a list of [Category] items
 * from a [CategoryRepository].
 *
 * @return A list of categories.
 */
@Composable
private fun generateCategories(): List<Category> {
    val viewModel: CategoryViewModel = viewModel(
        factory =
        CategoryViewModelFactory(
            categoryRepository = CategoryRepository(
                RecipeDatabase.getDatabase(context = LocalContext.current).categoryDao()
            )
        )
    )
    return viewModel.categories
}

/**
 * Composable function that displays a single category as a card.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(category: Category, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            category.image?.let { image ->
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
                text = category.name.type,
                color = Color.Black,
            )
        }
    }
}

/**
 * Activity result contract for launching the RecipeActivity.
 */
class RecipeActivityContract : ActivityResultContract<String, Unit>() {
    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context, RecipeActivity::class.java).apply {
            putExtra(categoryVarName, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Unit {
        // No result needed in this case
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    RecipeApplicationTheme {
        CategoryList()
    }
}

