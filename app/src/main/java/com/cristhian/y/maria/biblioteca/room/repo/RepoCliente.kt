package com.cristhian.y.maria.biblioteca.room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cristhian.y.maria.biblioteca.room.dao.ClienteDao
import com.cristhian.y.maria.biblioteca.room.models.ClienteModel

class RepoCliente constructor(
    private val clienteDao: ClienteDao
)
{
    fun getClientes(): LiveData<List<ClienteModel>> = clienteDao.getClientes().asLiveData()

    suspend fun saveCliente(cliente: ClienteModel){
        clienteDao.saveCliente(cliente)
    }

    suspend fun deleteCliente(cliente: ClienteModel)
    {
        clienteDao.deleteCliente(cliente)
    }
}