package com.example.smartmed


sealed class BottomBarScreen (
    val route: String,
    val label: String,
    val icons: Int,
    val selectedIcon: Int,
)
{
    data object Home : BottomBarScreen(
        route = MainRouteScreen.HomeScreen.route,
        label = "Home",
        icons = R.drawable.home,
        selectedIcon = R.drawable.homefill,
        )
    data object Chat : BottomBarScreen(
        route = MainRouteScreen.ChatScreen.route,
        label = "History",
        icons = R.drawable.history,
        selectedIcon = R.drawable.historyclicked)
    data object Ai : BottomBarScreen(
        route = MainRouteScreen.AiScreen.route,
        label = "",
        icons = R.drawable.ai,
        selectedIcon = R.drawable.ai,
    )
    data object Heart : BottomBarScreen(
        route = MainRouteScreen.HeartScreen.route,
        label = "Heart",
        icons = R.drawable.heart,
        selectedIcon = R.drawable.heartfill,
    )
    data object Profile : BottomBarScreen(
        route = MainRouteScreen.MyProfileScreen.route,
        label = "MyProfile",
        icons = R.drawable.profile,
        selectedIcon = R.drawable.profilefilled,
    )

}