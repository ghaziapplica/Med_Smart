package com.example.smartmed.chatBot

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.R
import com.example.smartmed.components.CustomImageButton
import com.example.smartmed.graphs.RootNavGraph
import com.example.smartmed.ui.theme.poppinsFamilyFont

@Composable
fun ChatScreen(viewModel: ChatViewModel,
               innerPadding: PaddingValues,
               navController: NavHostController = NavHostController(
                   context = LocalContext.current,
               )
) {
    var userInput by remember { mutableStateOf("") }
    val messages by viewModel.chatMessages.collectAsState()
    val listState = rememberLazyListState()
    val activity = LocalActivity.current as? android.app.Activity
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp)

            ){
                CustomImageButton(
                    drawableId = R.drawable.back,
                    onClick = {

                        navController.navigate(MainRouteScreen.HomeScreen.route)


//                        navController.navigate(MainRouteScreen.HomeScreen.route) {
//                            popUpTo(MainRouteScreen.HomeScreen.route) { inclusive = false }
//                            launchSingleTop = true
//                        }

                    }
                )


                Spacer(
                    modifier = Modifier.padding(start = 43.dp)
                )
                Text(
                    text = "Talk to AI Adviser",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF0077B6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

            }
            LazyColumn(
                state = listState,
                modifier = Modifier.weight(1f)
            ) {
                items(messages.size) { index ->
                    val message = messages[index]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = if (message.role == "user") Arrangement.End else Arrangement.Start
                    ) {
                        if (message.role == "user") {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFF0077B6),
                                        shape = RoundedCornerShape(
                                            topStart = 16.7.dp,
                                            topEnd = 16.7.dp,
                                            bottomStart = 16.7.dp,
                                            bottomEnd = 0.dp
                                        )
                                    )
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = message.content,
                                    color = Color.White
                                )
                            }
                        } else {
                            Text(
                                text = message.content,
                                color = Color.Black,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }

            LaunchedEffect(messages.size) {
                listState.animateScrollToItem(messages.size)
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.padding(start = 12.dp))

                Box(
                    modifier = Modifier
                        .width(261.dp)
                        .height(56.dp)
                        .border(
                            width = 0.87.dp,
                            color = Color(0x47776F69),
                            shape = RoundedCornerShape(26.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                        .onFocusChanged { isFocused = it.isFocused }
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BasicTextField(
                            value = userInput,
                            onValueChange = { userInput = it },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier.weight(1f),
                            decorationBox = { innerTextField ->
                                if (userInput.isEmpty() && !isFocused) {
                                    Text(
                                        text = "Ask me anything...",
                                        color = Color(0xFF776F69)
                                    )
                                }
                                innerTextField()
                            }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "icon",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(start = 8.dp))

                Button(
                    onClick = {
                        viewModel.sendMessage(userInput)
                        userInput = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0077B6)),
                    shape = CircleShape,
                    modifier = Modifier
                        .size(70.dp)
                        .padding(8.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.send),
                        contentDescription = "Send",
                        modifier = Modifier.size(16.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
    }
}

@Composable
@Preview
fun ChatScreenPreview() {
    ChatScreen(
        viewModel = ChatViewModel(ChatRepository()),
        innerPadding = PaddingValues(),
        navController = NavHostController(
            context = LocalContext.current,
        ))
}
