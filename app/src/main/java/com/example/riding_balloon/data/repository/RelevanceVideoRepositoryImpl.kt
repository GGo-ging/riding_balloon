package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.mapper.toUiModel
import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.VideoDetailsResponse
import com.example.riding_balloon.data.model.VideoSearcher
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.data.source.remote.YoutubeApi
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel
import javax.inject.Inject

class RelevanceVideoRepositoryImpl @Inject constructor(private val youtubeApi: YoutubeApi) : RelevanceVideoRepository {
    private val videoSearcher: VideoSearcher = VideoSearcher(youtubeApi)

    override suspend fun videoDataToUiModel(keyword: String) : List<VideoListUiModel> {
        return videoSearcher.getSearchDataFromYoutubeApi(keyword).toUiModel()
    }

    override suspend fun getTrendingVideos(): TrendingVideoResponse = youtubeApi.getTrendingVideos()

    override suspend fun searchVideos(query: String): SearchVideoResponse = youtubeApi.searchVideos(query = query)

    override suspend fun getVideoDetails(id: String): VideoDetailsResponse = youtubeApi.getVideoDetails(id = id)

    override suspend fun getChannelDetails(id: String): ChannelDetailsResponse = youtubeApi.getChannelDetails(id = id)
}