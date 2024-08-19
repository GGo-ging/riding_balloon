package com.example.riding_balloon.presentation.mypage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.model.ChannelSnippet
import com.example.riding_balloon.data.model.ItemSnippet
import com.example.riding_balloon.data.model.ItemSnippetStatistics
import com.example.riding_balloon.data.model.VideoSnippet
import com.example.riding_balloon.data.repository.FavoriteVideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteVideoViewModel @Inject constructor (
    private val repository: FavoriteVideoRepository
) : ViewModel() {
    private val _trendingResult = MutableLiveData<List<ItemSnippetStatistics>?>()
    val trendingResult: LiveData<List<ItemSnippetStatistics>?> = _trendingResult

    private val _searchResult = MutableLiveData<List<ItemSnippet>?>()
    val searchResult: LiveData<List<ItemSnippet>?> = _searchResult

    private val _searchResultOrderByViewCount = MutableLiveData<List<ItemSnippet>?>()
    val searchResultOrderByViewCount: LiveData<List<ItemSnippet>?> = _searchResultOrderByViewCount

    private val _videoDetail = MutableLiveData<VideoSnippet?>()
    val videoDetail: LiveData<VideoSnippet?> = _videoDetail

    private val _channelDetail = MutableLiveData<ChannelSnippet?>()
    val channelDetail: LiveData<ChannelSnippet?> = _channelDetail

    fun fetchSearchResult(query: String, page: Int = 1) {
        viewModelScope.launch {
            runCatching {
//                val searchResult = repository.searchVideos(query)
//                _searchResult.value = searchResult.items

                val trendingResult = repository.getTrendingVideos()
                _trendingResult.value = trendingResult.items?.filter { it.snippet?.categoryId == "19" }

//                val trendingResult = repository.getTrendingVideos()
//                val categoryFiltered = trendingResult.items?.filter { it.snippet?.categoryId == "19" }
//                val tagFiltered = trendingResult.items?.filter { it.snippet?.tags?.contains("여행") == true }
//                val combinedResults = (categoryFiltered.orEmpty() + tagFiltered.orEmpty()).distinctBy { it.id }
//                _trendingResult.value = combinedResults

//                val searchResultOrderByViewCount = repository.searchVideosOrderByViewCount(query)
//                _searchResultOrderByViewCount.value = searchResultOrderByViewCount.items

                val videoDetail = repository.getVideoDetails("lvjvjhcpES4")
                _videoDetail.value = videoDetail.items?.first()?.snippet

                val channelDetail = repository.getChannelDetails("UCNhofiqfw5nl-NeDJkXtPvw")
                _channelDetail.value = channelDetail.items?.first()?.snippet
            }.onFailure {
                Log.e("FavoriteVideoViewModel", "fetchSearchResult() onFailure: ${it.message}")
            }
        }
    }
}