package com.example.riding_balloon.presentation.videodetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.riding_balloon.data.model.VideoDetailsResponse
import com.example.riding_balloon.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoDetailViewModel : ViewModel() {
    private val _videoDetail = MutableLiveData<VideoDetailsResponse>()
    val videoDetail: LiveData<VideoDetailsResponse> get() = _videoDetail

    fun videoDetailsGet(videoId: String) {
        CoroutineScope (Dispatchers.IO).launch {
            val response = RetrofitClient.youtubeApi.getVideoDetails(id = videoId)
            _videoDetail.postValue(response)
        }
    }
}
