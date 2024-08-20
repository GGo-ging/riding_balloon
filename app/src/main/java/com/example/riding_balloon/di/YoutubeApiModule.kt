package com.example.riding_balloon.di

import android.content.Context
import com.example.riding_balloon.data.source.remote.YoutubeApi
import com.example.riding_balloon.network.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//class YoutubeApiModuleClass constructor(
//    context: Context
//) {
//    companion object {
//        private var instance: YoutubeApi? = null
//
//        fun getInstance(context: Context): YoutubeApi {
//            return instance ?: synchronized(this) {
//                instance ?: YoutubeApi(context.applicationContext).also {
//                    instance = it
//                }
//            }
//        }
//    }
//}

@Module
@InstallIn(SingletonComponent::class)
object YoutubeApiModule {
    private const val cacheSize = 100 * 1024 * 1024 // 100 MB
//    private val mCache = Cache(context.cacheDir, cacheSize.toLong())

    private const val YOUTUBE_BASE_URL = "https://www.googleapis.com/youtube/v3/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
//            .cache(mCache)
            .addInterceptor(AuthorizationInterceptor())
            .addNetworkInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(YOUTUBE_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideYoutubeApi(retrofit: Retrofit): YoutubeApi {
        return retrofit.create(YoutubeApi::class.java)
    }
}