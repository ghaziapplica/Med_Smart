package com.example.smartmed

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartmed.authScreen.EditProfileViewModel
import com.example.smartmed.chatBot.ChatRepository
import com.example.smartmed.chatBot.ChatScreen
import com.example.smartmed.chatBot.ChatViewModel
import com.example.smartmed.graphs.RootNavGraph
import com.example.smartmed.homeScreen.EditProfileScreen
import com.example.smartmed.ui.theme.SmartMedTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = ChatRepository()
        val viewModel = ChatViewModel(repository)
        val profileSharedViewModel: ProfileSharedViewModel by viewModels()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartMedTheme {

//                SplashScreen()
//                WelcomeScreen()
//                LoginScreen()
//                OtpScreen()
//                PasswordScreen()
//                SignInScreen()
//                ProfileScreen()
//                MainScreen()
                RootNavGraph(
                    isAuth = false,
                )
//                EditProfileScreen(
//                    viewModel = EditProfileViewModel(),
//                    innerPadding = PaddingValues()
//                )
            }
        }
    }
}

