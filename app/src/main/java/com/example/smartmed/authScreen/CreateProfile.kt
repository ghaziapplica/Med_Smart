package com.example.smartmed.authScreen

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.smartmed.ui.theme.poppinsFamilyFont
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.Graph
import com.example.smartmed.R
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileScreen(navController: NavController) {
    var textEmail by remember { mutableStateOf("") }
    var textOtp by remember { mutableStateOf("") }
    var isEmailFocused by remember { mutableStateOf(false) }
    var isOtpFocused by remember { mutableStateOf(false) }
    val focusManager: FocusManager = LocalFocusManager.current
    var selectedDate by remember { mutableStateOf("") }
    val context = LocalContext.current

    val currentDate = LocalDate.now()
    val year = currentDate.year
    val month = currentDate.monthValue // Month is 1-indexed (1 = January, 12 = December)
    val day = currentDate.dayOfMonth

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 37.dp, end = 37.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.size(160.dp))
        Text(
            text = "Create Profile ",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = poppinsFamilyFont,
            color = Color(0xFF0077B6),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.size(24.dp))
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Gray, shape = CircleShape) // Background with shape
        ) {
            Image(
                painter = painterResource(id = R.drawable.profilepic), // Replace with your image
                contentDescription = "Circular Image with Border",
                modifier = Modifier
                    .size(80.dp) // Set size
                    .clip(CircleShape) // Make it circular // Add a 2dp blue border
            )
            Image(
                painter = painterResource(id = R.drawable.edit), // Replace with your image
                contentDescription = "Circular Image with Border",
                modifier = Modifier.size(25.dp)
                    .align(Alignment.BottomEnd)
                    .padding(end = 2.dp, bottom = 2.dp)
            )
        }
        Spacer(modifier = Modifier.size(50.dp))

        Text(
            text = "Full Name",
            modifier = Modifier.align(Alignment.Start),
            fontFamily = poppinsFamilyFont,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            textAlign =   TextAlign.Center
        )
        Spacer(modifier = Modifier.size(12.dp))

        Box(
            modifier = Modifier
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
                            text = "Name",
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
        Text(
            text = "Phone number",
            modifier = Modifier.align(Alignment.Start),
            fontFamily = poppinsFamilyFont,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            textAlign =   TextAlign.Center
        )
        Spacer(modifier = Modifier.size(12.dp))
        Box(
            modifier = Modifier
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
                            text = "Number",
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
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = "Date of birth",
            modifier = Modifier.align(Alignment.Start),
            fontFamily = poppinsFamilyFont,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            textAlign =   TextAlign.Center
        )
        Spacer(modifier = Modifier.size(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp)
                .background(Color(0xFFF1F4FF), shape = MaterialTheme.shapes.small)
                .clickable { datePickerDialog.show() } // Show Date Picker when clicked
                .padding(16.dp)
        ) {
            Text(
                text = if (selectedDate.isEmpty()) "DD / MM / YYYY" else selectedDate,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (selectedDate.isEmpty()) Color.Gray else Color.Black
                )
            )
        }
        Spacer(modifier = Modifier.size(44.dp))
        Button(
            onClick = {
                navController.navigate(Graph.MainScreenGraph){
                popUpTo(AuthRouteScreen.ProfileScreen.route){
                    inclusive = true
                }
            }
                      },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF0077B6)
            ),
            shape = RoundedCornerShape(8.dp), // Border radius
            modifier = Modifier
                .height(53.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp, // Blur effect
                    spotColor = Color(0xFF000000), // Shadow color
                    ambientColor = Color(0xFF000000) // Ambient shadow color
                )
        ) {
            Text(
                text = "Save Profile",
                style = TextStyle(
                    fontSize = 16.sp, // Font size
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White// Font weight 600
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.size(25.dp))
        Button(
            onClick = {
                navController.navigate(Graph.MainScreenGraph){
                    popUpTo(AuthRouteScreen.ProfileScreen.route){
                        inclusive = true
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFFFFFFFF)
            ),
            shape = RoundedCornerShape(8.dp), // Border radius
            modifier = Modifier
                .size(width = 298.dp, height = 35.dp)

        ) {
            Text(
                text = "Create later",
                style = TextStyle(
                    fontSize = 15.sp, // Font size
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,// Font weight 600,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }




    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen(
        navController = NavController(LocalContext.current)
    )
}
