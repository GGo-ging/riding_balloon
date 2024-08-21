package com.example.riding_balloon.di

import android.content.Context
import com.example.riding_balloon.data.repository.FavoriteRepository
import com.example.riding_balloon.data.repository.FavoriteRepositoryImpl
import com.example.riding_balloon.data.repository.travelspotdetail.OpenAiApiRepository
import com.example.riding_balloon.data.repository.travelspotdetail.OpenAiApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OpenAiApiRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideOpenAiApiRepository(
        @ApplicationContext context: Context
    ) : OpenAiApiRepository = OpenAiApiRepositoryImpl()
}