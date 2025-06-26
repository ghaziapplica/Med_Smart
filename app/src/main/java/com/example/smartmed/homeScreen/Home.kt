package com.example.smartmed.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.smartmed.ui.theme.poppinsFamilyFont


@Composable
fun Home(innerPadding: PaddingValues) {
Box (
    modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .background(Color.Black)
){
    Text(
        text = "Home Screen",
        modifier = Modifier.align(Alignment.Center),
        fontFamily = poppinsFamilyFont,
        color = Color(0xFF0077B6),
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
}
}

@Preview
@Composable
fun HomeScreenPreview() {
    Home(
        innerPadding = PaddingValues()
    )
}