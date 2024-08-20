package com.example.riding_balloon.data.model.openai

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.riding_balloon.network.RetrofitClient
import kotlinx.coroutines.launch

class OpenAiApiMessenger {
    private fun createAiRequest(text: String): OpenAIRequest {
        return OpenAIRequest(
            messages = listOf(
                Message(
                    "user",
                    "갈 곳: $text"
                ),
                Message(
                    "system",
                    "너는 이제부터 여행 계획을 짜주는 사람이야. " +
                            "여행 갈 곳은 내가 입력해줄게, 기간이나 선호 장소는 따로 입력이 없으면," +
                            "너가 임의로 적절하게 지정해서 만들어줘." +
                            "그리고 20초 안에 답할 수 있도록 작성해줘"
                )
            )
        )
    }

    suspend fun fetchAiAnalysisResult(text: String) : String {
        return RetrofitClient.openAiApi.createChatCompletion(createAiRequest(text)).choices?.get(0)?.message?.content ?: "AI가 잠시 쉬는 중입니다..."
    }
}