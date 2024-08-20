package com.example.riding_balloon.presentation.model

data class FavoriteVideoInfo(
    val videoId: String,
    val thumbnailUrl: String,
    val title: String,
    val channelTitle: String,
    val publishedAt: String,
    val viewCount: String = "",
)
