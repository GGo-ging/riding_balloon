package com.example.riding_balloon.data.model

import com.example.riding_balloon.data.source.remote.YoutubeApi
import javax.inject.Inject

data class VideoData(
    val videoId: String?,
    val videoUrl: String?,
    val videoTitle: String?,
    val videoUploader: String?,
    val videoViewCount: String?,
)

class VideoSearcher(private val youtubeApi: YoutubeApi) {

    suspend fun getSearchDataFromYoutubeApi(keyword: String) : List<VideoData> {
        return youtubeApi.searchVideos(query = keyword).items?.map {
            VideoData(
                videoId = it.id?.videoId,
                videoUrl = it.snippet?.thumbnails?.medium?.url,
                videoUploader = it.snippet?.channelTitle,
                videoTitle = it.snippet?.title,
                videoViewCount = getVideoDataFromYoutubeApi(videoId = it.id?.videoId)
            )
        } ?: listOf()
    }

    private suspend fun getVideoDataFromYoutubeApi(videoId: String?) : String {
        return if (videoId != null) {
            youtubeApi.getVideoDetails(id = videoId).items?.first()?.statistics?.viewCount ?: "0"
        } else {
            "0"
        }
    }

}