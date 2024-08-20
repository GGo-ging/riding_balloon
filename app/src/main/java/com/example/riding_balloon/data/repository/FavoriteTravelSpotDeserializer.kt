package com.example.riding_balloon.data.repository

import com.example.riding_balloon.data.model.TravelSpotInfo

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class FavoriteTravelSpotDeserializer : JsonDeserializer<TravelSpotInfo> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TravelSpotInfo {
        val jsonObject = json.asJsonObject
        val id = jsonObject.get("id").asInt
        val thumbnailUrl = jsonObject.get("thumbnailUrl").asString
        val country = jsonObject.get("country").asString
        val region = jsonObject.get("region").asString
        val description = jsonObject.get("description").asString

        // images를 JsonArray로 받아서 List<String>으로 변환
        val imagesJsonArray = jsonObject.getAsJsonArray("images")
        val images = imagesJsonArray.map { it.asString }

        val ranking = jsonObject.get("ranking").asInt
        return TravelSpotInfo(
            id = id,
            thumbnailUrl = thumbnailUrl,
            country = country,
            region = region,
            description = description,
            images = images,
            ranking = ranking
        )
    }
}