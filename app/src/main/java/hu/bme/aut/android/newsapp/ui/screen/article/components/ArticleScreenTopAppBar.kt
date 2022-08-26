package hu.bme.aut.android.newsapp.ui.screen.article.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import hu.bme.aut.android.newsapp.R

@ExperimentalMaterial3Api
@Composable
fun ArticleScreenTopAppBar(
    title: @Composable () -> Unit,
    urlToImage: String?,
    onNavIconClicked: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(urlToImage)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.placeholder),
        contentDescription = null,
        modifier = if (scrollBehavior.state.heightOffset <= -0.1f) {
            Modifier.height(imageHeight(scrollBehavior.state.heightOffset))
        } else {
            Modifier.height(152.0.dp)
        }.fillMaxWidth()
    )
    LargeTopAppBar(
        title = { title() },
        navigationIcon = {
            IconButton(onClick = { onNavIconClicked() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        scrollBehavior = scrollBehavior,
        colors = if (scrollBehavior.state.heightOffset <= -0.1.dp.value) {
            TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        } else {
            TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(0.5f))
        }
    )
}

private fun imageHeight(offset: Float): Dp {
    val positiveOffset = -1 * offset
    return ((positiveOffset - 64.dp.value) / (152.dp.value - 64.dp.value)).dp
}
