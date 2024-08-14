package com.example.riding_balloon.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.data.repository.channel.ChannelRepository
import com.example.riding_balloon.data.repository.channel.ChannelRepositoryImpl
import com.example.riding_balloon.presentation.model.ChannelListModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.UUID

fun ChannelDetailsResponse.toListData(): ChannelListModel {
    return ChannelListModel(
            UUID.randomUUID().toString(),
            items?.first()?.snippet?.title ?:"",
            items?.first()?.snippet?.thumbnails?.default?.url ?:"",
            items?.first()?.statistics?.subscriberCount ?: "",
        )
}

class HomeViewModel(
    private val repository: ChannelRepository =  ChannelRepositoryImpl()
): ViewModel() {
    private val idList = listOf(
        "@JBKWAK", "@PaniBottle", "@im1G", "@soy_the_world", "@tripcompany93", "@jojocamping", "@CHOMAD", "@Birdmoi", "@kimhanryang97", "@YongZinCamp",
        "@sookoh수코", "@CHACHABBO_VLOG", "@nanajane", "@DarongT", "@koreanjay", "@korea_travel", "@chabakchabak", "@awesomebackpakers", "@Birdmoi", "@_davidghc",
    )

    private val _channelList = MutableLiveData<List<ChannelListModel>>()
    val channelList: LiveData<List<ChannelListModel>> = _channelList

    fun fetchChannel(){
        val newIdList = idList.shuffled().slice(0..5)
        val currentList = _channelList.value?.toMutableList() ?: mutableListOf()

        newIdList.forEach { it ->
            viewModelScope.launch {
                runCatching {
                    // 용현 튜터님이 도와주신 코드
                    val fetchResult = async { return@async repository.getChannel(it) }
                    val result = fetchResult.await()
                    currentList.add(result.toListData())
                    _channelList.value = currentList
                }.onFailure {
                    Log.e("💡HomeViewModel", "fetchChannelResult() onFailure: ${it.message}")
                }
            }
        }
    }

    fun fetchChannelList(){ }
}