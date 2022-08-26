package hu.bme.aut.android.newsapp.navigation.model

sealed class Screen(val route: String)

object Main : Screen("main")

object Article : Screen("article/{id}") {
    fun passId(id: Int) = "article/$id"
}
