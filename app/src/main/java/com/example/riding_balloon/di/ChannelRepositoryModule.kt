package com.example.riding_balloon.di

import com.example.riding_balloon.data.repository.channel.ChannelRepository
import com.example.riding_balloon.data.repository.channel.ChannelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ChannelRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideChannelRepository() : ChannelRepository = ChannelRepositoryImpl()
}