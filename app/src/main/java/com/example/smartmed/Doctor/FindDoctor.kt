package com.example.smartmed.Doctor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.R
import com.example.smartmed.components.CustomImageButton
import com.example.smartmed.ui.theme.poppinsFamilyFont
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun FindDoctor(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val specialists = listOf(
            "Heart Specialist (Cardiologist)",
            "Skin Specialist (Dermatologist)",
            "Child Spefincialist (Pediatrician)",
            "Eye Specialist (Ophthalmologist)",
            "Psychiatrist",
            "Orthopedic Surgeon",
            "Gynecologist",
            "Dentist"
        )

        Spacer(modifier = Modifier.height(18.dp))

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

        specialists.forEach { label ->
            SpecialistBox(label = label) {
                val encodedLabel = URLEncoder.encode(label, StandardCharsets.UTF_8.toString())
                navController.navigate("doctor_list_screen/$encodedLabel")
            }
            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Composable
fun SpecialistBox(
    label: String,
    onClick: () -> Unit
) {
    Box (
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 55.dp)
                .clickable { onClick() }
                .background(color = Color(0xFFF1F4FF), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                .padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(32.dp)
                        .background(Color(0xFF0077B6)) // blue bar
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                )
            }
        }       }

}

@Preview
@Composable
fun FindDoctorPreview() {
    FindDoctor(navController = NavHostController(LocalContext.current))
}
