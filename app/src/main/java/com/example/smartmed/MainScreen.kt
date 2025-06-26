package com.example.smartmed

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smartmed.graphs.MainNavGraph

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    rootNavHostController: NavHostController,
    homeNavController : NavHostController = rememberNavController(),
    profileSharedViewModel: ProfileSharedViewModel
) {
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            // ✅ Only show bottom bar if route is NOT AI screen
            if (currentRoute != BottomBarScreen.Ai.route) {
                BottomBar(navController = homeNavController)
            }
        }
    ) { innerPadding ->
        MainNavGraph(
            rootNavHostController,
            homeNavController,
            innerPadding,
            profileSharedViewModel = profileSharedViewModel

        )
    }
 
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Chat,
        BottomBarScreen.Ai,
        BottomBarScreen.Heart,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White, // Custom blue or any color
        tonalElevation = 10.dp
    ) {
        screens.forEach { screen ->
            AddItem(screen = screen,
                currentDestination = currentDestination,
                navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val isSelected = currentDestination?.route == screen.route
    val iconSize = if (screen.route == BottomBarScreen.Ai.route) 66.dp else 30.dp

    NavigationBarItem(
        label = {
            Text(text = screen.label)
        },
        icon = {
            val iconSize = if (screen.route == BottomBarScreen.Ai.route) 66.dp else 30.dp
            Icon(
                painter = painterResource(id = if (isSelected) screen.selectedIcon else screen.icons),
                contentDescription = "navigation",
                modifier = Modifier.size(iconSize),
                tint = Color.Unspecified
            )
        },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent // ✅ Remove gray background on selection
        )
    )

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun MainScreenPreview() {
    MainScreen(
        rootNavHostController = rememberNavController(),
        homeNavController = rememberNavController(),
        profileSharedViewModel = ProfileSharedViewModel()
    )
}
