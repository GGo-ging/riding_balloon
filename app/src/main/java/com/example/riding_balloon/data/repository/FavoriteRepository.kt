package com.example.riding_balloon.data.repository

import com.example.riding_balloon.presentation.model.FavoriteVideoInfo

interface FavoriteRepository {

    val favoriteVideos: List<FavoriteVideoInfo>

    fun addFavoriteVideo(video: FavoriteVideoInfo)

    fun removeFavoriteVideo(video: FavoriteVideoInfo)

    fun removeMultipleFavoriteVideos(videos: List<FavoriteVideoInfo>)

    fun saveFavoriteVideos()

    fun loadFavoriteVideos(): MutableList<FavoriteVideoInfo>

    fun isFavorite(videoId: String): Boolean
}