package hu.bme.aut.android.newsapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hu.bme.aut.android.newsapp.navigation.model.Article
import hu.bme.aut.android.newsapp.navigation.model.Main
import hu.bme.aut.android.newsapp.ui.screen.article.ArticleScreen
import hu.bme.aut.android.newsapp.ui.screen.main.MainScreen

@ExperimentalLifecycleComposeApi
@ExperimentalMaterial3Api
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Main.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Article.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            ArticleScreen(
                navController = navController,
                articleViewModel = viewModel()
            )
        }
    }
}
