package hu.bme.aut.android.newsapp.ui.screen.main.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
@Composable
fun MainScreenTopAppBar() {
    SmallTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            scrolledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        title = { Text(text = "News") }
    )
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun MainScreenTopAppBarPreview() {
    MainScreenTopAppBar()
}
