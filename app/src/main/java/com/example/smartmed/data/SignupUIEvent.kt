package com.example.smartmed.data

sealed class SignupUIEvent {
    data class EmailChanged(val email:String): SignupUIEvent()
    data class PasswordChanged(val password:String): SignupUIEvent()
    data class ConfirmPasswordChanged(val confirmPassword:String): SignupUIEvent()

    object RegisterButtonClicked: SignupUIEvent()

}