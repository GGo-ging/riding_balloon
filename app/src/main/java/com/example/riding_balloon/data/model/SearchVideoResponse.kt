package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class SearchVideoResponse(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("nextPageToken")
    val nextPageToken: String?,
    @SerializedName("regionCode")
    val regionCode: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?,
    @SerializedName("items")
    val items: List<ItemSnippet>?
)

data class Id(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("videoId")
    val videoId: String?
)

