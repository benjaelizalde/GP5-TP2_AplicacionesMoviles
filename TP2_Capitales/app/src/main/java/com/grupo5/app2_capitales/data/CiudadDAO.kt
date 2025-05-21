package com.grupo5.app2_capitales.data

import androidx.room.*

@Dao
interface CiudadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(ciudad: Ciudad)

    @Query("SELECT * FROM ciudades WHERE nombreCiudad = :nombre")
    suspend fun obtenerPorNombre(nombre: String): Ciudad?

    @Query("DELETE FROM ciudades WHERE nombreCiudad = :nombre")
    suspend fun borrarPorNombre(nombre: String)

    @Query("SELECT COUNT(*) FROM ciudades WHERE nombrePais = :pais")
    suspend fun contarCiudadesPorPais(pais: String): Int

    @Query("DELETE FROM ciudades WHERE nombrePais = :pais")
    suspend fun borrarPorPais(pais: String)

    @Query("UPDATE ciudades SET poblacion = :nuevaPoblacion WHERE nombreCiudad = :nombre")
    suspend fun actualizarPoblacion(nombre: String, nuevaPoblacion: Int)
}

