package hu.bme.aut.android.newsapp.ui.screen.main.popular

import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel

sealed interface PopularUiState

object Loading : PopularUiState

data class DataReady(val articles: List<ArticleItemModel>) : PopularUiState

data class Error(val throwable: Throwable) : PopularUiState
