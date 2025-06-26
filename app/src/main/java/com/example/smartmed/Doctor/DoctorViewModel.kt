package com.example.smartmed.Doctor

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DoctorViewModel(private val repository: DoctorRepository) : ViewModel() {

    private val _doctors = MutableStateFlow<List<DoctorEntity>>(emptyList())
    val doctors = _doctors.asStateFlow()


    fun insertDoctors(doctors: List<DoctorEntity>) {
        viewModelScope.launch {
            repository.insertDoctors(doctors)
        }
    }


    // ✅ THIS SHOULD BE INSIDE THE CLASS
    fun insertDoctorsWithImagesAndContacts(doctors: List<DoctorEntity>) {
        viewModelScope.launch {
            repository.insertDoctors(doctors)
        }
    }
}
