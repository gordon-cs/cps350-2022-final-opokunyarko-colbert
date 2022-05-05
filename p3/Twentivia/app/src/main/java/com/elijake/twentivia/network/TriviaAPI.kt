package com.elijake.twentivia.network

import android.util.Log
import com.elijake.twentivia.model.Question
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.HttpURLConnection
import java.net.URL

// source for parsing JSON: https://johncodeos.com/how-to-parse-json-in-android-using-kotlin/

private const val TAG = "TriviaAPI"
private const val BASE_URL: String = "https://the-trivia-api.com/api/"

object TriviaAPI {
    fun getTrivia(categories: ArrayList<String>): List<Question> {
        var url: String = BASE_URL + "questions?categories="
        for (i in 0 until categories.size - 2) {
            url += categories[i]
            Log.d(TAG, "Adding ${categories[i]}")
        }
        url += categories[categories.size - 1] + "&limit=20"

        Log.d(TAG, "Attempting connection to: $url")

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

    fun getCategories(): List<String> {
        val url: String = BASE_URL + "categories"
        var result: MutableList<String> = ArrayList()
        val connection = URL(url).openConnection() as HttpURLConnection
        val data = connection.inputStream.bufferedReader().readText()
        val jsonData = JSONTokener(data).nextValue() as JSONObject
        Log.d(TAG, "$jsonData")
        for (category in jsonData.keys()) {
            for (subCategory in 0 until jsonData.getJSONArray(category).length()) {
                result.add(jsonData.getJSONArray(category).getString(subCategory))
            }
        }
        Log.d(TAG, "$result")
        return result;
    }
}