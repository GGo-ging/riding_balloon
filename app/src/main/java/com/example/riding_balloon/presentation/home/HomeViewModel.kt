package com.example.riding_balloon.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.mapper.toVideoListData
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.repository.channel.ChannelRepository
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.presentation.model.ChannelListModel
import com.example.riding_balloon.presentation.model.PopularVideoListModel
import com.example.riding_balloon.useCases.ChannelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val channelRepository: ChannelRepository,
    private val channelUseCase: ChannelUseCase
) : ViewModel() {
    private val idList = listOf(
        "@JBKWAK", "@PaniBottle", "@im1G", "@soy_the_world", "@tripcompany93", "@jojocamping", "@CHOMAD", "@Birdmoi", "@kimhanryang97", "@YongZinCamp",
        "@sookoh수코", "@CHACHABBO_VLOG", "@nanajane", "@DarongT", "@koreanjay", "@korea_travel", "@chabakchabak", "@awesomebackpakers", "@Birdmoi", "@_davidghc",
    )

    private val _channelList = MutableLiveData<List<ChannelListModel>>()
    val channelList: LiveData<List<ChannelListModel>> = _channelList

    private val _best10List = MutableLiveData<List<TravelSpotInfo>>()
    val best10List: LiveData<List<TravelSpotInfo>> = _best10List

    private val _popularVideoList = MutableLiveData<List<PopularVideoListModel>>()
    val popularVideoList: LiveData<List<PopularVideoListModel>> = _popularVideoList

    // 튜터님 제안 코드 예시 : https://kkevido.tistory.com/71
    fun fetchChannel() {
        val newIdList = idList.shuffled().slice(0..5)
        viewModelScope.launch {
            val list = channelUseCase.getChannelList(newIdList)
            _channelList.value = list
        }
    }

    fun getBest10List() {
        val rankingList = TravelSpotManager.getListByRanking()
        _best10List.value = rankingList
    }

    fun fetchPopularVideoList() {
        viewModelScope.launch {
            runCatching {
                val fetchResult = async { return@async channelRepository.getVideos() }
                val result = fetchResult.await()
                val filteredResult = result.items?.filter { it.snippet?.categoryId == "19" }
                _popularVideoList.value = filteredResult?.map { it.toVideoListData() }
            }.onFailure {
                Log.e(
                    "💡HomeViewModel",
                    "fetchPopularVideoList() onFailure: ${it.message}"
                )
            }
        }
    }

    fun clearList() {
        _channelList.value = listOf()
        _best10List.value = listOf()
        _popularVideoList.value = listOf()
    }
}