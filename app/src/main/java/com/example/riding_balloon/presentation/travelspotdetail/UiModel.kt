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
        val isFavorite: Boolean,
    ): UiModel()
    data class TravelVideoListModel(
        override val id: String = UUID.randomUUID().toString()
    ): UiModel()
}

sealed class VideoListUiModel {
    abstract val id: String
    data class TravelVideoModel(
        override val id: String = UUID.randomUUID().toString(),
        val videoUrl: String?,
        val videoTitle: String?,
    ) : VideoListUiModel()
}

data class ViewPagerItemModel(
    val imageUrl: String,
)
