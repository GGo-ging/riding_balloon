package com.example.riding_balloon.presentation.model

data class FavoriteVideoInfo(
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val creator: String,
    val isFavorite: Boolean = false
)
