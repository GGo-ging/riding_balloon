package com.example.riding_balloon.di

import com.example.riding_balloon.data.repository.travelspotdetail.RelevanceVideoRepository
import com.example.riding_balloon.data.repository.travelspotdetail.RelevanceVideoRepositoryImpl
import com.example.riding_balloon.data.source.remote.YoutubeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RelevantVideoRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideRelevantVideoRepository(
        youtubeApi: YoutubeApi
    ) : RelevanceVideoRepository = RelevanceVideoRepositoryImpl(youtubeApi)
}

