package com.example.riding_balloon.presentation.travelspotdetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.repository.RelevanceVideoRepository
import com.example.riding_balloon.data.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class TravelSpotDetailViewModel @Inject constructor (
    private val relevantVideoRepository: RelevanceVideoRepository
) : ViewModel() {

    private val _videosData = MutableLiveData<List<VideoListUiModel>>()
    val videosData get() = _videosData

    fun initData() = changeData("")

    fun changeData(keyword: String) = runBlocking {
        viewModelScope.launch {
            var list : List<VideoListUiModel> = listOf()
            list = relevantVideoRepository.videoDataToUiModel("괌" + keyword + "여행")
            _videosData.value = list
            Log.d("ViewModel 데이터", "${videosData.value}")
        }
    }

}