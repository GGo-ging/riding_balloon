package com.example.riding_balloon.useCases

import com.example.riding_balloon.data.mapper.toChannelListData
import com.example.riding_balloon.data.repository.channel.ChannelRepository
import com.example.riding_balloon.presentation.model.ChannelListModel

/*
* Case 2) UseCase를 활용한 해결방법
* */
class ChannelUseCase(
    private val channelRepository: ChannelRepository,
) {
    // 희영 튜터님이 도와주신 코드
    suspend fun getChannelList(idList: List<String>): List<ChannelListModel> {
        var list: MutableList<ChannelListModel> = mutableListOf()
        for (i in idList.indices) {
            list.add(channelRepository.getChannel(idList[i]).toChannelListData())
        }
        return list
    }
}