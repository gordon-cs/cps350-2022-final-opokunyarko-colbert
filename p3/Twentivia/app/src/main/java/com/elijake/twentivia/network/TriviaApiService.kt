package com.elijake.twentivia.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

// https://the-trivia-api.com/docs/


// The base url. Must add categories, limit and difficulty before get
// ex. https://the-trivia-api.com/api/questions?categories=music&limit=5&difficulty=easy
private const val BASE_URL =
    "https://the-trivia-api.com/api/questions?"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

interface TriviaApiService {
    @GET("trivia")
    suspend fun getTrivia(): String // callable within coroutine because of 'suspend'
}

// singleton object of the trivia
object TriviaApi {
    val retrofitService : TriviaApiService by lazy {
        retrofit.create(TriviaApiService::class.java) }
}