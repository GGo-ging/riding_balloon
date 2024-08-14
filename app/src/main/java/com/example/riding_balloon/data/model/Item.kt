package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class ItemSnippet(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: Id?,
    @SerializedName("snippet")
    val snippet: Snippet?
)

data class ItemSnippetStatistics(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("snippet")
    val snippet: Snippet?,
    @SerializedName("statistics")
    val statistics: Statistics?
)

data class VideoItem(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("snippet")
    val snippet: VideoSnippet?,
    @SerializedName("statistics")
    val statistics: Statistics?
)

data class ChannelItem(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("snippet")
    val snippet: ChannelSnippet?,
    @SerializedName("statistics")
    val statistics: ChannelStatistics?
)