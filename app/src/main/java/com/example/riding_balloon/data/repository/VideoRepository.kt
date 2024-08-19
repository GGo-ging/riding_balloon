package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailsResponse
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse

interface VideoRepository {
    suspend fun getTrendingVideos(): TrendingVideoResponse

    suspend fun searchVideos(query: String): SearchVideoResponse

    suspend fun getVideoDetails(id: String): VideoDetailsResponse

    suspend fun getChannelDetails(id: String): ChannelDetailsResponse
}