package com.example.smartmed.authScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.R
import com.example.smartmed.components.ButtonComponent
import com.example.smartmed.components.MyTextFieldComponent
import com.example.smartmed.data.SignupViewModel
import com.example.smartmed.data.SignupUIEvent
import com.example.smartmed.ui.theme.poppinsFamilyFont


@Composable
fun SignInScreen(navController: NavController,
                 onTextSelected: (String) -> Unit,
                 signupViewModel: SignupViewModel = viewModel()
) {
    var textEmail by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    var textConfirm by remember { mutableStateOf("") }
    var isEmailFocused by remember { mutableStateOf(false) }
    var isPasswordFocused by remember { mutableStateOf(false) }
    var isConfirmFocused by remember { mutableStateOf( false) }


    val shouldNavigate = signupViewModel.shouldNavigateToProfile.value

    LaunchedEffect(shouldNavigate) {
        if (shouldNavigate) {
            navController.navigate(AuthRouteScreen.ProfileScreen.route) {
                popUpTo(AuthRouteScreen.SignInScreen.route) { inclusive = true }
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
                text = "Create Account",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = poppinsFamilyFont,
                color = Color(0xFF0077B6),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Create an account so you can explore all the\n" +
                        "existing jobs!",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = poppinsFamilyFont,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 11.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(62.dp))

            Column(
                modifier = Modifier
                     // Clears focus when clicking outside
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                // Email TextField

                    MyTextFieldComponent(
                        labelValue = stringResource(id = R.string.email),
                        onTextChanged = {
                            signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                        },
                       errorStatus =  signupViewModel.registrationUIState.value.emailError
//                        errorStatus = signupViewModel.registrationUIState.value.emailError
                    )
//                    BasicTextField(
//                        value = textEmail,
//                        onValueChange = { textEmail = it
//                                        onTextSelected(it)},
//                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//                        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
//                            FocusDirection.Down) }),
//                        textStyle = TextStyle(
//                            fontSize = 13.36.sp,
//                            fontWeight = FontWeight.Medium,
//                            color = Color.Black
//                        ),
//                        modifier = Modifier.fillMaxSize(),
//                        decorationBox = { innerTextField ->
//                            if (textEmail.isEmpty() && !isEmailFocused) {
//                                Text(
//                                    text = "Email",
//                                    style = TextStyle(
//                                        fontSize = 13.36.sp,
//                                        fontWeight = FontWeight.Medium,
//                                        color = Color.Gray,
//                                    ),
//                                    modifier = Modifier.alpha(0.6f)
//                                )
//                            }
//                            innerTextField()
//                        }
//                    )


                Spacer(modifier = Modifier.height(21.dp))

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    errorStatus =  signupViewModel.registrationUIState.value.passwordError
                )


                Spacer(modifier = Modifier.height(21.dp))

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.confirm_password),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.ConfirmPasswordChanged(it))
                    },
                    errorStatus =  signupViewModel.registrationUIState.value.confirmPasswordError
                )
            }


            Spacer(modifier = Modifier.size(25.dp))


            ButtonComponent(
                value = stringResource(id = R.string.register),
                onButtonClicked = {
                    signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                },
                isEnabled = signupViewModel.allValidationPassed.value
            )

            Spacer(modifier = Modifier.size(25.dp))
            Button(
                onClick = {
                    navController.navigate(AuthRouteScreen.LoginScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFFFFFF)
                ),
                shape = RoundedCornerShape(8.dp), // Border radius
                modifier = Modifier
                    .size(width = 298.dp, height = 35.dp)

            ) {
                Text(
                    text = "Already have an account",
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
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between buttons
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageButton(R.drawable.google) // Replace img1 with actual image resource
                ImageButton(R.drawable.facebook) // Replace img2 with actual image resource
                ImageButton(R.drawable.apple) // Replace img3 with actual image resource
            }
        }
        if (signupViewModel.signUpInProgress.value) {

            CircularProgressIndicator()
        }
    }
}



@Composable
@Preview
fun SignInScreenPreview(){
    SignInScreen(navController = NavController(LocalContext.current),
        onTextSelected = {}
    )
}







