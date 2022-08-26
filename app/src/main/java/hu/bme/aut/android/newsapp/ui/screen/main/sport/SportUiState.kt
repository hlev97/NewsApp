package hu.bme.aut.android.newsapp.ui.screen.main.sport

import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel

sealed interface SportUiState

object Loading : SportUiState

data class DataReady(val articles: List<ArticleItemModel>) : SportUiState

data class Error(val throwable: Throwable) : SportUiState
