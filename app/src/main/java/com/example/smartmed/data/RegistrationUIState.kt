package com.example.smartmed.data

data class RegistrationUIState(
    var email : String = "",
    var password : String = "",
    var confirmPassword : String = "",

    var emailError : Boolean = false,
    var passwordError : Boolean = false,
    var confirmPasswordError : Boolean = false,
)
