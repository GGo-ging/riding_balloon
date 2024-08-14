package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.ChannelDetailsResponse
import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailsResponse
import com.example.riding_balloon.data.source.remote.YoutubeApi
import javax.inject.Inject

class FavoriteVideoRepositoryImpl @Inject constructor(private val youtubeApi: YoutubeApi) : FavoriteVideoRepository {

    override suspend fun getTrendingVideos(): TrendingVideoResponse {
        return youtubeApi.getTrendingVideos()
    }

    override suspend fun searchVideos(query: String): SearchVideoResponse {
        return youtubeApi.searchVideos(query = query)
    }

    override suspend fun searchVideosOrderByViewCount(query: String): SearchVideoResponse {
        return youtubeApi.searchVideosOrderByViewCount(query = query)
    }

    override suspend fun getVideoDetails(id: String): VideoDetailsResponse {
        return youtubeApi.getVideoDetails(id = id)
    }

    override suspend fun getChannelDetails(id: String): ChannelDetailsResponse {
        return youtubeApi.getChannelDetails(id = id)
    }
}