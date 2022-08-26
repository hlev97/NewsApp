package hu.bme.aut.android.newsapp.data.remote.api

import hu.bme.aut.android.newsapp.data.remote.model.NewsApiResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface NewsApi {

    @GET("top-headlines")
    suspend fun getResponse(
        @QueryMap queryMap: HashMap<String, String>,
        @Header("X-Api-Key") apiKey: String = "4c84f149584b45ee9563b2b5cd815a69"
    ): Response<NewsApiResponseModel>
}
