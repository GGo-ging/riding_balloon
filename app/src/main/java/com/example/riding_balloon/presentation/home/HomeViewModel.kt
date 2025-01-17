package com.example.riding_balloon.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.mapper.toChannelListData
import com.example.riding_balloon.data.mapper.toVideoListData
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.repository.channel.ChannelRepository
import com.example.riding_balloon.data.repository.channel.ChannelRepositoryImpl
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.presentation.model.ChannelListModel
import com.example.riding_balloon.presentation.model.PopularVideoListModel
import com.example.riding_balloon.useCases.ChannelUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class HomeViewModel(
    private val channelRepository: ChannelRepository = ChannelRepositoryImpl(),
    private val channelUseCase: ChannelUseCase = ChannelUseCase(ChannelRepositoryImpl())
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

    /*
    * Case1) Job을 활용한 해결방법
    * */
    val jobs = mutableListOf<Job>()

    fun fetchChannel() {
        val newIdList = idList.shuffled().slice(0..5)

        // Case2
        // Case2를 활용한 이유는 -> 비즈니스 로직 분리를 위해
        viewModelScope.launch {
            val list = channelUseCase.getChannelList(newIdList)
            _channelList.value = list
        }


        // Case1 -> Coroutine Job 활용법
//        val currentList = _channelList.value?.toMutableList() ?: mutableListOf()
//        newIdList.forEach { it ->
//            val job = viewModelScope.launch {
//                runCatching {
//                    // 용현 튜터님이 도와주신 코드
//                    val fetchResult = async { return@async channelRepository.getChannel(it) }
//                    val result = fetchResult.await()
//                    currentList.add(result.toChannelListData())
//                    _channelList.value = currentList
//                }.onFailure {
//                    Log.e("💡HomeViewModel fetchChannel", "fetchChannel() onFailure: ${it.message}")
//                }
//            }
//
//            jobs.add(job)
//        }
//
//        viewModelScope.launch {
//            jobs.joinAll()
//            _channelList.value = currentList
//        }
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
                    "💡HomeViewModel fetchPopularVideoList",
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