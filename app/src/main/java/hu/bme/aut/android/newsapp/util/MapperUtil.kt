package hu.bme.aut.android.newsapp.util

import hu.bme.aut.android.newsapp.data.local.entities.ArticleEntityModel
import hu.bme.aut.android.newsapp.data.remote.model.ArticleApiModel
import hu.bme.aut.android.newsapp.domain.model.ArticleDomainModel
import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel

object MapperUtil {

    fun ArticleApiModel.toDomainModel() = ArticleDomainModel(
        id = 0,
        title = title,
        author = author ?: "",
        description = description ?: "",
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage ?: ""
    )

    fun ArticleEntityModel.toDomainModel() = ArticleDomainModel(
        id = id,
        title = title,
        author = author,
        description = description,
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage
    )

    fun ArticleDomainModel.toArticleEntityModel() = ArticleEntityModel(
        id = id,
        title = title,
        author = author,
        description = description,
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage
    )

    fun ArticleItemModel.toArticleDomainModel() = ArticleDomainModel(
        id = id,
        title = title,
        author = author,
        description = description,
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage
    )

    fun ArticleDomainModel.toArticleItemModel() = ArticleItemModel(
        id = id,
        title = title,
        author = author,
        description = description,
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage
    )
}
