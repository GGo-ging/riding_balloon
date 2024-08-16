package com.example.riding_balloon.data.model.channel

import com.example.riding_balloon.data.model.ChannelItem
import com.example.riding_balloon.data.model.PageInfo
import com.google.gson.annotations.SerializedName

data class ChannelDetailsResponse(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?,
    @SerializedName("items")
    val items: List<ChannelItem>?
)
