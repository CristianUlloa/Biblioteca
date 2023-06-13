package com.cristhian.y.maria.biblioteca.room.dao

import androidx.room.*
import com.cristhian.y.maria.biblioteca.room.models.LibroModel
import kotlinx.coroutines.flow.Flow

@Dao
interface LibroDao {
    @Query("SELECT * FROM libro")
    fun getLibros(): Flow<List<LibroModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveLibro(libro: LibroModel)

    @Update
    fun updateLibro(libro: LibroModel)

    @Query("DELETE FROM libro")
    suspend fun clearLibros()

    @Delete
    suspend fun deleteLibro(libro: LibroModel)
}