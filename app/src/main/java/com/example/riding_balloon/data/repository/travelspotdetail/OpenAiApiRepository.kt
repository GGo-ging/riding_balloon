package com.example.riding_balloon.data.repository.travelspotdetail

interface OpenAiApiRepository {
    suspend fun getMessageFromAi(keyword: String) : String
}