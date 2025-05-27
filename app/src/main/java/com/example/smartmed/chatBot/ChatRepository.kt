package com.example.smartmed.chatBot

import com.example.smartmed.BuildConfig
import retrofit2.Response

class ChatRepository() {
    private val apiKey = BuildConfig.OPENAI_API_KEY
    suspend fun sendMessage(userMessage: String ): Response<ChatResponse> {
        val request = ChatRequest(
            messages = listOf(
                Message(role = "user", content = userMessage)
            )
        )
        return RetrofitInstance.api.getChatResponse(
            auth = "Bearer $apiKey", // ✅ Send API key here correctly
            request = request
        )
    }
}

