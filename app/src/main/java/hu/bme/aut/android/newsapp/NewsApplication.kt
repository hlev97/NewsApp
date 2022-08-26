package hu.bme.aut.android.newsapp

import android.app.Application
import androidx.room.Room
import hu.bme.aut.android.newsapp.data.local.ArticleDatabase
import hu.bme.aut.android.newsapp.data.local.dao.ArticleDao
import hu.bme.aut.android.newsapp.data.local.repository.LocalDataSource
import hu.bme.aut.android.newsapp.data.remote.api.NewsApi
import hu.bme.aut.android.newsapp.data.remote.repository.RemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class NewsApplication : Application() {

    companion object {
        private lateinit var db: ArticleDatabase

        private lateinit var dao: ArticleDao

        lateinit var localDataSource: LocalDataSource
            private set

        private lateinit var client: OkHttpClient

        private lateinit var retrofit: Retrofit

        private lateinit var api: NewsApi

        lateinit var remoteDataSource: RemoteDataSource
            private set
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            ArticleDatabase::class.java,
            "article_database"
        ).fallbackToDestructiveMigration().build()

        dao = db.getArticleDao()

        localDataSource = LocalDataSource(articleDao = dao)

        client = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        api = retrofit.create(NewsApi::class.java)

        remoteDataSource = RemoteDataSource(api = api)
    }
}
