package com.example.smartmed.data

data class LoginUIState(

    var email : String = "",
    var password : String = "",

    var emailError : Boolean = false,
    var passwordError : Boolean = false,
)
