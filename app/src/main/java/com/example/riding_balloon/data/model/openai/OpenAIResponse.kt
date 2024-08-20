package com.example.riding_balloon.data.model.openai

import com.google.gson.annotations.SerializedName

data class OpenAIResponse(
    @SerializedName("choices")
    val choices: List<Choice?>?,
    @SerializedName("created")
    val created: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("model")
    val model: String?,
    @SerializedName("object")
    val objectX: String?,
    @SerializedName("usage")
    val usage: Usage?
)