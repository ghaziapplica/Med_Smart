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

    object NoteScreen : MainRouteScreen("noteScreen")
    object HeartScreen : MainRouteScreen("heartScreen")
    object AiScreen : MainRouteScreen("aiScreen")
    object MyProfileScreen : MainRouteScreen("profileScreen")
    object HomeScreen : MainRouteScreen("homeScreen")
    object FindScreen : MainRouteScreen("findScreen")
    object NotePopUp : MainRouteScreen("NotePopupScreen")
    object ProfileScreen : MainRouteScreen("profileScreen")
    object DoctorRoutes {
        const val Heart = "cardiologist_screen"
        const val Skin = "dermatologist_screen"
        const val Child = "pediatrician_screen"
        const val Eye = "ophthalmologist_screen"
        const val Psych = "psychiatrist_screen"
        const val Ortho = "orthopedic_screen"
        const val Gyno = "gynecologist_screen"
        const val Dental = "dentist_screen"
        const val DoctorList = "doctor_list"

    }




}