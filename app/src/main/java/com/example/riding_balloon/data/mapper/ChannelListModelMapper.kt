package com.example.riding_balloon.data.mapper

import com.example.riding_balloon.data.model.channel.ChannelDetailsResponse
import com.example.riding_balloon.presentation.model.ChannelListModel
import java.util.UUID

fun ChannelDetailsResponse.toChannelListData(): ChannelListModel {
    return ChannelListModel(
        UUID.randomUUID().toString(),
        items?.first()?.snippet?.customUrl ?: "",
        items?.first()?.snippet?.title ?:"",
        items?.first()?.snippet?.thumbnails?.default?.url ?:"",
        items?.first()?.statistics?.subscriberCount ?: "",
    )
}