package hu.bme.aut.android.newsapp.ui.screen.main.sport

import androidx.lifecycle.ViewModel
import hu.bme.aut.android.newsapp.NewsApplication
import hu.bme.aut.android.newsapp.domain.interactor.ArticleInteractor
import hu.bme.aut.android.newsapp.util.MapperUtil.toArticleItemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SportViewModel() : ViewModel() {

    private val articleInteractor: ArticleInteractor = ArticleInteractor(
        localDataSource = NewsApplication.localDataSource,
        remoteDataSource = NewsApplication.remoteDataSource
    )

    private val _uiState: MutableStateFlow<SportUiState> = MutableStateFlow(Loading)
    val uiState: StateFlow<SportUiState> = _uiState

    init {
        CoroutineScope(Dispatchers.IO).launch {
            _uiState.value = Loading
            _uiState.value = try {
                articleInteractor.deleteAllArticles()
                val articles = articleInteractor.fetchData("sport").map { article ->
                    article.toArticleItemModel()
                }
                DataReady(articles = articles)
            } catch (e: Exception) {
                Error(throwable = e)
            }
        }
    }

    fun refresh() {
        CoroutineScope(Dispatchers.IO).launch {
            _uiState.value = Loading
            _uiState.value = try {
                articleInteractor.deleteAllArticles()
                val articles = articleInteractor.fetchData("sport").map { article ->
                    article.toArticleItemModel()
                }
                delay(2000)
                DataReady(articles = articles)
            } catch (e: Exception) {
                Error(throwable = e)
            }
        }
    }
}
