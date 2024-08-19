package com.example.riding_balloon.data.repository.popularvideos

import com.example.riding_balloon.data.model.TrendingVideoResponse

interface PopularVideoRepository {
    suspend fun getVideos(): TrendingVideoResponse
}