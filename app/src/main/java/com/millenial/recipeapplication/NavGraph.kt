package com.millenial.recipeapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.millenial.recipeapplication.model.Screen
import com.millenial.recipeapplication.view.CategoryActivity
import com.millenial.recipeapplication.view.MainActivity
import com.millenial.recipeapplication.view.RecipeActivity
import com.millenial.recipeapplication.view.RecipeDetailActivity

class NavGraph {
}
@Composable
fun SetUp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination =  Screen.Main.route){
        composable(
            route = Screen.Main.route
        ){
            MainActivity()
        }
        composable(
            route = Screen.Category.route
        ){
            CategoryActivity()
        }
        composable(
            route = Screen.Recipe.route
        ){
            RecipeActivity()
        }
        composable(
            route = Screen.Detail.route
        ){
            RecipeDetailActivity()
        }
    }
}
