package com.example.smartmed.chatBot

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: OpenAiService by lazy {
        retrofit.create(OpenAiService::class.java)
    }
}
