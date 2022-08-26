package hu.bme.aut.android.newsapp.data.remote.model

data class NewsApiResponseModel(
    val status: String,
    val totalResults: Long,
    val articles: List<ArticleApiModel>
)
