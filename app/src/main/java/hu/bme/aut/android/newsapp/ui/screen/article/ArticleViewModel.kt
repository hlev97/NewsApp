package hu.bme.aut.android.newsapp.ui.screen.article

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import hu.bme.aut.android.newsapp.NewsApplication
import hu.bme.aut.android.newsapp.data.local.repository.LocalDataSource
import hu.bme.aut.android.newsapp.util.HtmlUtil.getHtmlFromUrl
import hu.bme.aut.android.newsapp.util.MapperUtil.toArticleItemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    application: Application,
    private val savedStateHandle: SavedStateHandle
) : AndroidViewModel(application) {

    private val localDataSource: LocalDataSource = NewsApplication.localDataSource

    private var _uiState: MutableStateFlow<ArticleUiState> = MutableStateFlow(Loading)
    val uiState: StateFlow<ArticleUiState> = _uiState

    init {
        _uiState.value = Loading
        val id = savedStateHandle.get<Int>("id")
        if (id != null) {
            CoroutineScope(Dispatchers.IO).launch {
                val article = localDataSource.getArticleById(id = id).toArticleItemModel()
                try {
                    article.url = getHtmlFromUrl(article.url)
                    _uiState.value = DataReady(article = article)
                } catch (e: Exception) {
                    Log.e("error", e.message.toString())
                    _uiState.value = Error(throwable = e)
                }
            }
        }
    }
}
