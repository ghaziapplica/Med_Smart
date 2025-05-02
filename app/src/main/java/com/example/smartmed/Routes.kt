package com.example.smartmed

object Graph {
    const val RootGraph = "rootGraph"
    const val AuthGraph = "authGraph"
    const val MainScreenGraph = "mainScreenGraph"
}

sealed class AuthRouteScreen(val route: String) {
    object SplashScreen : AuthRouteScreen("splashScreen")
    object WelcomeScreen : AuthRouteScreen("welcomeScreen")
    object LoginScreen : AuthRouteScreen("loginScreen")
    object OtpScreen : AuthRouteScreen("otpScreen")
    object PasswordScreen : AuthRouteScreen("passwordScreen")
    object SignInScreen : AuthRouteScreen("signInScreen")
    object ProfileScreen : AuthRouteScreen("profileScreen")

}
sealed class MainRouteScreen(val route: String){

    object ChatScreen : MainRouteScreen("chatScreen")
    object HeartScreen : MainRouteScreen("heartScreen")
    object AiScreen : MainRouteScreen("aiScreen")
    object MyProfileScreen : MainRouteScreen("profileScreen")
    object HomeScreen : MainRouteScreen("homeScreen")


}