package com.example.smartmed

// ProfileSharedViewModel.kt

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileSharedViewModel : ViewModel() {
    private val _profileImageUri = MutableStateFlow<String?>(null)
    val profileImageUri: StateFlow<String?> = _profileImageUri

    fun setProfileImage(uri: String) {
        _profileImageUri.value = uri

    }
}
