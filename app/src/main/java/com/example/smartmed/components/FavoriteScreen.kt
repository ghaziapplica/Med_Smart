package com.example.smartmed.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartmed.bottomBarScreens.HealthTipCard

@Composable
fun FavoriteTipsScreen(viewModel: HealthTipsViewModel,
                       innerPadding: PaddingValues  ) {
    val likedTips = viewModel.likedTips.collectAsState()
Box(
    modifier = Modifier.fillMaxSize()
        .background(Color.White)
        .padding(16.dp),
contentAlignment = Alignment.Center

){

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 26.dp, top = 10.dp)
                .background(Color.White),
        ) {
            items(likedTips.value) { tip ->
                HealthTipCard(tip = tip, viewModel = viewModel)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}
}

@Composable
@Preview
fun FavoriteTipsScreenPreview() {
    FavoriteTipsScreen(viewModel = HealthTipsViewModel(), innerPadding = PaddingValues())
}