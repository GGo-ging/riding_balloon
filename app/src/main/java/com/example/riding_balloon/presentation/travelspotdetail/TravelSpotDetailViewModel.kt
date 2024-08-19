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

    private var videoKeyword : String = ""

    fun initData() {
        isScrollCoroutineRunning = true
        changeData("", false)
    }

    fun addData() {
        changeData(videoKeyword, true)
    }

    fun changeData(keyword: String, isNext: Boolean) = runBlocking {
        viewModelScope.launch {
            changeKeyword(keyword)
            var list : MutableList<VideoListUiModel> = videosData.value?.map { it }?.toMutableList() ?: mutableListOf()
            val uiModelList = relevantVideoRepository.videoDataToUiModel(
                keyword = "괌" + videoKeyword + "여행",
                isNext = isNext
            )
            if(!isNext) {
                list = uiModelList.toMutableList()
            } else {
                list.addAll(uiModelList)
            }
            _videosData.value = list
            Log.d("ViewModel 데이터", "사이즈: ${videosData.value?.size} 리스트: ${videosData.value}")
            Log.d("ViewModel 데이터", "${videosData.value?.filterIsInstance<VideoListUiModel.TravelVideoModel>()?.map { it.id }}")
            isScrollCoroutineRunning = false
        }
    }

    private fun changeKeyword(keyword: String) {
        videoKeyword = keyword
    }

}