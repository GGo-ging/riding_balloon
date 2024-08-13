package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class Snippet(
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("channelId")
    val channelId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails?,
    @SerializedName("channelTitle")
    val channelTitle: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String?,
    @SerializedName("defaultLanguage")
    val defaultLanguage: String?,
    @SerializedName("localized")
    val localized: Localized?,
    @SerializedName("defaultAudioLanguage")
    val defaultAudioLanguage: String?
)

data class VideoSnippet(
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("channelId")
    val channelId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails?,
    @SerializedName("channelTitle")
    val channelTitle: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String?,
    @SerializedName("localized")
    val localized: Localized?,
    @SerializedName("defaultAudioLanguage")
    val defaultAudioLanguage: String?
)