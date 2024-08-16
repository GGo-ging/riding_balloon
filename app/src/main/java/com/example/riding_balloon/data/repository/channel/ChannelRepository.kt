package com.example.riding_balloon.data.repository.channel

import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse

interface ChannelRepository {
    suspend fun getChannel(id: String): ChannelDetailsResponse
}