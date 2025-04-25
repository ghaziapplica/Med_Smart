package com.example.smartmed.authScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.ui.theme.poppinsFamilyFont

@Composable
fun PasswordScreen(navController: NavController) {
    var textEmail by remember { mutableStateOf("") }
    var textOtp by remember { mutableStateOf("") }
    var isEmailFocused by remember { mutableStateOf(false) }
    var isOtpFocused by remember { mutableStateOf(false) }
    val focusManager: FocusManager = LocalFocusManager.current

Column (
    modifier = Modifier.fillMaxSize()
        .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally
){

    Spacer(modifier = Modifier.size(160.dp))
    Text(
        text = "Create Password ",
        modifier = Modifier.align(Alignment.CenterHorizontally),
        fontFamily = poppinsFamilyFont,
        color = Color(0xFF0077B6),
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
    Spacer(modifier = Modifier.size(24.dp))
//    Box (
////        modifier = Modifier.align(Alignment.CenterHorizontally)
//    ){

        Text(
            text = "Create an account so you can explore all the \n" +
                    "existing jobs",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = poppinsFamilyFont,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 11.sp,
            textAlign =   TextAlign.Center
        )
//    }
    Spacer(modifier = Modifier.size(50.dp))
    Box(
        modifier = Modifier
            .width(298.dp)
            .height(53.dp)
            .background(Color(0xFFF1F4FF), RoundedCornerShape(8.35.dp))
            .border(
                width = if (isEmailFocused || textEmail.isNotEmpty()) 1.67.dp else (-1).dp, // Show border only when focused or has text
                color = Color(0xFF0077B6),
                shape = RoundedCornerShape(8.35.dp)
            )
            .padding(
                start = 16.69.dp,
                end = 29.22.dp,
                top = 16.69.dp,
                bottom = 16.69.dp
            )
            .onFocusChanged { focusState -> isEmailFocused = focusState.isFocused }
    ) {
        BasicTextField(
            value = textEmail,
            onValueChange = { textEmail = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(
                    FocusDirection.Down
                )
            }),
            textStyle = TextStyle(
                fontSize = 13.36.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            ),
            modifier = Modifier.fillMaxSize(),
            decorationBox = { innerTextField ->
                if (textEmail.isEmpty() && !isEmailFocused) {
                    Text(
                        text = "New Password",
                        style = TextStyle(
                            fontSize = 13.36.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                        ),
                        modifier = Modifier.alpha(0.6f)
                    )
                }
                innerTextField()
            }
        )
    }
    Spacer(modifier = Modifier.size(10.dp))

    Spacer(modifier = Modifier.size(10.dp))
    Box(
        modifier = Modifier
            .width(298.dp)
            .height(53.dp)
            .background(Color(0xFFF1F4FF), RoundedCornerShape(8.35.dp))
            .border(
                width = if (isOtpFocused || textOtp.isNotEmpty()) 1.67.dp else (-1).dp, // Show border only when focused or has text
                color = Color(0xFF0077B6),
                shape = RoundedCornerShape(8.35.dp)
            )
            .padding(start = 16.69.dp, end = 29.22.dp, top = 16.69.dp, bottom = 16.69.dp)
            .onFocusChanged { focusState -> isOtpFocused = focusState.isFocused }
    ) {
        BasicTextField(
            value = textOtp,
            onValueChange = { textOtp = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            textStyle = TextStyle(
                fontSize = 13.36.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            ),
            modifier = Modifier.fillMaxSize(),
            decorationBox = { innerTextField ->
                if (textOtp.isEmpty() && !isOtpFocused) {
                    Text(
                        text = "Confirm Password",
                        style = TextStyle(
                            fontSize = 13.36.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                        ),
                        modifier = Modifier.alpha(0.6f)
                    )
                }
                innerTextField()
            }
        )
    }
    Spacer(modifier = Modifier.size(44.dp))
    Button(
        onClick = {
            navController.navigate(AuthRouteScreen.LoginScreen.route)
        },
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
    ) {
        Text(
            text = "Reset Password",
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
fun PasswordScreenPreview() {
    PasswordScreen(navController = NavController(LocalContext.current))
}
