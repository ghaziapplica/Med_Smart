package com.example.smartmed.chatBot

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.Header

interface OpenAiService {
    @POST("chat/completions") // ✅ Correct

    suspend fun getChatResponse(
        @Header("Authorization") auth: String, // Pass API key here!
        @Body request: ChatRequest
    ): Response<ChatResponse>
}


