package com.example.smartmed

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartmed.chatBot.ChatRepository
import com.example.smartmed.chatBot.ChatScreen
import com.example.smartmed.chatBot.ChatViewModel
import com.example.smartmed.graphs.RootNavGraph
import com.example.smartmed.ui.theme.SmartMedTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = ChatRepository(apiKey = "Bearer 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")
        val viewModel = ChatViewModel(repository)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartMedTheme {
//                ChatScreen(viewModel = ChatViewModel(ChatRepository("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")))

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
            }
        }
    }
}

