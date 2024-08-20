package com.example.riding_balloon.di

import com.example.riding_balloon.data.repository.travelspotdetail.RelevanceVideoRepository
import com.example.riding_balloon.data.repository.travelspotdetail.RelevanceVideoRepositoryImpl
import com.example.riding_balloon.data.repository.travelspotdetail.TravelSpotRepository
import com.example.riding_balloon.data.repository.travelspotdetail.TravelSpotRepositoryImpl
import com.example.riding_balloon.data.source.remote.YoutubeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TravelSpotRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideTravelSpotRepository() : TravelSpotRepository = TravelSpotRepositoryImpl()
}

