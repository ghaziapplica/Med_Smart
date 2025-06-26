package com.example.smartmed

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartmed.homeScreen.Home

@Composable
fun BottomNavGraph(navController: NavHostController, paddings: PaddingValues) {
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route) { Home( paddings) }
        composable(route = BottomBarScreen.Chat.route) { /* Your Chat Screen Composable Here */ }
        composable(route = BottomBarScreen.Ai.route) { /* Your Profile Screen Composable Here */ }
        composable(route = BottomBarScreen.Heart.route) { /* Your Heart Screen Composable Here */ }
        composable(route = BottomBarScreen.Profile.route) { /* Your Profile Screen Composable Here */ }
    }
}