package com.example.riding_balloon.data.repository.channel

import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.network.RetrofitClient.youtubeApi

class ChannelRepositoryImpl : ChannelRepository {
    override suspend fun getChannel(id: String): ChannelDetailsResponse {
        return youtubeApi.getChannelDetails(id = id)
    }

    override suspend fun getVideos(): TrendingVideoResponse {
        return youtubeApi.getTrendingVideos()
    }
}