package hu.bme.aut.android.newsapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntityModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String,
    val description: String,
    val publishedAt: String,
    val urlToImage: String,
    val url: String
)
