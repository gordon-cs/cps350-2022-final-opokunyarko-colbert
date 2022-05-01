package com.elijake.twentivia.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.elijake.twentivia.model.Question
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// https://the-trivia-api.com/docs/

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// The base url. Must add categories, limit and difficulty before get
// ex. https://the-trivia-api.com/api/questions?categories=music&limit=5&difficulty=easy
private const val BASE_URL =
    "https://the-trivia-api.com/api/questions?"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TriviaApiService {
    @GET("trivia")
    suspend fun getTrivia(): List<Question> // callable within coroutine because of 'suspend'
}

// singleton object of the trivia
object TriviaApi {
    val retrofitService : TriviaApiService by lazy {
        retrofit.create(TriviaApiService::class.java) }
}