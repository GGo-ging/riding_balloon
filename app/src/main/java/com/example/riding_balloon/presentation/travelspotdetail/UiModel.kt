package com.example.riding_balloon.presentation.travelspotdetail

import com.example.riding_balloon.presentation.travelspotdetail.UiModel.TravelVideoListModel
import java.util.UUID

sealed class UiModel {
    abstract val id: String
    data class ViewPagerModel(
        override val id: String = UUID.randomUUID().toString(),
        val imageUrlList: List<String>,
    ): UiModel()
    data class InfoModel(
        override val id: String = UUID.randomUUID().toString(),
        val nation: String,
        val city: String,
        val desc: String,
    ): UiModel()
    data class ChipGroupModel(
        override val id: String = UUID.randomUUID().toString(),
        val city: String,
    ) : UiModel()
    data class TravelVideoListModel(
        override val id: String = UUID.randomUUID().toString(),
        val videoList : List<VideoListUiModel>
    ): UiModel()
    data class VideoListLoadingUiModel (
        override val id: String = "loading",
    ): UiModel()
}

sealed class VideoListUiModel {
    abstract val id: String?
    data class TravelVideoModel(
        override val id: String = "",
//        val videoId: String?,
        val videoUrl: String?,
        val videoTitle: String?,
        val videoUploader: String?,
        val videoViewCount: String?,
    ) : VideoListUiModel()
}

data class ViewPagerItemModel(
    val imageUrl: String,
)
