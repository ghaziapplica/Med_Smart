package com.example.smartmed.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.Graph
import com.example.smartmed.ProfileSharedViewModel
import com.example.smartmed.ViewModel.AuthViewModel
import com.example.smartmed.authScreen.ProfileScreen
import com.example.smartmed.authScreen.LoginScreen
import com.example.smartmed.authScreen.OtpScreen
import com.example.smartmed.authScreen.PasswordScreen
import com.example.smartmed.authScreen.ProfileViewModel
import com.example.smartmed.authScreen.SignInScreen
import com.example.smartmed.authScreen.SplashScreen
import com.example.smartmed.authScreen.WelcomeScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController,
                                 profileSharedViewModel: ProfileSharedViewModel) {
    navigation(
        route = Graph.AuthGraph,
        startDestination = AuthRouteScreen.SplashScreen.route
    ) {
        composable(route = AuthRouteScreen.SplashScreen.route) {
            SplashScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.WelcomeScreen .route) {
            WelcomeScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.LoginScreen .route) {
            LoginScreen(navController = rootNavController,
                )
        }
        composable(route = AuthRouteScreen.OtpScreen .route) {
            OtpScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.PasswordScreen .route) {
            PasswordScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.SignInScreen .route) {
            SignInScreen(navController = rootNavController,
                onTextSelected = {}
            )
        }
        composable(route = AuthRouteScreen.ProfileScreen .route) {
            ProfileScreen(navController = rootNavController,
                viewModel = ProfileViewModel(),
                viewSharedModel = profileSharedViewModel
            )
        }



    }
}