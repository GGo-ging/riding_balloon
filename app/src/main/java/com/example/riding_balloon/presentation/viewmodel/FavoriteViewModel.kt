package com.example.riding_balloon.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.riding_balloon.data.repository.FavoriteRepository
import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: FavoriteRepository
) : ViewModel() {

    private val _favoriteVideos = MutableLiveData<List<FavoriteVideoInfo>>()
    val favoriteVideos: LiveData<List<FavoriteVideoInfo>> get() = _favoriteVideos

    init {
        _favoriteVideos.value = repository.loadFavoriteVideos()
    }

    fun addFavoriteItem(item: FavoriteVideoInfo) {
        repository.addFavoriteVideo(item)
        _favoriteVideos.value = repository.favoriteVideos
    }

    fun removeFavoriteItem(item: FavoriteVideoInfo) {
        Log.d("FavoriteViewModel", "removeFavoriteItem() item: $item")
        repository.removeFavoriteVideo(item)
        _favoriteVideos.value = repository.favoriteVideos
    }

    fun removeMultipleFavoriteItems(items: List<FavoriteVideoInfo>) {
        repository.removeMultipleFavoriteVideos(items)
        _favoriteVideos.value = repository.favoriteVideos
    }

    fun saveFavoriteVideos() {
        repository.saveFavoriteVideos()
    }

    fun isFavorite(videoId: String): Boolean {
        Log.d("FavoriteViewModel", "isFavorite() videoId: $videoId")
        return repository.isFavorite(videoId)
    }
}