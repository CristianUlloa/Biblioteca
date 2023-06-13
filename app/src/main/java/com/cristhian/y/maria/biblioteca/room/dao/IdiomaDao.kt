package com.cristhian.y.maria.biblioteca.room.dao

import androidx.room.*
import com.cristhian.y.maria.biblioteca.room.models.IdiomaModel
import kotlinx.coroutines.flow.Flow

@Dao
interface IdiomaDao {
    @Query("SELECT * FROM idioma")
    fun getIdiomas(): Flow<List<IdiomaModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveIdioma(idioma: IdiomaModel)

    @Update
    fun updateIdioma(idioma: IdiomaModel)

    @Query("DELETE FROM idioma")
    suspend fun clearIdiomas()

    @Delete
    suspend fun deleteIdioma(idioma: IdiomaModel)
}