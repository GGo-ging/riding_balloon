package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class VideoDetailResponse(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("items")
    val items: List<VideoItem>?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?
)
