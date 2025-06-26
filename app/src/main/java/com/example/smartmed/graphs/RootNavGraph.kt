package com.example.smartmed.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartmed.Graph
import com.example.smartmed.MainScreen
import com.example.smartmed.ProfileSharedViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun  RootNavGraph(isAuth : Boolean) {
    val rootNavController = rememberNavController()
    val profileSharedViewModel: ProfileSharedViewModel = viewModel()

    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph,
        startDestination = if (isAuth) Graph.MainScreenGraph else Graph.AuthGraph
    ) {
        authNavGraph(rootNavController = rootNavController,
            profileSharedViewModel = profileSharedViewModel
            )
        composable(route = Graph.MainScreenGraph){
            MainScreen(
                rootNavHostController = rootNavController,
                profileSharedViewModel = profileSharedViewModel
            )
        }
    }
}