package com.example.smartmed.authScreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.R
import com.example.smartmed.ColorTrans
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var isWhite by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }
    val boxColor by animateColorAsState(
        targetValue = if (isWhite) Color(0xFFCAF0F8) else Color.White,
        animationSpec = androidx.compose.animation.core.tween(durationMillis = 1000)
    )

    // Check login status
    LaunchedEffect(Unit) {
        delay(2500) // splash delay
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            navController.navigate(MainRouteScreen.MyProfileScreen.route) {
                popUpTo(AuthRouteScreen.SplashScreen.route) { inclusive = true }
            }
        } else {
            navController.navigate(AuthRouteScreen.WelcomeScreen.route) {
                popUpTo(AuthRouteScreen.SplashScreen.route) { inclusive = true }
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = boxColor)
    ) {
        ColorTrans()
        Spacer(modifier = Modifier.size(150.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(25.dp))
        if (isLoading) {
            CircularProgressIndicator(color = Color.Blue,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        }
        Button(
            onClick = {  isLoading = true  },
            colors = ButtonDefaults.buttonColors(Color(0xFF0077B6)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .size(width = 298.dp, height = 50.dp)
                .shadow(12.dp, spotColor = Color.Black)
                .padding(start = 70.dp)
        ) {
            Text(
                text = "Let's Start",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = NavController(LocalContext.current))
}
