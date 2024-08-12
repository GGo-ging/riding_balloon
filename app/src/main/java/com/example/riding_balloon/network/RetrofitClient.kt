package com.jeongu.imagesearchapp.network

import com.example.riding_balloon.data.remote.YoutubeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val YOUTUBE_BASE_URL = "https://www.googleapis.com/youtube/v3/"
    val youtubeApi: YoutubeApi by lazy { retrofit.create(YoutubeApi::class.java) }

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