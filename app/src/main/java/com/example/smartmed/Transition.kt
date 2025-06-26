package com.example.smartmed

import androidx.compose.animation.animateColorAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable

fun ColorTrans () {
    var isWhite by remember { mutableStateOf(true) }

    val boxColor by animateColorAsState(
        targetValue = if (isWhite) Color.White else Color.Black,
        animationSpec = androidx.compose.animation.core.tween(durationMillis = 1000) // 1 second transition
    )
    LaunchedEffect(Unit) {
        delay(4000)
        isWhite = false
    }
}