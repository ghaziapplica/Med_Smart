package com.example.smartmed.Doctor

class DoctorRepository(private val dao: DoctorDao) {

//    suspend fun getDoctorsByCategory(category: String): List<DoctorEntity> {
//        return dao.getDoctorsByCategory(category)
//    }

    suspend fun insertDoctors(doctors: List<DoctorEntity>) {
        dao.insertAll(doctors)
    }
}