package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String?,
    @SerializedName("likeCount")
    val likeCount: String?,
    @SerializedName("favoriteCount")
    val favoriteCount: String?,
    @SerializedName("commentCount")
    val commentCount: String?
)

data class ChannelStatistics(
    @SerializedName("viewCount")
    val viewCount: String?,
    @SerializedName("subscriberCount")
    val subscriberCount: String?,
    @SerializedName("hiddenSubscriberCount")
    val hiddenSubscriberCount: Boolean?,
    @SerializedName("videoCount")
    val videoCount: String?
)
