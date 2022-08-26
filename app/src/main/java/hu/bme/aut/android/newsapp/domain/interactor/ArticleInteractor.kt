package hu.bme.aut.android.newsapp.domain.interactor

import hu.bme.aut.android.newsapp.data.local.repository.LocalDataSource
import hu.bme.aut.android.newsapp.data.remote.repository.RemoteDataSource
import hu.bme.aut.android.newsapp.domain.model.ArticleDomainModel

class ArticleInteractor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun fetchData(
        category: String?
    ): List<ArticleDomainModel> {
        val articles = remoteDataSource.getNews(
            hashMapOf("category" to (category ?: ""), "country" to "us")
        )
        localDataSource.insertArticles(articles = articles)
        return localDataSource.getAllArticles()
    }

    suspend fun refreshData(
        category: String?
    ): List<ArticleDomainModel> {
        if (localDataSource.countArticles() != 0) {
            localDataSource.deleteAllArticles()
        }

        val articles = remoteDataSource.getNews(
            hashMapOf("category" to category.toString(), "country" to "us")
        )

        localDataSource.insertArticles(articles = articles)

        return localDataSource.getAllArticles()
    }

    suspend fun deleteAllArticles() {
        localDataSource.deleteAllArticles()
    }
}
