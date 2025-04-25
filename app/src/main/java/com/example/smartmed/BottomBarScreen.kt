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
        label = "Chat",
        icons = R.drawable.chat,
        selectedIcon = R.drawable.chatfill
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