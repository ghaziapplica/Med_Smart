package com.example.smartmed.authScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.Graph
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.R
import com.example.smartmed.ViewModel.AuthState
import com.example.smartmed.ViewModel.AuthViewModel
import com.example.smartmed.components.ButtonComponent
import com.example.smartmed.components.MyTextFieldComponent
import com.example.smartmed.data.LoginUIEvent
import com.example.smartmed.data.LoginViewModel
import com.example.smartmed.data.SignupUIEvent
import com.example.smartmed.ui.theme.poppinsFamilyFont


@Composable
fun LoginScreen(navController: NavController,
                loginViewModel: LoginViewModel = viewModel()
) {
    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    var isEmailFocused by remember { mutableStateOf(false) }
    var isPasswordFocused by remember { mutableStateOf(false) }
    val focusManager: FocusManager = LocalFocusManager.current

    val shouldNavigate = loginViewModel.shouldNavigateToProfile.value

    LaunchedEffect(shouldNavigate) {
        if (shouldNavigate) {
            navController.navigate(Graph.MainScreenGraph) {
                popUpTo(AuthRouteScreen.WelcomeScreen .route) { inclusive = true }
            }
        }
    }

    Box (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        contentAlignment = Alignment.Center

        ){
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.size(70.dp))
                Text(
                    text = "Login here",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF0077B6),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    text = "Welcome back you’ve\n" +
                            "been missed!",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = poppinsFamilyFont,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(62.dp))

                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    // Email TextField
                    MyTextFieldComponent(
                        labelValue = stringResource(id = R.string.email),
                        onTextChanged = {
                            loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                        },
                        errorStatus =  loginViewModel.loginUIState.value.emailError
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Password TextField
                    MyTextFieldComponent(
                        labelValue = stringResource(id = R.string.password),
                        onTextChanged = {
                            loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                        },
                        errorStatus =  loginViewModel.loginUIState.value.passwordError
                    )
                }
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    onClick = {
                        navController.navigate(AuthRouteScreen.OtpScreen .route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFFFFFFF)
                    ),
                    shape = RoundedCornerShape(8.dp), // Border radius
                    modifier = Modifier
                        .size(width = 298.dp, height = 35.dp)

                ) {
                    Text(
                        text = "Forgot your password",
                        style = TextStyle(
                            fontSize = 11.sp, // Font size
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black// Font weight 600
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Spacer(modifier = Modifier.size(25.dp))


                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationPassed.value
                )
                    Spacer(modifier = Modifier.size(25.dp))
                    Button(
                        onClick = {
                            navController.navigate(AuthRouteScreen.SignInScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFFFFFFFF)
                        ),
                        shape = RoundedCornerShape(8.dp), // Border radius
                        modifier = Modifier
                            .size(width = 298.dp, height = 35.dp)

                    ) {
                        Text(
                            text = "Create new account",
                            style = TextStyle(
                                fontSize = 11.sp, // Font size
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black// Font weight 600
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }

                Spacer(modifier = Modifier.size(53.dp))
                Text(
                    text = "Or continue with",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF0077B6),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp
                )
            Spacer(modifier = Modifier.size(10.dp))
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between buttons
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ImageButton(R.drawable.google) // Replace img1 with actual image resource
                    ImageButton(R.drawable.facebook) // Replace img2 with actual image resource
                    ImageButton(R.drawable.apple) // Replace img3 with actual image resource
                }
            }
        if (loginViewModel.loginInProgress.value) {

            CircularProgressIndicator()
        }

        }
}
@Composable
fun ImageButton(imageRes: Int) {
    Box(
        modifier = Modifier
            .size(width = 50.dp, height = 36.dp) // Set width and height
            .background(Color(0xFFECECEC), RoundedCornerShape(8.dp)) // Background color & border radius
            .clickable { /* Handle click */ },
        contentAlignment = Alignment.Center // Center the image
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Image Button",
            modifier = Modifier.size(24.dp) // Adjust image size as needed
        )
    }
}

@Composable
@Preview
fun LoginScreenPreview(){
    LoginScreen(
        navController = NavController(LocalContext.current),


    )
}







