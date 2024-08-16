package com.example.riding_balloon.presentation.extensions

import com.example.riding_balloon.data.model.VideoItem
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo

fun VideoItem.toFavoriteVideoInfo(isFavorite: Boolean): FavoriteVideoInfo {
    return FavoriteVideoInfo(
        videoId = id ?: "",
        thumbnailUrl = snippet?.thumbnails?.standard?.url ?: "",
        title = snippet?.title ?: "",
        channelTitle = snippet?.channelTitle ?: "",
        publishedAt = snippet?.publishedAt ?: "",
        viewCount = statistics?.viewCount ?: "",
        isFavorite = isFavorite
    )
}