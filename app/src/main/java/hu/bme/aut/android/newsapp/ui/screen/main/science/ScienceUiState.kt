package hu.bme.aut.android.newsapp.ui.screen.main.science

import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel

sealed interface ScienceUiState

object Loading : ScienceUiState

data class DataReady(val articles: List<ArticleItemModel>) : ScienceUiState

data class Error(val throwable: Throwable) : ScienceUiState
