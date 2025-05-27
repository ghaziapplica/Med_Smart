package com.example.smartmed.authScreen
// ProfileViewModel.kt

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri = _imageUri.asStateFlow()

    fun setImageUri(uri: Uri) {
        _imageUri.value = uri
    }

    fun saveUserProfile(name: String, phone: String, dob: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val userId = auth.currentUser?.uid ?: return

        val profile = hashMapOf(
            "fullName" to name,
            "phoneNumber" to phone,
            "dateOfBirth" to dob
        )

        db.collection("users").document(userId)
            .set(profile)
            .addOnSuccessListener {
                _imageUri.value?.let { uri ->
                    uploadProfileImage(userId, uri, onSuccess, onFailure)
                } ?: onSuccess()
            }
            .addOnFailureListener { e ->
                onFailure(e)
            }
    }

    private fun uploadProfileImage(userId: String, uri: Uri, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val storageRef = storage.reference.child("profile_images/$userId.jpg")
        storageRef.putFile(uri)
            .addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                    db.collection("users").document(userId)
                        .update("profileImageUrl", downloadUrl.toString())
                        .addOnSuccessListener { onSuccess() }
                        .addOnFailureListener { e -> onFailure(e) }
                }
            }
            .addOnFailureListener { e -> onFailure(e) }
    }
}
