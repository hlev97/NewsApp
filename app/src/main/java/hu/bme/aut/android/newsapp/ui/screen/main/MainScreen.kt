package hu.bme.aut.android.newsapp.ui.screen.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.android.newsapp.R
import hu.bme.aut.android.newsapp.navigation.MainNavGraph
import hu.bme.aut.android.newsapp.navigation.model.Business
import hu.bme.aut.android.newsapp.navigation.model.Popular
import hu.bme.aut.android.newsapp.navigation.model.Science
import hu.bme.aut.android.newsapp.navigation.model.Sport
import hu.bme.aut.android.newsapp.ui.screen.main.components.MainScreenBottomNavigation
import hu.bme.aut.android.newsapp.ui.screen.main.components.MainScreenTopAppBar
import hu.bme.aut.android.newsapp.ui.screen.main.model.NavItemModel

@ExperimentalLifecycleComposeApi
@ExperimentalMaterial3Api
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val bottomNavController = rememberNavController()

    BackHandler { }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val navItems = listOf(
                NavItemModel(
                    icon = Icons.Filled.Star,
                    label = R.string.nav_item_popular_news_label,
                    route = Popular.route
                ),
                NavItemModel(
                    icon = Icons.Filled.Sports,
                    label = R.string.nav_item_popular_news_sport_label,
                    route = Sport.route
                ),
                NavItemModel(
                    icon = Icons.Filled.Science,
                    label = R.string.nav_item_popular_news_science_label,
                    route = Science.route
                ),
                NavItemModel(
                    icon = Icons.Filled.Business,
                    label = R.string.nav_item_popular_news_business_label,
                    route = Business.route
                )
            )

            MainScreenBottomNavigation(
                navItems = navItems,
                onClick = { selectedIndex ->
                    bottomNavController.navigate(navItems[selectedIndex].route)
                }
            )
        },
        topBar = {
            MainScreenTopAppBar()
        }
    ) {
        MainNavGraph(
            navController = navController,
            bottomNavController = bottomNavController,
            modifier = Modifier.padding(it)
        )
    }
}

@Preview
@ExperimentalLifecycleComposeApi
@ExperimentalMaterial3Api
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
