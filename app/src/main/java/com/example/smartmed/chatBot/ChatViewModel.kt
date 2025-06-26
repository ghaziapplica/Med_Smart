package com.example.smartmed.chatBot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel(private val repository: ChatRepository) : ViewModel() {

    private val _chatMessages = MutableStateFlow<List<Message>>(emptyList())
    val chatMessages = _chatMessages.asStateFlow()

    fun sendMessage(userText: String) {
        viewModelScope.launch {
            _chatMessages.value += Message(role = "user", content = userText) // ✅ Show user text immediately

            try {
                val response = repository.sendMessage(userText)
                if (response.isSuccessful) {
                    val aiMessage = response.body()?.choices?.firstOrNull()?.message
                    aiMessage?.let {
                        _chatMessages.value += it
                    }
                } else {
                    val errorBody = response.errorBody()?.string() ?: "No error body"
                    _chatMessages.value += Message(role = "assistant", content = "Error: ${response.code()} - $errorBody")
                }

            } catch (e: Exception) {
                _chatMessages.value += Message(role = "assistant", content = "Network Error: ${e.localizedMessage}")
                e.printStackTrace() // ✅ print real error in Logcat
            }
        }
    }

}
