package hu.bme.aut.android.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.android.newsapp.data.local.dao.ArticleDao
import hu.bme.aut.android.newsapp.data.local.entities.ArticleEntityModel

@Database(entities = [ArticleEntityModel::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}
