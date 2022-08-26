package hu.bme.aut.android.newsapp.ui.screen.main.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ActionItemModel(
    val icon: ImageVector,
    val onClick: () -> Unit
)
