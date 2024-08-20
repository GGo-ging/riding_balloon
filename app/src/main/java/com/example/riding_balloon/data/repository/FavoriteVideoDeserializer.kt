package com.example.riding_balloon.data.repository

import com.example.riding_balloon.presentation.model.FavoriteVideoInfo
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class FavoriteVideoDeserializer : JsonDeserializer<FavoriteVideoInfo> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): FavoriteVideoInfo {
        val jsonObject = json.asJsonObject
        val videoId = jsonObject.get("videoId").asString
        val thumbnailUrl = jsonObject.get("thumbnailUrl").asString
        val title = jsonObject.get("title").asString
        val channelTitle = jsonObject.get("channelTitle").asString
        val publishedAt = jsonObject.get("publishedAt").asString
        val viewCount = jsonObject.get("viewCount").asString
        return FavoriteVideoInfo(
            videoId = videoId,
            thumbnailUrl = thumbnailUrl,
            title = title,
            channelTitle = channelTitle,
            publishedAt = publishedAt,
            viewCount = viewCount
        )
    }
}