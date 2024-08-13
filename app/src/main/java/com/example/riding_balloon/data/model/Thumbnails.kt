package com.example.riding_balloon.data.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("default")
    val default: Thumbnail?,
    @SerializedName("medium")
    val medium: Thumbnail?,
    @SerializedName("high")
    val high: Thumbnail?,
    @SerializedName("standard")
    val standard: Thumbnail?,
    @SerializedName("maxres")
    val maxres: Thumbnail?
)

data class Thumbnail(
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?
)