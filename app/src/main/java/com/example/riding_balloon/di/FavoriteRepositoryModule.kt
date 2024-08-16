package com.example.riding_balloon.di

import android.content.Context
import com.example.riding_balloon.data.repository.FavoriteRepository
import com.example.riding_balloon.data.repository.FavoriteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object FavoriteRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideFavoriteRepository(
        @ApplicationContext context: Context
    ) : FavoriteRepository = FavoriteRepositoryImpl(context)
}