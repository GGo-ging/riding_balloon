package com.example.riding_balloon.data.mapper

import com.example.riding_balloon.data.model.ItemSnippetStatistics
import com.example.riding_balloon.presentation.model.PopularVideoListModel

fun ItemSnippetStatistics.toVideoListData(): PopularVideoListModel {
    return PopularVideoListModel(
        id.toString(),
        snippet?.thumbnails?.standard?.url ?: "",
        snippet?.title ?: "",
        snippet?.channelTitle ?: "",
        statistics?.viewCount.toString(),
        snippet?.publishedAt.toString(),
    )

}