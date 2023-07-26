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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.millenial.recipeapplication.SetUp
import com.millenial.recipeapplication.model.Screen
import com.millenial.recipeapplication.view.MainActivity.Companion.TAG
import com.millenial.recipeapplication.ui.theme.RecipeApplicationTheme
import com.millenial.recipeapplication.ui.theme.Purple40


class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "Main"
    }

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeApplicationTheme {
                navController = rememberNavController()
                SetUp(navController = navController)

                // A surface container using the 'background' color from the theme
                Welcome(this, navController)
            }
        }
    }
}

@Composable
fun Welcome(context: Context, navController: NavHostController) {
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
//                onClick = {
//                    navController.navigate(Screen.Category.route)
//                }
                ) {
                Text("Welcome")
            }
        }
    }
}

fun openCategoryView(context: Context) {
    Log.i(TAG, "Welcome button clicked")
    val intent = Intent(context, CategoryActivity::class.java)
    context.startActivity(intent)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipeApplicationTheme {
        Welcome(context = LocalContext.current, navController = rememberNavController())
    }
}