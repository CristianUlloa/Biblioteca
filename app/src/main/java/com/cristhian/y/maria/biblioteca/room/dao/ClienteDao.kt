package com.cristhian.y.maria.biblioteca.room.dao

import androidx.room.*
import com.cristhian.y.maria.biblioteca.room.models.ClienteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Query("SELECT * FROM cliente")
    fun getClientes(): Flow<List<ClienteModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveCliente(cliente: ClienteModel)

    @Update
    fun updateCliente(cliente: ClienteModel)

    @Query("DELETE FROM cliente")
    suspend fun clearClientes()

    @Delete
    suspend fun deleteCliente(cliente: ClienteModel)
}