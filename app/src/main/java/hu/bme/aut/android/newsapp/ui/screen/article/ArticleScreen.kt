package hu.bme.aut.android.newsapp.ui.screen.article

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.android.newsapp.navigation.model.Article
import hu.bme.aut.android.newsapp.navigation.model.Main
import hu.bme.aut.android.newsapp.ui.screen.article.components.ArticleContent
import hu.bme.aut.android.newsapp.ui.screen.article.components.ArticleScreenTopAppBar
import hu.bme.aut.android.newsapp.ui.screen.article.components.ErrorContent
import hu.bme.aut.android.newsapp.ui.screen.article.components.LoadingContent

@ExperimentalLifecycleComposeApi
@ExperimentalMaterial3Api
@Composable
fun ArticleScreen(
    navController: NavHostController,
    articleViewModel: ArticleViewModel = viewModel()
) {
    val uiState by articleViewModel.uiState.collectAsStateWithLifecycle()

    BackHandler {
        navController.clearBackStack(Article.route)
        navController.navigate(Main.route)
    }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState()
    )

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        ArticleScreenTopAppBar(
            title = { },
            urlToImage = when (uiState) {
                is Loading -> {
                    null
                }
                is DataReady -> {
                    (uiState as DataReady).article.urlToImage
                }
                is Error -> {
                    Log.e("error", (uiState as Error).throwable.message.toString())
                    null
                }
            },
            onNavIconClicked = {
                navController.clearBackStack(Article.route)
                navController.navigate(Main.route)
            },
            scrollBehavior = scrollBehavior
        )
    }) { paddingValues ->
        when (uiState) {
            is Loading -> {
                LoadingContent()
            }
            is DataReady -> {
                ArticleContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    articleText = (uiState as DataReady).article.url
                )
            }
            is Error -> {
                ErrorContent(errorMessage = (uiState as Error).throwable.message.toString())
            }
        }
    }
}

@ExperimentalLifecycleComposeApi
@ExperimentalMaterial3Api
@Composable
@Preview
fun ArticleScreenPreview() {
    ArticleScreen(navController = rememberNavController())
}
