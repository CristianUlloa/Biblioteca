package com.cristhian.y.maria.biblioteca.room.dao

import androidx.lifecycle.LiveData
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
/*
    @Query("SELECT * FROM libro WHERE libroID=:libroId ")
    fun getLibroById(libroId: Int): LiveData<LibroDao>

    @Query("SELECT * FROM libro WHERE libroID=:autorId ")
    fun getLibrosByAutor(autorId: Int): Flow<List<LibroDao>>

    @Query("SELECT * FROM idioma WHERE idioma=:idiomaId ")
    fun getLibrosByIdioma(idiomaId: String): Flow<List<LibroDao>>

 */
}