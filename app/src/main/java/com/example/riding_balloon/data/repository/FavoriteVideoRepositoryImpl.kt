package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailResponse
import com.jeongu.imagesearchapp.network.RetrofitClient.youtubeApi

class FavoriteVideoRepositoryImpl : FavoriteVideoRepository {
    override suspend fun getTrendingVideos(): TrendingVideoResponse {
        return youtubeApi.getTrendingVideos()
    }

    override suspend fun searchVideos(query: String): SearchVideoResponse {
        return youtubeApi.searchVideos(query = query)
    }

    override suspend fun searchVideosOrderByViewCount(query: String): SearchVideoResponse {
        return youtubeApi.searchVideosOrderByViewCount(query = query)
    }

    override suspend fun getVideoDetail(id: String): VideoDetailResponse {
        return youtubeApi.getVideoDetail(id = id)
    }
}