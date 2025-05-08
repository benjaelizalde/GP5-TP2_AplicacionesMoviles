package com.grupo5.app2_capitales.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ciudades")
data class Ciudad(
    @PrimaryKey val nombreCiudad: String,
    val nombrePais: String,
    val poblacion: Int
)
