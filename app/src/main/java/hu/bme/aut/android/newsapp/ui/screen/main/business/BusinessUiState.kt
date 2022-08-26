package hu.bme.aut.android.newsapp.ui.screen.main.business

import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel

sealed interface BusinessUiState

object Loading : BusinessUiState

data class DataReady(val articles: List<ArticleItemModel>) : BusinessUiState

data class Error(val throwable: Throwable) : BusinessUiState
