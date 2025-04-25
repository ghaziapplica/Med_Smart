package com.example.smartmed.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {


        private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
        private val _authState = MutableLiveData<AuthState>().apply { value = AuthState.Unauthenticated }
        val authState: LiveData<AuthState> = _authState



    init {
        _authState.value = AuthState.Loading // Ensure initial state
        checkAuthStatus()
    }

    fun checkAuthStatus() {
        val user = auth.currentUser
        _authState.value = if (user != null) {
            AuthState.Authenticated
        } else {
            AuthState.Unauthenticated // Ensure correct state for new installs
        }
    }


    fun logout() {
        auth.signOut() // Firebase logout
        _authState.value = AuthState.Unauthenticated // Set state to Unauthenticated
    }

    fun login(email : String, password : String){
        if (email.isBlank() || password.isBlank()){
            _authState.value = AuthState.Error("Email and Password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    _authState.value = AuthState.Authenticated
                }else{
                    _authState.value = AuthState.Error(task.exception?.message ?: "Unknown Error")

                }
            }
    }
    fun signup (email : String, password : String){
        if (email.isBlank() || password.isBlank()){
            _authState.value = AuthState.Error("Email and Password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    _authState.value = AuthState.Authenticated
                }else{
                    _authState.value = AuthState.Error(task.exception?.message ?: "Unknown Error")

                }
            }
    }

    fun signout( ){
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }

}



sealed class AuthState{
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message : String) : AuthState()


}