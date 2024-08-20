package com.example.riding_balloon.data.repository.channel

import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import kotlinx.coroutines.flow.Flow

interface ChannelRepository {
    suspend fun getChannel(id: String): ChannelDetailsResponse

    suspend fun getVideos(): TrendingVideoResponse
}