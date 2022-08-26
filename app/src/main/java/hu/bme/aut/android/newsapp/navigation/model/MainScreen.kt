package hu.bme.aut.android.newsapp.navigation.model

sealed class MainScreen(val route: String)

object Popular : MainScreen(route = "popular")

object Sport : MainScreen(route = "sport")

object Science : MainScreen(route = "science")

object Business : MainScreen(route = "business")
