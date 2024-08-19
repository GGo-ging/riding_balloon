package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.SearchVideoResponse
import com.example.riding_balloon.presentation.travelspotdetail.VideoListUiModel

interface RelevanceVideoRepository : VideoRepository {
    suspend fun videoDataToUiModel(keyword: String) : List<VideoListUiModel>
}