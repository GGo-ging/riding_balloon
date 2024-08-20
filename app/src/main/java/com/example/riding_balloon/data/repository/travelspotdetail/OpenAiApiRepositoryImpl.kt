package com.example.riding_balloon.data.repository.travelspotdetail

import com.example.riding_balloon.data.model.openai.OpenAiApiMessenger

class OpenAiApiRepositoryImpl : OpenAiApiRepository {
    private val openAiApiMessenger = OpenAiApiMessenger()
    override suspend fun getMessageFromAi(keyword: String): String {
        return openAiApiMessenger.fetchAiAnalysisResult(keyword)
    }
}