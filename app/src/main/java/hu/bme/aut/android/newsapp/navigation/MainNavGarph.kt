package hu.bme.aut.android.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.bme.aut.android.newsapp.navigation.model.Business
import hu.bme.aut.android.newsapp.navigation.model.Popular
import hu.bme.aut.android.newsapp.navigation.model.Science
import hu.bme.aut.android.newsapp.navigation.model.Sport
import hu.bme.aut.android.newsapp.ui.screen.main.business.BusinessScreen
import hu.bme.aut.android.newsapp.ui.screen.main.popular.PopularScreen
import hu.bme.aut.android.newsapp.ui.screen.main.science.ScienceScreen
import hu.bme.aut.android.newsapp.ui.screen.main.sport.SportScreen

@ExperimentalLifecycleComposeApi
@Composable
fun MainNavGraph(
    navController: NavHostController,
    bottomNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = bottomNavController,
        startDestination = Popular.route
    ) {
        composable(route = Popular.route) {
            PopularScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Sport.route) {
            SportScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Science.route) {
            ScienceScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Business.route) {
            BusinessScreen(
                navController = navController,
                modifier = modifier
            )
        }
    }
}
