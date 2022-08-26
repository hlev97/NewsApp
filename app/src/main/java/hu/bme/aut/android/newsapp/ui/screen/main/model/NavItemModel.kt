package hu.bme.aut.android.newsapp.ui.screen.main.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItemModel(
    val icon: ImageVector,
    @StringRes val label: Int,
    val route: String
)
