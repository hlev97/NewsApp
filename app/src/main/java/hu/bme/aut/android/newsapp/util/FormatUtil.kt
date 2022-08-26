package hu.bme.aut.android.newsapp.util

object FormatUtil {

    fun String.formatDate(): String {
        val regex = Regex("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")
        return regex.find(this)!!.value
    }
}
