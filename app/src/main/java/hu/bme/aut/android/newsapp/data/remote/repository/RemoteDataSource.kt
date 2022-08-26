package hu.bme.aut.android.newsapp.data.remote.repository

import hu.bme.aut.android.newsapp.data.remote.api.NewsApi
import hu.bme.aut.android.newsapp.domain.model.ArticleDomainModel
import hu.bme.aut.android.newsapp.util.MapperUtil.toDomainModel

class RemoteDataSource(
    private val api: NewsApi
) {

    suspend fun getNews(
        queryMap: HashMap<String, String>
    ): List<ArticleDomainModel> {
        val clientResponse = api.getResponse(queryMap = queryMap)
        val responseBody = clientResponse.body()

        return if (clientResponse.isSuccessful && responseBody != null) {
            val articles = responseBody.articles.map { article ->
                article.toDomainModel()
            }
            articles
        } else {
            listOf()
        }
    }
}
