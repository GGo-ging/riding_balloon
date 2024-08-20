package com.example.riding_balloon.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.model.ItemSnippetStatistics
import com.example.riding_balloon.data.model.TravelSpotInfo
import com.example.riding_balloon.data.model.TrendingVideoResponse
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.data.repository.channel.ChannelRepository
import com.example.riding_balloon.data.repository.channel.ChannelRepositoryImpl
import com.example.riding_balloon.data.repository.channel.ChannelUseCase
import com.example.riding_balloon.data.source.local.TravelSpotManager
import com.example.riding_balloon.presentation.model.ChannelListModel
import com.example.riding_balloon.presentation.model.PopularVideoListModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import java.util.UUID

fun ChannelDetailsResponse.toListData(): ChannelListModel {
    return ChannelListModel(
        UUID.randomUUID().toString(),
        items?.first()?.snippet?.customUrl ?: "",
        items?.first()?.snippet?.title ?: "",
        items?.first()?.snippet?.thumbnails?.default?.url ?: "",
        items?.first()?.statistics?.subscriberCount ?: "",
    )
}

fun ItemSnippetStatistics.toListData(): PopularVideoListModel {
    return PopularVideoListModel(
        id.toString(),
        snippet?.thumbnails?.standard?.url ?: "",
        snippet?.title ?: "",
        snippet?.channelTitle ?: "",
        statistics?.viewCount.toString(),
        snippet?.publishedAt.toString(),
    )

}

fun TrendingVideoResponse.toListData(): PopularVideoListModel {
    return PopularVideoListModel(
        items?.map { it.id }.toString(),
        items?.map { it.snippet?.thumbnails?.standard?.url }?.get(0) ?: "",
        items?.map { it.snippet?.title }?.get(0) ?: "",
        items?.map { it.snippet?.channelTitle }?.get(0) ?: "",
        items?.map { it.statistics?.viewCount }.toString(),
        items?.map { it.snippet?.publishedAt }.toString(),
    )
}

class HomeViewModel(
    private val channelRepository: ChannelRepository = ChannelRepositoryImpl(),
    private val channelUseCase: ChannelUseCase = ChannelUseCase(ChannelRepositoryImpl()),
) : ViewModel() {
    private val idList = listOf(
        "@JBKWAK",
        "@PaniBottle",
        "@im1G",
        "@soy_the_world",
        "@tripcompany93",
        "@jojocamping",
        "@CHOMAD",
        "@Birdmoi",
        "@kimhanryang97",
        "@YongZinCamp",
        "@sookoh수코",
        "@CHACHABBO_VLOG",
        "@nanajane",
        "@DarongT",
        "@koreanjay",
        "@korea_travel",
        "@chabakchabak",
        "@awesomebackpakers",
        "@Birdmoi",
        "@_davidghc",
    )

    private val _channelList = MutableLiveData<List<ChannelListModel>>()
    val channelList: LiveData<List<ChannelListModel>> = _channelList

    private val _best10List = MutableLiveData<List<TravelSpotInfo>>()
    val best10List: LiveData<List<TravelSpotInfo>> = _best10List

    val jobs = mutableListOf<Job>()

    private val _popularVideoList = MutableLiveData<List<PopularVideoListModel>>()
    val popularVideoList: LiveData<List<PopularVideoListModel>> = _popularVideoList

    fun fetchChannel() {
        val newIdList = idList.shuffled().slice(0..5)
        val currentList = _channelList.value?.toMutableList() ?: mutableListOf()

        //Case 1) Use for문
        viewModelScope.launch {
            val list = channelUseCase.getData(newIdList)

            _channelList.value = list
            Log.d("debug2323", list.size.toString())
        }
        //Case 2) Use Coroutine job
        //
        /*newIdList.forEach { it ->
            val job = viewModelScope.launch {
                runCatching {
                    // 용현 튜터님이 도와주신 코드
                    val fetchResult = async { return@async channelRepository.getChannel(it) }
                    val result = fetchResult.await()
                    currentList.add(result.toListData())
                }.onFailure {
                    Log.e("💡HomeViewModel fetchChannel", "fetchChannel() onFailure: ${it.message}")
                }
            }

            jobs.add(job)
        }

        viewModelScope.launch {
            jobs.joinAll()
            _channelList.value = currentList
        }*/
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
                _popularVideoList.value = filteredResult?.map { it.toListData() }
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