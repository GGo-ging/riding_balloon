package com.example.riding_balloon.data.repository.channel

import android.util.Log
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.network.RetrofitClient.youtubeApi
import com.example.riding_balloon.presentation.home.toListData
import com.example.riding_balloon.presentation.model.ChannelListModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ChannelRepositoryImpl() : ChannelRepository {
    override suspend fun getChannel(id: String): ChannelDetailsResponse {
        return youtubeApi.getChannelDetails(id = id)

    }

    override suspend fun getVideos(): TrendingVideoResponse {
        return youtubeApi.getTrendingVideos()
    }
}

class ChannelUseCase(private val channelRepository: ChannelRepository) {
    suspend fun getData(idList: List<String>): List<ChannelListModel> {
        var list: MutableList<ChannelListModel> = mutableListOf<ChannelListModel>()
        for (i in 0 until idList.size) {
            list.add(channelRepository.getChannel(idList[i]).toListData())
        }
        return list
    }
}