package com.millenial.recipeapplication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millenial.recipeapplication.model.repository.CategoryRepository
import com.millenial.recipeapplication.model.room.RecipeDatabase
import com.millenial.recipeapplication.model.repository.RecipeRepository
import com.millenial.recipeapplication.ui.theme.RecipeApplicationTheme
import com.millenial.recipeapplication.ui.theme.Purple40
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runBlocking {
            launch { prepareDatabase() }
        }

        setContent {
            RecipeApplicationTheme {
                Welcome(this)
            }
        }
    }

    private suspend fun prepareDatabase() {
        Log.d(TAG, "Prepare database")
        val database = RecipeDatabase.getDatabase(this)
        val categoryRepository = CategoryRepository(database.categoryDao())
        categoryRepository.insertAll()
        val recipeRepository = RecipeRepository(database.recipeDao())
        recipeRepository.insertAll()
    }
}

@Composable
fun Welcome(context: Context) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = Purple40
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
            ) {
            Button(
                onClick = { openCategoryView(context = context) },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ),
                ) {
                Text("Welcome")
            }
        }
    }
}

fun openCategoryView(context: Context) {
    val intent = Intent(context, CategoryActivity::class.java)
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipeApplicationTheme {
        Welcome(context = LocalContext.current)
    }
}