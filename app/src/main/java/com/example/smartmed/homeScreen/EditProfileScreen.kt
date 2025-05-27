package com.example.smartmed.homeScreen

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.ProfileSharedViewModel
import com.example.smartmed.R
import com.example.smartmed.authScreen.EditProfileViewModel
import com.example.smartmed.authScreen.ProfileViewModel
import com.example.smartmed.components.CustomImageButton
import com.example.smartmed.components.LogoutButton
import com.example.smartmed.ui.theme.poppinsFamilyFont
import com.google.firebase.auth.FirebaseAuth

@Composable
fun EditProfileScreen(viewModel: EditProfileViewModel = EditProfileViewModel(),
                      innerPadding: PaddingValues,
                      profileSharedViewModel: ProfileSharedViewModel,
                      navController: NavHostController
) {
    val fullName by viewModel.fullName.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val password by viewModel.password.collectAsState()

    var nameInput by remember { mutableStateOf("") }
    var numberInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    val context = LocalContext.current
    val imageUri by viewModel.imageUri.collectAsState()
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let { viewModel.setImageUri(it) }
    }
    LaunchedEffect(true) {
        viewModel.loadUserData()
    }

    LaunchedEffect(fullName, phoneNumber, password) {
        nameInput = fullName
        numberInput = phoneNumber
        passwordInput = password
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)
            .padding(37.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CustomImageButton(
                drawableId = R.drawable.back,
                onClick = {
                    navController.navigate(MainRouteScreen.HomeScreen.route)
                }
            )

            Spacer(modifier = Modifier.padding(start = 54.dp))


        }

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .clickable { launcher.launch("image/*") }
        ) {
            if (imageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "Profile Image",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "Default Profile Image",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Image(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "Edit Icon",
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.BottomEnd)
                    .padding(2.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Create Profile ",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = poppinsFamilyFont,
            color = Color(0xFF0077B6),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = numberInput,
            onValueChange = { numberInput = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),

        )
Column {

}
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                viewModel.updateUserData(
                    nameInput, numberInput, passwordInput,
                    onSuccess = {
                      Toast.makeText(context, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                    },
                    onFailure = {
                        Toast.makeText(context, "Failed to update profile", Toast.LENGTH_SHORT).show()
                    }
                )
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
//        Spacer(modifier = Modifier.height(10.dp))
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Bottom,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            LogoutButton(navController = navController)
//            Spacer(modifier = Modifier.height(24.dp))
//        }
    }
}



@Preview
@Composable
fun MyProfileScreenPreview() {
    EditProfileScreen(
        viewModel =
            EditProfileViewModel(),
        innerPadding = PaddingValues(),
        profileSharedViewModel = ProfileSharedViewModel(),
        navController = NavHostController(LocalContext.current)


    )
}