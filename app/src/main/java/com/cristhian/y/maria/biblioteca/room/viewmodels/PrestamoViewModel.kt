package com.cristhian.y.maria.biblioteca.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cristhian.y.maria.biblioteca.room.MyDataBase
import com.cristhian.y.maria.biblioteca.room.models.PrestamoModel
import com.cristhian.y.maria.biblioteca.room.repo.RepoPrestamo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrestamoViewModel(application: Application) : AndroidViewModel(application) {
    val listaPrestamos  : LiveData<List<PrestamoModel>>
    val repository : RepoPrestamo

    init {
        val prestamoDao = MyDataBase.getDatabase(application).PrestamoDao()
        repository = RepoPrestamo(prestamoDao)
        listaPrestamos = repository.getPrestamos()
    }
    fun insertPrestamo(prestamo: PrestamoModel) =
        viewModelScope.launch(Dispatchers.IO) { repository.savePrestamo(prestamo) }

    fun deletePrestamo(prestamo: PrestamoModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePrestamo(prestamo)
        }
}