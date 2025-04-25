package com.example.smartmed.authScreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.smartmed.ColorTrans
import com.example.smartmed.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    var isWhite by remember { mutableStateOf(true) }

    val boxColor by animateColorAsState(
        targetValue = if (isWhite) Color(0xFFCAF0F8) else Color.White,
        animationSpec = androidx.compose.animation.core.tween(durationMillis = 1000) // 1 second transition
    )
    LaunchedEffect(Unit) {
        delay(5000)
        isWhite = false
    }

    Column (modifier = Modifier.fillMaxSize()
        .background(color = boxColor)){
        ColorTrans()
        Spacer(modifier = Modifier.size(150.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(25.dp))

        Button(
            onClick = { navController.navigate(AuthRouteScreen.WelcomeScreen.route) },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF0077B6)
            ),
            shape = RoundedCornerShape(8.dp), // Border radius
            modifier = Modifier
                .size(width = 298.dp, height = 50.dp)
                .shadow(
                    elevation = 12.dp, // Blur effect
                    spotColor = Color(0xFF000000), // Shadow color
                    ambientColor = Color(0xFF000000) // Ambient shadow color
                )
                .padding(start = 70.dp)

        ) {
            Text(
                text = "Lets Start",
                style = TextStyle(
                    fontSize = 16.sp, // Font size
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White// Font weight 600
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }



}

@Composable
@Preview
fun SplashScreenPreview (){
    SplashScreen(navController = NavController(LocalContext.current))
}