package com.cristhian.y.maria.biblioteca.room.dao

import androidx.room.*
import com.cristhian.y.maria.biblioteca.room.models.AutorModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AutorDao {
    @Query("SELECT * FROM autor")
    fun getAutores(): Flow<List<AutorModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveAutor(libro: AutorModel)

    @Update
    fun updateAutor(libro: AutorModel)

    @Query("DELETE FROM libro")
    suspend fun clearAutores()

    @Delete
    suspend fun deleteAutor(libro: AutorModel)
}