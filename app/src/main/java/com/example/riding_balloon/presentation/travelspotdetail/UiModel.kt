package com.example.riding_balloon.presentation.travelspotdetail

sealed class UiModel {
    data class ImageModel(
        val imageUrlList: List<String>,
    ): UiModel()
    data class NationModel(
        val nation: String,
        val city: String,
        val desc: String,
    ): UiModel()
//    data class NationTitleModel(
//        val nation: String,
//        val city: String,
//    ): UiModel()
//    data class NationDescModel(
//        val desc: String,
//    ): UiModel()
    data class TravelChipsModel(
        val title: String,
        val chipList: List<String>,
    ): UiModel()
    class TravelVideoListModel: UiModel()
    data class TravelVideoModel(
        val videoUrl: String?,
        val videoTitle: String?,

    ): TravelVideoListModel()
}