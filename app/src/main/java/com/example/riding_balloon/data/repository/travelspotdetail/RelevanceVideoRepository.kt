package com.example.riding_balloon.data.repository.travelspotdetail

import com.example.riding_balloon.data.repository.VideoRepository
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

interface RelevanceVideoRepository : VideoRepository {
    suspend fun videoDataToUiModel(keyword: String, isNext: Boolean) : List<VideoListUiModel>
}