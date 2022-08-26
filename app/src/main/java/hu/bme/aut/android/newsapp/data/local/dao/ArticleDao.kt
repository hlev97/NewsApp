package hu.bme.aut.android.newsapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.bme.aut.android.newsapp.data.local.entities.ArticleEntityModel

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<ArticleEntityModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticles(articles: List<ArticleEntityModel>)

    @Query("SELECT * FROM articles WHERE id = :id")
    fun getArticleById(id: Int): ArticleEntityModel

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()

    @Query("SELECT COUNT(id) FROM articles")
    fun countArticles(): Int
}
