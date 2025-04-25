package com.example.smartmed.data.rules

object Validator {
    fun validateEmail(email:String) :ValidationResult{
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }
    fun validatePassword(password:String) :ValidationResult{
            return ValidationResult(
                (!password.isNullOrEmpty() && password.length>=6),
            )
    }
    fun validateConfirmPassword( confirmPassword:String) :ValidationResult{
            return ValidationResult(
                (!confirmPassword.isNullOrEmpty() && confirmPassword.length>=6),
            )
    }

}

data class ValidationResult(
    val status :Boolean = false
)