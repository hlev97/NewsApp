package hu.bme.aut.android.newsapp.util

import io.github.cdimascio.essence.Essence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

object HtmlUtil {

    @kotlin.jvm.Throws
    suspend fun getHtmlFromUrl(url: String): String {
        val address = URL(url)
        val urlConnection = withContext(Dispatchers.IO) {
            address.openConnection()
        } as HttpURLConnection
        val html = try {
            urlConnection.inputStream.bufferedReader().readText()
        } catch (e: Exception) {
            throw e
        } finally {
            urlConnection.disconnect()
        }
        return Essence.extract(html).text
    }
}
