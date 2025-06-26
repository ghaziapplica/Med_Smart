package com.example.smartmed

// ProfileSharedViewModel.kt

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileSharedViewModel : ViewModel() {
    private val _profileImageUri = MutableStateFlow<String?>(null)
    val profileImageUri: StateFlow<String?> = _profileImageUri

    private val _profileName = MutableStateFlow<String?>(null)
    val profileName: StateFlow<String?> = _profileName

    fun setProfileImage(uri: String) {
        _profileImageUri.value = uri

    }

    fun setProfileName(name: String) {
        _profileName.value = name

    }
}
