package com.example.smartmed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartmed.components.CustomImageButton
import com.example.smartmed.ui.theme.poppinsFamilyFont

@Composable
fun FindServiceScreen(navController: NavController,
                      innerPadding: PaddingValues
) {
    Box(
        modifier = Modifier.fillMaxSize()
        .background(Color.White)
    ){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(start = 16.dp, end = 16.dp, )
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                CustomImageButton(
                    drawableId = R.drawable.back,
                    onClick = {
                        navController.navigate(MainRouteScreen.HomeScreen.route)
                    }
                )

                Spacer(modifier = Modifier.padding(start = 54.dp))

                Text(
                    text = "Find Doctor",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF0077B6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            FindCard(
                title = "Find Life",
                description = "Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting",
                iconRes = R.drawable.doctorvector,
                onClick = { navController.navigate("specialist_selection") }
            )

            FindCard(
                title = "Find Pharmacy",
                description = "Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting",
                iconRes = R.drawable.pharmacyvector,
                onClick = { navController.navigate("pharmacy_selection") }
            )
        }
    }
}

@Composable
fun FindCard(title: String, description: String, iconRes: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8FAFF), shape = RoundedCornerShape(16.dp))
            .padding(24.dp),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF003B73)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = description,
                fontSize = 13.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0077B6)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Find Here", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
@Preview
fun FindServiceScreenPreview() {
    FindServiceScreen(
        navController = rememberNavController(),
        innerPadding = PaddingValues()
    )
}
