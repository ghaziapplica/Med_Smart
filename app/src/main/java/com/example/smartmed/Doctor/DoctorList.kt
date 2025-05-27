package com.example.smartmed.Doctor

import DoctorPopupDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

// Data class for Doctor
data class Doctor(val name: String,
                  val address: String,
                  val contactNumber: String,
                  val profileImageUrl: String,
                  val availability: String,
                  val openClose : String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DoctorListScreen(category: String,
                     doctors: List<Doctor>,
                     navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        var selectedDoctor by remember { mutableStateOf<Doctor?>(null) }

        if (selectedDoctor != null) {
            DoctorPopupDialog(
                onDismiss = { selectedDoctor = null },
                category = category,
                doctorName = selectedDoctor!!.name,
                contactNumber = selectedDoctor!!.contactNumber,
                profileImageUrl = selectedDoctor!!.profileImageUrl,
                availability = selectedDoctor!!.availability,
                address = selectedDoctor!!.address
            )
        }


        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
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
                    text = "Choose Doctor",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF0077B6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = category,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = poppinsFamilyFont,
                color = Color(0xFF979797),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(doctors) { doctor ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedDoctor = doctor }
                            .background(color = Color(0xFFF1F4FF), shape = RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .height(46.dp)
                                .background(Color(0xFF0077B6))
                        )
                        Column {
                            Text(
                                text = doctor.name,

                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(start = 16.dp)

                            )
                            Text(
                                text = doctor.address,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.DarkGray,
                                    fontSize = 12.sp
                                ),
                                modifier = Modifier.padding(start = 16.dp)
                            )

                        }


                    }
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun DoctorListScreenPreview() {
    DoctorListScreen(
        doctors = listOf(
            Doctor("Dr. John Doe", "Main Boulevard, Lahore", "123-456-7890", "", "", ""),
            Doctor("Dr. Jane Smith", "Liberty Market, Lahore", " ", "", "", ""),
            Doctor("Dr. Michael Johnson", "Ferozepur Road, Lahore", "", "",
                "", "")
        ),
        navController = NavHostController(LocalContext.current),
        category = "Heart Specialist (Cardiologist)",
    )
}
