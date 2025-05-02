package com.example.smartmed.bottomBarScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
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
import com.example.smartmed.R

@Composable
fun HomeScreen(innerPadding: PaddingValues) {

    val name = stringResource(id = R.string.name)
    var isLiked by remember { mutableStateOf(false) }

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
                    painter = painterResource(id = R.drawable.profilepic), // Replace with your image
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
                        text = name,
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

            Row (
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            )
            {
                Spacer(modifier = Modifier.padding(start = 10.dp))

                    Box(
                        modifier = Modifier.background(Color(0xFFF1F4FF),
                            shape = RoundedCornerShape(16.dp) )
                            .size(302.dp, 117.dp)
                            .align(Alignment.CenterVertically)
                            .padding(start = 9.dp)




                    ){
                        Column (

                        ){


                            Row (

                            ) {
                                Text(
                                    text = "Cardio Issues",
                                    modifier = Modifier.padding(13.dp),
                                    style = TextStyle(
                                        fontSize = 14.sp, // Font size
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF626262),
                                        // Font weight 600
                                    ),
                                )
                                Spacer(modifier = Modifier.padding(start = 130.dp))
                                Box(
                                    modifier = Modifier.padding(top = 13.dp)){
                                    Image(
                                        painter = painterResource(id = if (isLiked) R.drawable.clicked
                                        else R.drawable.unclicked),
                                        contentDescription = "Heart Icon",
                                        modifier = Modifier
                                            .clickable { isLiked = !isLiked } // Toggle on click
                                            .size(16.dp, 14.dp) // Size of the icon (adjust as needed)
                                    )

                                }


                            }
                            Row (
                                modifier = Modifier.fillMaxSize()
                                    .padding(start = 13.dp)

                            ){
                                Box(
                                    modifier = Modifier
                                        .width(4.dp)
                                        // Thickness of the vertical bar
                                        .height(50.dp) // Full height of the parent Box
                                        .background(Color(0xFF0077B6)) // Bar color
                                         // Align to left (you can change this)
                                )
                                Text(
                                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting",
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



                    }
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Box(
                    modifier = Modifier.background(Color(0xFFF1F4FF),
                        shape = RoundedCornerShape(16.dp) )
                        .size(302.dp, 117.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 9.dp)



                ){
                    Column (

                    ){


                        Row (

                        ) {
                            Text(
                                text = "Cardio Issues",
                                modifier = Modifier.padding(13.dp),
                                style = TextStyle(
                                    fontSize = 14.sp, // Font size
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF626262),
                                    // Font weight 600
                                ),
                            )
                            Spacer(modifier = Modifier.padding(start = 130.dp))
                            Box(
                                modifier = Modifier.padding(top = 13.dp)){
                                Image(
                                    painter = painterResource(id = if (isLiked) R.drawable.clicked
                                    else R.drawable.unclicked),
                                    contentDescription = "Heart Icon",
                                    modifier = Modifier
                                        .clickable { isLiked = !isLiked } // Toggle on click
                                        .size(16.dp, 14.dp) // Size of the icon (adjust as needed)
                                )

                            }


                        }
                        Row (
                            modifier = Modifier.fillMaxSize()
                                .padding(start = 13.dp)

                        ){
                            Box(
                                modifier = Modifier
                                    .width(4.dp)
                                    // Thickness of the vertical bar
                                    .height(50.dp) // Full height of the parent Box
                                    .background(Color(0xFF0077B6)) // Bar color
                                // Align to left (you can change this)
                            )
                            Text(
                                text = "Lorem Ipsum is simply dummy text of the printing and typesetting",
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



                }
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Box(
                    modifier = Modifier.background(Color(0xFFF1F4FF),
                        shape = RoundedCornerShape(16.dp) )
                        .size(302.dp, 117.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 9.dp)



                ){
                    Column (

                    ){


                        Row (

                        ) {
                            Text(
                                text = "Cardio Issues",
                                modifier = Modifier.padding(13.dp),
                                style = TextStyle(
                                    fontSize = 14.sp, // Font size
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF626262),
                                    // Font weight 600
                                ),
                            )
                            Spacer(modifier = Modifier.padding(start = 130.dp))
                            Box(
                                modifier = Modifier.padding(top = 13.dp)){
                                Image(
                                    painter = painterResource(id = if (isLiked) R.drawable.clicked
                                    else R.drawable.unclicked),
                                    contentDescription = "Heart Icon",
                                    modifier = Modifier
                                        .clickable { isLiked = !isLiked } // Toggle on click
                                        .size(16.dp, 14.dp) // Size of the icon (adjust as needed)
                                )

                            }


                        }
                        Row (
                            modifier = Modifier.fillMaxSize()
                                .padding(start = 13.dp)

                        ){
                            Box(
                                modifier = Modifier
                                    .width(4.dp)
                                    // Thickness of the vertical bar
                                    .height(50.dp) // Full height of the parent Box
                                    .background(Color(0xFF0077B6)) // Bar color
                                // Align to left (you can change this)
                            )
                            Text(
                                text = "Lorem Ipsum is simply dummy text of the printing and typesetting",
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
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting",
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
                            text = "Lorem Ipsu is simply",
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
                    modifier = Modifier.background(Color(0xFFF1F4FF),
                        shape = RoundedCornerShape(16.dp) )
                        .size(158.dp, 113.dp)
                        .padding(
                            start = 10.dp,
                        )





                ){
                    Row (
                        modifier = Modifier.align(Alignment.Center)


                    ){
                        Image(
                            painter = painterResource(id = R.drawable.doctorvector), // Replace with your drawable name
                            contentDescription = "Icon",
                            modifier = Modifier.size(44.dp) // Set size as needed
                        )

                        Text(
                            text = "Lorem Ipsu is simply",
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
            }



        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(innerPadding = PaddingValues())
}