package com.example.smartmed.authScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.smartmed.R
import com.example.smartmed.ui.theme.poppinsFamilyFont

@Composable
fun WelcomeScreen (navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.size(150.dp))
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = "",
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .size(
                        height = 226.dp,
                        width = 275.dp
                    )
            )
            Spacer(modifier = Modifier.size(42.dp))

                Text(
                    text = "Easy Login Smart Care",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF03045E),
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            Spacer(modifier = Modifier.size(14.dp))
                Text(
                    text = "Access your health, anytime, anywhere",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = poppinsFamilyFont,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp
                )
            Spacer(modifier = Modifier.size(74.dp))
            Row {
                Button(
                    onClick = {
                        navController.navigate(AuthRouteScreen.LoginScreen .route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF0077B6)
                    ),
                    shape = RoundedCornerShape(8.dp), // Border radius
                    modifier = Modifier
                        .size(width = 126.dp, height = 47.dp)
                        .shadow(
                            elevation = 12.dp, // Blur effect
                            spotColor = Color(0xFF000000), // Shadow color
                            ambientColor = Color(0xFF000000) // Ambient shadow color
                        )
                ) {
                    Text(
                        text = "Login",
                        style = TextStyle(
                            fontSize = 16.sp, // Font size
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White// Font weight 600
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.size(23.dp))
                    Button(
                        onClick = {
                            navController.navigate(AuthRouteScreen.SignInScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFFFFFFF)
                        ),
                        shape = RoundedCornerShape(8.dp), // Border radius
                        modifier = Modifier
                            .size(width = 126.dp, height = 47.dp)

                    ) {
                        Text(
                            text = "Register",
                            style = TextStyle(
                                fontSize = 16.sp, // Font size
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF03045E)// Font weight 600
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
            }


        }

    }
}

@Composable
@Preview
fun WelcomeScreenPreview (){
    WelcomeScreen(navController = NavController(LocalContext.current))
}