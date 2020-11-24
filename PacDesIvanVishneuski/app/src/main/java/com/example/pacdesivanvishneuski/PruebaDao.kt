package com.example.pacdesivanvishneuski

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PruebaDao {

    @Query("SELECT * FROM Ejemplo")
    suspend fun getTabla(): List<EjemploEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEntrada(entrada: EjemploEntity)

}