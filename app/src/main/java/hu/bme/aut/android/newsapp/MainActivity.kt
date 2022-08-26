package hu.bme.aut.android.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.android.newsapp.navigation.NavGraph
import hu.bme.aut.android.newsapp.navigation.model.Main
import hu.bme.aut.android.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {

    @ExperimentalLifecycleComposeApi
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, Main.route)
            }
        }
    }
}
