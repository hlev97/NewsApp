package hu.bme.aut.android.newsapp.ui.common.model

data class ArticleItemModel(
    val id: Int,
    val title: String,
    val author: String,
    val description: String,
    val publishedAt: String,
    var url: String,
    val urlToImage: String
)
