package com.grupo5.app2_capitales.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ciudad::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ciudadDao(): CiudadDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ciudades_db"
                ).build()
                INSTANCE = instancia
                instancia
            }
        }
    }
}