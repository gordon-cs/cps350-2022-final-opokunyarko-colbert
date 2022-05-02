package com.elijake.twentivia.network

import android.util.Log
import com.elijake.twentivia.model.Question
import org.json.JSONArray
import org.json.JSONTokener
import java.net.HttpURLConnection
import java.net.URL

// https://johncodeos.com/how-to-parse-json-in-android-using-kotlin/

private const val TAG = "TriviaAPI"

object TriviaAPI {
    fun getTrivia(url: String): List<Question> {
        var result: MutableList<Question> = ArrayList()
        val connection = URL(url).openConnection() as HttpURLConnection
        val data = connection.inputStream.bufferedReader().readText()

        val jsonData = JSONTokener(data).nextValue() as JSONArray
        Log.d(TAG, "$jsonData")
        for (question in 0 until jsonData.length()) {
            var incAns: MutableList<String> = ArrayList()
            for (incorrectAnswer in 0 until jsonData.getJSONObject(question).getJSONArray("incorrectAnswers").length()) {
                incAns.add(jsonData.getJSONObject(question).getJSONArray("incorrectAnswers").getString(incorrectAnswer))
            }
            result.add(Question(
                jsonData.getJSONObject(question).getString("question"),
                jsonData.getJSONObject(question).getString("correctAnswer"),
                incAns)
            )
        }
        return result;
    }

    fun getCategories(url: String) {
        val connection = URL(url).openConnection() as HttpURLConnection
        val data = connection.inputStream.bufferedReader().readText()
        Log.d(TAG, data)
    }
}