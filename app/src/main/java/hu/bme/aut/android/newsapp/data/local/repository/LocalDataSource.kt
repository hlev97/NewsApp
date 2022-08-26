package hu.bme.aut.android.newsapp.data.local.repository

import hu.bme.aut.android.newsapp.data.local.dao.ArticleDao
import hu.bme.aut.android.newsapp.domain.model.ArticleDomainModel
import hu.bme.aut.android.newsapp.util.MapperUtil.toArticleEntityModel
import hu.bme.aut.android.newsapp.util.MapperUtil.toDomainModel

class LocalDataSource(
    private val articleDao: ArticleDao
) {

    fun getAllArticles(): List<ArticleDomainModel> = articleDao.getAllArticles().map { article ->
        article.toDomainModel()
    }

    suspend fun insertArticles(articles: List<ArticleDomainModel>) {
        articleDao.insertArticles(
            articles.map { article ->
                article.toArticleEntityModel()
            }
        )
    }

    fun getArticleById(id: Int): ArticleDomainModel =
        articleDao.getArticleById(id).toDomainModel()

    suspend fun deleteAllArticles() {
        articleDao.deleteAllArticles()
    }

    fun countArticles(): Int = articleDao.countArticles()
}
