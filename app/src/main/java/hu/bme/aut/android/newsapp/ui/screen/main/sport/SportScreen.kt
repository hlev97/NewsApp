package hu.bme.aut.android.newsapp.ui.screen.main.sport

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import hu.bme.aut.android.newsapp.navigation.model.Article
import hu.bme.aut.android.newsapp.ui.common.article_list.ArticleList
import hu.bme.aut.android.newsapp.ui.screen.main.components.ScreenContent
import kotlinx.coroutines.delay

@ExperimentalLifecycleComposeApi
@Composable
fun SportScreen(
    navController: NavHostController,
    sportViewModel: SportViewModel = viewModel(),
    modifier: Modifier
) {
    val uiState by sportViewModel.uiState.collectAsStateWithLifecycle()

    var isRefreshing by remember { mutableStateOf(false) }
    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            sportViewModel.refresh()
            delay(2000)
            isRefreshing = false
        }
    }

    ScreenContent(
        isRefreshing = isRefreshing,
        onRefresh = { isRefreshing = true },
        content = {
            when (uiState) {
                is Loading -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Loading...")
                    }
                }
                is DataReady -> {
                    ArticleList(
                        articleItems = (uiState as DataReady).articles,
                        onArticleItemClick = { index ->
                            navController.navigate(Article.passId(index))
                        }
                    )
                }
                is Error -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = (uiState as Error).throwable.message.toString())
                        Log.e("error", (uiState as Error).throwable.stackTraceToString())
                    }
                }
            }
        },
        modifier = modifier
    )
}
