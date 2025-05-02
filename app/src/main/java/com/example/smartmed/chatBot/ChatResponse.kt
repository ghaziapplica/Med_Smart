package com.example.smartmed.chatBot

data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
