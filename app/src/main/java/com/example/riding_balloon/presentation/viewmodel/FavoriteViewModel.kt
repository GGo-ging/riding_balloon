package com.example.riding_balloon.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.riding_balloon.data.repository.FavoriteRepository
import com.example.riding_balloon.data.repository.FavoriteRepositoryImpl
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

    fun addBookmarkItem(item: FavoriteVideoInfo) {
        repository.addFavoriteVideo(item)
        _favoriteVideos.value = repository.favoriteVideos
    }

    fun removeBookmarkItem(item: FavoriteVideoInfo) {
        repository.removeFavoriteVideo(item)
        _favoriteVideos.value = repository.favoriteVideos
    }

    fun saveBookmarks() {
        repository.saveFavoriteVideos()
    }
}