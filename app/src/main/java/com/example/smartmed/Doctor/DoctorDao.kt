package com.example.smartmed.Doctor

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DoctorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(doctors: List<DoctorEntity>)

//    @Query("SELECT * FROM doctors WHERE category = :category")
//    suspend fun getDoctorsByCategory(category: String): List<DoctorEntity>
}