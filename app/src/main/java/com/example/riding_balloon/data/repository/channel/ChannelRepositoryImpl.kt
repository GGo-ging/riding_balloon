package com.example.riding_balloon.data.repository.channel

import android.util.Log
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.data.source.remote.YoutubeApi
import com.example.riding_balloon.presentation.home.toListData
import com.example.riding_balloon.presentation.model.ChannelListModel
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val youtubeApi: YoutubeApi
) : ChannelRepository {
    override suspend fun getChannel(id: String): ChannelDetailsResponse {
        return youtubeApi.getChannelDetails(id = id)

    }

    override suspend fun getVideos(): TrendingVideoResponse {
        return youtubeApi.getTrendingVideos()
    }
}

class ChannelUseCase @Inject constructor(private val channelRepository: ChannelRepository) {
    suspend fun getData(idList: List<String>): List<ChannelListModel> {
        var list: MutableList<ChannelListModel> = mutableListOf<ChannelListModel>()
        for (i in 0 until idList.size) {
            list.add(channelRepository.getChannel(idList[i]).toListData())
        }
        return list
    }
}