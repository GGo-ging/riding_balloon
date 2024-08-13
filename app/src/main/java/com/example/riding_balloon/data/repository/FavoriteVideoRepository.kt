package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailResponse

interface FavoriteVideoRepository {

    suspend fun getTrendingVideos(): TrendingVideoResponse

    suspend fun searchVideos(query: String): SearchVideoResponse

    suspend fun searchVideosOrderByViewCount(query: String): SearchVideoResponse

    suspend fun getVideoDetail(id: String): VideoDetailResponse
}