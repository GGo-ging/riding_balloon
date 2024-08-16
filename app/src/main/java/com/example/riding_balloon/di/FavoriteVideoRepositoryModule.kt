package com.example.riding_balloon.di

import com.example.riding_balloon.data.repository.FavoriteVideoRepository
import com.example.riding_balloon.data.repository.FavoriteVideoRepositoryImpl
import com.example.riding_balloon.data.source.remote.YoutubeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object FavoriteVideoRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideFavoriteVideoRepository(
        youtubeApi: YoutubeApi
    ) : FavoriteVideoRepository = FavoriteVideoRepositoryImpl(youtubeApi)
}