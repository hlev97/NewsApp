package hu.bme.aut.android.newsapp.ui.screen.main.business

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

class BusinessViewModel() : ViewModel() {

    private val articleInteractor: ArticleInteractor = ArticleInteractor(
        localDataSource = NewsApplication.localDataSource,
        remoteDataSource = NewsApplication.remoteDataSource
    )

    private val _uiState: MutableStateFlow<BusinessUiState> = MutableStateFlow(Loading)
    val uiState: StateFlow<BusinessUiState> = _uiState

    init {
        CoroutineScope(Dispatchers.IO).launch {
            _uiState.value = Loading
            _uiState.value = try {
                articleInteractor.deleteAllArticles()
                val articles = articleInteractor.fetchData("business").map { article ->
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
                val articles = articleInteractor.fetchData("business").map { article ->
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
