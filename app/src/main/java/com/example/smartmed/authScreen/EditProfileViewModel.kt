package com.example.smartmed.authScreen
// EditProfileViewModel.kt

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EditProfileViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()

    private val _fullName = MutableStateFlow("")
    val fullName = _fullName.asStateFlow()

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber = _phoneNumber.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri = _imageUri.asStateFlow()

    fun setImageUri(uri: Uri) {
        _imageUri.value = uri
    }

    fun loadUserData() {
        val uid = auth.currentUser?.uid ?: return
        firestore.collection("users").document(uid).get()
            .addOnSuccessListener { document ->
                _fullName.value = document.getString("fullName") ?: ""
                _phoneNumber.value = document.getString("phoneNumber") ?: ""
                _password.value = document.getString("password") ?: ""
            }
    }

    fun updateUserData(fullName: String, phoneNumber: String, password: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val uid = auth.currentUser?.uid ?: return
        val userMap = mapOf(
            "fullName" to fullName,
            "phoneNumber" to phoneNumber,
            "password" to password
        )
        firestore.collection("users").document(uid).set(userMap)
            .addOnSuccessListener {
                _imageUri.value?.let { uri ->
                    uploadProfileImage(uid, uri, onSuccess, onFailure)
                } ?: onSuccess()
            }
            .addOnFailureListener { e -> onFailure(e) }
    }

    private fun uploadProfileImage(userId: String, uri: Uri, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val storageRef = storage.reference.child("profile_images/$userId.jpg")
        storageRef.putFile(uri)
            .addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                    firestore.collection("users").document(userId)
                        .update("profileImageUrl", downloadUrl.toString())
                        .addOnSuccessListener { onSuccess() }
                        .addOnFailureListener { e -> onFailure(e) }
                }
            }
            .addOnFailureListener { e -> onFailure(e) }
    }
}
