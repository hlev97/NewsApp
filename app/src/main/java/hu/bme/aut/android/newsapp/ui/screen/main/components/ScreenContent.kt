package hu.bme.aut.android.newsapp.ui.screen.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import hu.bme.aut.android.newsapp.ui.theme.ARTICLE_ITEM_PADDING

@Composable
fun ScreenContent(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    val refreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshState.isRefreshing),
        onRefresh = { onRefresh() },
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = ARTICLE_ITEM_PADDING)
    ) {
        content()
    }
}
