package com.example.riding_balloon.data.mapper

import com.example.riding_balloon.data.model.VideoData
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

// TODO : 받아온 데이터들의 조합체로 videoUiModel 로 변환

suspend fun List<VideoData>.toUiModel() : List<VideoListUiModel.TravelVideoModel> {
    return this.map {
        VideoListUiModel.TravelVideoModel(
            id = it.videoId ?: "null",
            videoTitle = it.videoTitle,
            videoUrl = it.videoUrl,
            videoUploader = it.videoUploader,
            videoUploadAt = it.videoUploadAt,
//            videoViewCount = it.videoViewCount,
        )
    }
}