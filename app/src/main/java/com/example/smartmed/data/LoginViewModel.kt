package com.example.smartmed.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.smartmed.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName
    var loginUIState = mutableStateOf(LoginUIState())
    var allValidationPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)
    var shouldNavigateToProfile = mutableStateOf(false)
        private set


    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )

            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )

            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }

            }
        validateLoginUIDataWithRules()

        }



    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status

        )
        allValidationPassed.value = emailResult.status && passwordResult.status
    }

    private fun login() {
        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(
                email,
                password
            )
            .addOnCompleteListener {

                Log.d(TAG, "Inside_login_success")
                Log.d(TAG,"${it.isSuccessful}")
                if (it.isSuccessful) {
                    loginInProgress.value = false
                    shouldNavigateToProfile.value = true
                }

            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_login_failure")
                Log.d(TAG, "${it.localizedMessage}")
                loginInProgress.value = false

            }
    }
}


