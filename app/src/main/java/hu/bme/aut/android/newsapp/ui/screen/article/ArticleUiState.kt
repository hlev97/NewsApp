package hu.bme.aut.android.newsapp.ui.screen.article

import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel

sealed interface ArticleUiState

object Loading : ArticleUiState

data class DataReady(val article: ArticleItemModel) : ArticleUiState

data class Error(val throwable: Throwable) : ArticleUiState
