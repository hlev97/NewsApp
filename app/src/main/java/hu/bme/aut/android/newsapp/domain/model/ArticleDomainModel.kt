package hu.bme.aut.android.newsapp.domain.model

data class ArticleDomainModel(
    val id: Int = 0,
    val title: String,
    val author: String,
    val description: String,
    val publishedAt: String,
    val urlToImage: String,
    val url: String
)
