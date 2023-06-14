package com.cristhian.y.maria.biblioteca.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cristhian.y.maria.biblioteca.room.MyDataBase
import com.cristhian.y.maria.biblioteca.room.models.ClienteModel
import com.cristhian.y.maria.biblioteca.room.repo.RepoCliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClienteViewModel (application: Application) : AndroidViewModel(application) {
    val listaClientes  : LiveData<List<ClienteModel>>
    val repository : RepoCliente

    init {
        val clienteDao = MyDataBase.getDatabase(application).ClienteDao()
        repository = RepoCliente(clienteDao)
        listaClientes = repository.getClientes()
    }
    fun insertGasto(cliente: ClienteModel) =
        viewModelScope.launch(Dispatchers.IO) { repository.saveCliente(cliente) }

    fun deleteGasto(cliente: ClienteModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCliente(cliente)
        }
}