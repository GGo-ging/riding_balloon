package com.example.riding_balloon.data.model.openai

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("role")
    val role: String?,
    @SerializedName("content")
    val content: String?
)