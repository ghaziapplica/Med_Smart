package com.example.smartmed.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartmed.Graph
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.bottomBarScreens.HomeScreen
import com.example.smartmed.chatBot.ChatRepository
import com.example.smartmed.chatBot.ChatScreen
import com.example.smartmed.chatBot.ChatViewModel
import com.example.smartmed.homeScreen.ChatHistoryScreen
import com.example.smartmed.homeScreen.FavoriteScreen
import com.example.smartmed.homeScreen.MyProfileScreen


@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.HomeScreen.route
    ) {
        composable(route = MainRouteScreen.HomeScreen.route) {
            HomeScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.ChatScreen.route) {
            ChatHistoryScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.HeartScreen .route) {
            FavoriteScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.MyProfileScreen .route) {
            MyProfileScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.AiScreen .route) {
            ChatScreen(
                viewModel = ChatViewModel(ChatRepository("YOUR_API_KEY")),
                innerPadding = innerPadding
            )
        }
    }
}