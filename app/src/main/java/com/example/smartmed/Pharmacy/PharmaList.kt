package com.example.smartmed.Pharmacy

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

// Data class for Pharmacy
data class Pharmacy(val name: String,
                  val address: String,
                  val contactNumber: String,
                  val profileImageUrl: String,
                  val availability: String,
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PharmacyListScreen(
    pharmacies: List<Pharmacy>,
    navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        var selectedPharmacy by remember { mutableStateOf<Pharmacy?>(null) }

        if (selectedPharmacy != null) {
            PharmacyPopupDialog(
                onDismiss = { selectedPharmacy = null },
                pharmacyName = selectedPharmacy!!.name,
                contactNumber = selectedPharmacy!!.contactNumber,
                profileImageUrl = selectedPharmacy!!.profileImageUrl,
                availability = selectedPharmacy!!.availability,
                address = selectedPharmacy!!.address
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
                    text = "Find Pharmacy",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF0077B6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Nearby Pharmacies",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = poppinsFamilyFont,
                color = Color(0xFF979797),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(pharmacies) { pharmacy ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedPharmacy = pharmacy }
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
                                text = pharmacy.name,

                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(start = 16.dp)

                            )
                            Text(
                                text = pharmacy.address,
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


val pharmaciesList = listOf(
    Pharmacy("Servaid Pharmacy", "Model Town Circular Road, Lahore", "(042) 111 626 364", "https://media-exp1.licdn.com/dms/image/C4D0BAQGsYnCb87RwTA/company-logo_200_200/0/1647604883541?e=2147483647&v=beta&t=YX9ez-7Vm-98Rw9Nk4zzeSH01w4QjgQeOMRlmGziGUo", "24/7"),
    Pharmacy("Chughtai Pharmacy", "154-DD, Phase 4, DHA Lahore", "0345 0287844", "https://www.jubileelife.com/wp-content/uploads/2020/01/Chughtai-Lab-Logo-against-light-and-dark-backgrounds-02-1024x577.png", "9:00 AM – 10:00 PM"),
    Pharmacy("Clinix Pharmacy", "153 Main Multan Road, Allama Iqbal Town, Near Shahnoor Studios, Lahore", " (042) 35408355", "https://media.licdn.com/dms/image/v2/C560BAQHp0EsAQI16qA/company-logo_200_200/company-logo_200_200/0/1630668448478/clinix_private_limited_logo?e=2147483647&v=beta&t=Hz25A3zazjKiG8a3KDahr_DZjxTSMc_quJDqC3arHU4", "9:00 AM – 11:00 PM"),
    Pharmacy("Guardian Pharmacy", "Rehman Tower, Main Market, Lahore", "(042) 35786139", "https://corporatepharmacy.ca/wp-content/uploads/2020/02/guardian-corporate-pharmacy-logo.png", "9:00 AM – 11:00 PM"),
    Pharmacy("Fazal Din's Pharma Plus", "Model Town Link Road, Model Town - Block Q, Lahore", "(042) 35165724, (042) 35163896", "https://pharmaplus.com.pk/wp-content/uploads/2022/03/pharma-logo.png", "9:00 AM – 10:00 PM"),
    Pharmacy("CSH Pharmacy", "Main Market Round About, Hali Road, Gulberg 3, Lahore", "+92 305 4441162", "https://atyourservice.pk/wp-content/uploads/2024/05/CSH-Pharmacy-Logo.jpg", "24/7"),
    Pharmacy("Punjab Medical Store", "240-D, Roundabout, Al-Wahab Trader Center, PIA Main Boulevard, Wapda Town Phase 1 - Block B4, Lahore", "(042) 35188662, (042) 35188173", "https://tse1.mm.bing.net/th?id=OIP.psK7QQlEoZjtDt-LkboAfAAAAA&pid=Api&P=0&h=220", "9:00 AM – 10:00 PM"),
    Pharmacy("Health Mart Pharmacy", "Shop 8, 9, Barkat Market, Shan Arcade, Garden Town - Aibak Block, Lahore", "(042) 35941718, +92-323-4965325", "https://www.citysearch.pk/UF/Companies/8253/health-mart-pharmacy-logo.jpg", "9:00 AM – 10:00 PM"),
    Pharmacy("Dr. Masood & Sons", "Block 1, Glamour One Plaza, Peco Road, Township - Sector B1, Lahore", "(042) 35156276", "https://tse3.mm.bing.net/th?id=OIP.eKHeiBdie3Su3BB3RwPN3wAAAA&pid=Api&P=0&h=220", "9:00 AM – 10:00 PM"),
    Pharmacy("Med-X Pharmacy", "Shop no. 70,71, Masood Anwari Road, Cavalry Ground, Lahore", "(042) 36619987, +92-321-1114432", "https://images.deliveryhero.io/image/talabat/restaurants/Medex_Pharmacy_logo_637174911960586030.jpg?width=180", "9:00 AM – 10:00 PM"),
    Pharmacy("Siddique Sons Pharmacy", "51, Sector FF, Central Commercial Area, DHA Phase 4, Lahore", "(042) 37182180", "https://tse2.mm.bing.net/th?id=OIP.rG6nauWCpq-GZpv0EqqtOgHaHa&pid=Api&P=0&h=220", "9:00 AM – 10:00 PM"),
    Pharmacy("Shifa Pharmacy", "Model Town - Block C, Lahore", "(042) 35887780", "https://tse1.mm.bing.net/th?id=OIP.2VBK4p_8zUSqhv508nq52gHaCw&pid=Api&P=0&h=220", "9:00 AM – 10:00 PM"),
    Pharmacy("Waqar Medics", "2 Model Town Circular Road, Model Town - Block B, Lahore", "(042) 35887780", "https://tse3.mm.bing.net/th?id=OIP.jEsfOX7r4MCszAkxqWJw3wHaHO&pid=Api&P=0&h=220", "9:00 AM – 10:00 PM"),
    Pharmacy("Doctors' Pharma", "Aman Plaza, Model Town Link Road, Model Town - Block Q, Lahore", "(042) 35887780", "https://tse2.mm.bing.net/th?id=OIP.EYQ6fe_YfayCWrkCVPGtoAAAAA&pid=Api&P=0&h=220", "9:00 AM – 10:00 PM"),
    Pharmacy("Zam Zam Pharma", "51 Quaid E Azam Industrial Estate, Kot Lakhpat, Lahore", "(042) 34550734", "https://www.zamzampharmaceuticals.com/wp-content/uploads/2022/02/newZamlayout-second.png", "9:00 AM – 10:00 PM"),
    Pharmacy("Slimmers Anti-Aging & Functional Medicine", " 65-C Street Number 3, Ali Zaib Road, Lahore", "(042) 35756565", "https://cdn-icons-png.flaticon.com/512/4899/4899417.png", "9:00 AM – 10:00 PM"),
    Pharmacy("Qarshi Health Shop", " DHA Phase 6, J Block Mosque Lahore, 4 Street 4, Lahore 54000, Pakistan, Saman Arcade, Ali Zaib Road, Gulberg 3, Lahore", "(042) 35852423", "https://cdn.shopify.com/s/files/1/0514/9422/4052/files/qurshi_log.jpg?v=1638549444", "9:00 AM – 10:00 PM"),
    Pharmacy("Al Shifa Pharmacy", " Bedian Rd, Lahore", "+92 300 0943943", "https://media.licdn.com/dms/image/D560BAQHXALJ-2Q8jbA/company-logo_200_200/0/1707338120500?e=2147483647&v=beta&t=vHRuFIEzjPnvVbKIOvNbQjw34Nv-fJJm7K7ps3WK-o8", "9:00 AM – 10:00 PM"),
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun DoctorListScreenPreview() {
    PharmacyListScreen(
        pharmacies = listOf(
            Pharmacy("Dr. John Doe", "Main Boulevard, Lahore", "123-456-7890", "", "",),
            Pharmacy("Dr. Jane Smith", "Liberty Market, Lahore", " ", "", ""),
            Pharmacy("Dr. Michael Johnson", "Ferozepur Road, Lahore", "", "",
                "")
        ),
        navController = NavHostController(LocalContext.current),
    )
}
