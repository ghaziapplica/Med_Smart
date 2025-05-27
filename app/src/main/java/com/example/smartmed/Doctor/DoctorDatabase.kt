package com.example.smartmed.Doctor


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DoctorEntity::class], version = 2, exportSchema = false)
abstract class DoctorDatabase : RoomDatabase() {

    abstract fun doctorDao(): DoctorDao

    companion object {
        @Volatile
        private var INSTANCE: DoctorDatabase? = null

        fun getDatabase(context: Context): DoctorDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DoctorDatabase::class.java,
                    "doctor_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
