package com.example.smartmed.bottomBarScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.smartmed.ProfileSharedViewModel
import com.example.smartmed.R
import com.example.smartmed.components.HealthTipsViewModel

data class HealthTip(val title: String, val quote: String)

@Composable
fun HomeScreen(innerPadding: PaddingValues,
               navController: NavHostController,
               profileSharedViewModel: ProfileSharedViewModel,
               healthTipsViewModel: HealthTipsViewModel
) {

    val defaultName = stringResource(id = R.string.name)
    val name by profileSharedViewModel.profileName.collectAsState()
    var isLiked by remember { mutableStateOf(false) }
    val profileImageUri by profileSharedViewModel.profileImageUri.collectAsState()

    val healthTips = listOf(
        HealthTip("Heart Health", "Take care of your heart, it's the only one you’ve got."),
        HealthTip("Stay Hydrated", "Water is life. Drink more of it."),
        HealthTip("Eat Clean", "Let food be thy medicine and medicine be thy food."),
        HealthTip("Sleep Well", "A good laugh and a long sleep are the best cures."),
        HealthTip("Mental Health", "You are not your illness. You have an individual story to tell."),
        HealthTip("Lung Boost", "Breathe easy by keeping your lungs healthy."),
        HealthTip("Immunity Rise", "Boost your immune system — your body’s defense army.")
    )

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(start = 16.dp, end = 16.dp ),

        ){
            Row (
                modifier = Modifier.align(Alignment.Start)
                    .padding(top = 15.dp, start = 11.dp),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(profileImageUri ?: R.drawable.profilepic),
                    contentDescription = "Circular Image with Border",
                    modifier = Modifier
                        .size(40.dp) // Set size
                        .clip(CircleShape) // Make it circular // Add a 2dp blue border
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))

                Column (
                    modifier = Modifier.align(Alignment.CenterVertically),

                ){

                    Text(
                        text = "Hi, WelcomeBack",
                        style = TextStyle(
                            fontSize = 12.sp, // Font size
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF0077B6)// Font weight 600
                        ),
                    )
                    Text(
                        text = name ?: defaultName,
                        style = TextStyle(
                            fontSize = 14.sp, // Font size
                            fontWeight = FontWeight.Normal,
                            color = Color.Black// Font weight 600
                        ),
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 21.dp))
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ){
                Image(
                    painter = painterResource(id = R.drawable.bannerone), // Replace with your image
                    contentDescription = "Circular Image with Border",
                    modifier = Modifier
                        .size(365.dp, 220.dp)
                ) // Make it circular // Add a 2dp blue border

            }

            Spacer(modifier = Modifier.padding(top = 17.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(healthTips) { tip ->
                    HealthTipCard(tip, viewModel = healthTipsViewModel)

                }
            }
            Spacer(modifier = Modifier.padding(top = 17.dp))

            Box(
                modifier = Modifier.background(Color(0xFFF1F4FF),
                    shape = RoundedCornerShape(16.dp) )
                    .size(322.dp, 127.dp)

                    .padding(
                        start = 20.dp,
                        end = 13.dp,
                    )
                    .clickable {
                        navController.navigate("chatbot_selection") // 👈 Navigate on click
                    }
                    .align(Alignment.CenterHorizontally),





            ){
            Row (
                modifier = Modifier.align(Alignment.Center)


            ){
                Image(
                    painter = painterResource(id = R.drawable.chatvector), // Replace with your drawable name
                    contentDescription = "Icon",
                    modifier = Modifier.size(64.dp) // Set size as needed
                )

                Text(
                    text = "Empowering your health journey with instant support and reliable information",
                    modifier = Modifier.padding(start = 13.dp, end = 13.dp, top = 8.dp),
                    style = TextStyle(
                        fontSize = 14.sp, // Font size
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF626262),
                        // Font weight 600
                    ),
                )

            }
            }
            Spacer(modifier = Modifier.padding(top = 6.dp))

            Row (
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ){
                Box(
                    modifier = Modifier.background(Color(0xFFF1F4FF),
                        shape = RoundedCornerShape(16.dp) )
                        .size(158.dp, 113.dp)
                        .padding(
                            start = 10.dp,
                        )
                        .clickable {
                            navController.navigate("pharmacy_selection") // 👈 Navigate on click
                        }





                    ){
                    Row (
                        modifier = Modifier.align(Alignment.Center)


                    ){
                        Image(
                            painter = painterResource(id = R.drawable.pharmacyvector), // Replace with your drawable name
                            contentDescription = "Icon",
                            modifier = Modifier.size(44.dp) // Set size as needed
                        )

                        Text(
                            text = "Your trusted local pharmacy",
                            modifier = Modifier.padding(start = 8.dp,  top = 8.dp),
                            style = TextStyle(
                                fontSize = 14.sp, // Font size
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF626262),
                                // Font weight 600
                            ),
                        )

                    }
                }
                Spacer(modifier = Modifier.padding(start = 6.dp))

                Box(
                    modifier = Modifier
                        .background(Color(0xFFF1F4FF), shape = RoundedCornerShape(16.dp))
                        .size(158.dp, 113.dp)
                        .padding(start = 10.dp)
                        .clickable {
                            navController.navigate("specialist_selection") // 👈 Navigate on click
                        }
                ) {
                    Row(
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.doctorvector),
                            contentDescription = "Icon",
                            modifier = Modifier.size(44.dp)
                        )

                        Text(
                            text = "Connect with experienced doctors ",
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF626262),
                            ),
                        )
                    }
                }
            }



        }

    }
}
@Composable
fun HealthTipCard(tip: HealthTip, viewModel: HealthTipsViewModel) {
    val likedTips by viewModel.likedTips.collectAsState() // 👈 now it's reactive
    val isLiked = likedTips.contains(tip) // 👈 reactive check
    Box(
        modifier = Modifier
            .background(Color(0xFFF1F4FF), shape = RoundedCornerShape(16.dp))
            .size(width = 302.dp, height = 117.dp)
            .padding(9.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = tip.title,
                    modifier = Modifier.padding(13.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF626262),
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = if (isLiked) R.drawable.clicked else R.drawable.unclicked),
                    contentDescription = "Heart Icon",
                    modifier = Modifier
                        .padding(end = 13.dp)
                        .clickable { viewModel.toggleLike(tip) }
                        .size(16.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 13.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(50.dp)
                        .background(Color(0xFF0077B6))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = tip.quote,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF626262),
                    )
                )
            }
        }
    }
}
@Composable
@Preview
fun HomeScreenPreview() {
    val shared = ProfileSharedViewModel().apply { setProfileName("Robin Hood") }
    HomeScreen(
        innerPadding = PaddingValues(),
        navController = rememberNavController(),
        profileSharedViewModel = shared,
        healthTipsViewModel = HealthTipsViewModel()
    )
}