package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class TrendingVideoResponse (
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("items")
    val items: List<ItemSnippetStatistics>?,
    @SerializedName("nextPageToken")
    val nextPageToken: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?
)