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
    private var nextPageToken : String = ""

    private suspend fun getSearchData(keyword: String) : SearchVideoResponse {
        return youtubeApi.searchVideos(query = keyword)
    }

    private suspend fun getSearchData(keyword: String, nextPageToken: String) : SearchVideoResponse {
        return youtubeApi.searchNextVideos(query = keyword, pageToken = nextPageToken)
    }

    private suspend fun SearchVideoResponse.getNextPageToken() {
        this@VideoSearcher.nextPageToken = this.nextPageToken ?: ""
    }

    suspend fun getSearchDataFromYoutubeApi(keyword: String, isNext: Boolean) : List<VideoData> {
        val searchData = if(!isNext) getSearchData(keyword) else getSearchData(keyword, nextPageToken = nextPageToken)
        searchData.getNextPageToken()
        return searchData.items?.map {
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