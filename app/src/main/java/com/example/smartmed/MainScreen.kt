package com.example.smartmed

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smartmed.graphs.MainNavGraph

@Composable
fun MainScreen(
    rootNavHostController: NavHostController,
    homeNavController : NavHostController = rememberNavController()
) {
    Scaffold (
        bottomBar = { BottomBar(navController = homeNavController) }
    ) { innerPadding ->
        MainNavGraph(
            rootNavHostController,
            homeNavController, innerPadding
        )
    }

}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Chat,
        BottomBarScreen.Heart,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
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
    NavigationBarItem(
       label = {
           Text(text = screen.label)
       },
        icon = {
            Icon(
                painter = painterResource(id = if (isSelected) screen.selectedIcon else screen.icons), // Show selected icon if active
                contentDescription = "navigation"
            )
        },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}

@Composable
@Preview
fun MainScreenPreview() {
    MainScreen(
        rootNavHostController = rememberNavController(),
        homeNavController = rememberNavController()
    )
}
