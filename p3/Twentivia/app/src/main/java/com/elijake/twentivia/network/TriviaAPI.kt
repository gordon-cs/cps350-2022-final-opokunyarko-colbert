package com.elijake.twentivia.network

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL

object TriviaAPI {
    fun getTrivia(url: String) {
        val connection = URL(url).openConnection() as HttpURLConnection
        val data = connection.inputStream.bufferedReader().readText()
        Log.d("GET", data)
    }

    fun getCategories(url: String) {
        val connection = URL(url).openConnection() as HttpURLConnection
        val data = connection.inputStream.bufferedReader().readText()
        Log.d("GET", data)
    }
}