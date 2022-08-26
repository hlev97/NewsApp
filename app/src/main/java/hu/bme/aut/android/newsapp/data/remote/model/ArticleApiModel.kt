package hu.bme.aut.android.newsapp.data.remote.model

data class ArticleApiModel(
    val source: SourceApiModel,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)
