package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.ChannelDetailsResponse
import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailsResponse

interface FavoriteVideoRepository {

    suspend fun getTrendingVideos(): TrendingVideoResponse

    suspend fun searchVideos(query: String): SearchVideoResponse

    suspend fun searchVideosOrderByViewCount(query: String): SearchVideoResponse

    suspend fun getVideoDetails(id: String): VideoDetailsResponse

    suspend fun getChannelDetails(id: String): ChannelDetailsResponse
}