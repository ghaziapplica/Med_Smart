package com.example.smartmed.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.smartmed.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class SignupViewModel : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName
    var shouldNavigateToProfile = mutableStateOf(false)
        private set

    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allValidationPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent (event: SignupUIEvent) {
        validateDataWithRules()

        when (event) {
            is SignupUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }
            is SignupUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }
            is SignupUIEvent.ConfirmPasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    confirmPassword = event.confirmPassword
                )
                printState()
            }
            is SignupUIEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "Inside_signUp")
        printState()
        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun validateDataWithRules() {
        val emailResult = Validator.validateEmail(
        email = registrationUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password,
        )
        val confirmPasswordResult = Validator.validateConfirmPassword(
            confirmPassword = registrationUIState.value.password,
        )

        registrationUIState.value =  registrationUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            confirmPasswordError = confirmPasswordResult.status
        )

        allValidationPassed.value = emailResult.status && passwordResult.status && confirmPasswordResult.status
    }

    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }

    private fun createUserInFirebase (email: String, password: String){

        signUpInProgress.value = true

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, " isSuccessful = ${it.isSuccessful}")

                signUpInProgress.value = false

                if (it.isSuccessful) {
                    shouldNavigateToProfile.value = true
                }


            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, " exception = ${it.message}")
                Log.d(TAG, " exception = ${it.localizedMessage}")

            }

    }

}