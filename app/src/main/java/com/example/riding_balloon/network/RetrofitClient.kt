package com.example.riding_balloon.network

import com.example.riding_balloon.data.model.openai.OpenAIApi
import com.example.riding_balloon.data.source.remote.YoutubeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val YOUTUBE_BASE_URL = "https://www.googleapis.com/youtube/v3/"
    val youtubeApi: YoutubeApi by lazy { retrofit.create(YoutubeApi::class.java) }

    private const val OPEN_AI_BASE_URL = "https://api.openai.com/v1/"
    val openAiApi: OpenAIApi by lazy { createRetrofit(OPEN_AI_BASE_URL).create() }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(YOUTUBE_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val okHttpClient by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .addNetworkInterceptor(interceptor)
            .build()
    }
}