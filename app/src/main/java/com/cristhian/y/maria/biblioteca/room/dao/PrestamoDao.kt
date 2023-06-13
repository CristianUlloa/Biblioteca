package com.cristhian.y.maria.biblioteca.room.dao

import androidx.room.*
import com.cristhian.y.maria.biblioteca.room.models.PrestamoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Query("SELECT * FROM prestamo")
    fun getPrestamos(): Flow<List<PrestamoModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun savePrestamo(prestamo: PrestamoModel)

    @Update
    fun updatePrestamo(prestamo: PrestamoModel)

    @Query("DELETE FROM prestamo")
    suspend fun clearPrestamos()

    @Delete
    suspend fun deletePrestamo(prestamo: PrestamoModel)
}