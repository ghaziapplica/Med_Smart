package com.example.smartmed.components

import androidx.lifecycle.ViewModel
import com.example.smartmed.bottomBarScreens.HealthTip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HealthTipsViewModel : ViewModel() {
    private val _likedTips = MutableStateFlow<List<HealthTip>>(emptyList())
    val likedTips: StateFlow<List<HealthTip>> = _likedTips

    fun toggleLike(tip: HealthTip) {
        val current = _likedTips.value.toMutableList()
        if (current.contains(tip)) {
            current.remove(tip)
        } else {
            current.add(tip)
        }
        _likedTips.value = current
    }

    fun isLiked(tip: HealthTip): Boolean {
        return _likedTips.value.contains(tip)
    }
}
