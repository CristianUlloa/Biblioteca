package com.cristhian.y.maria.biblioteca.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cristhian.y.maria.biblioteca.room.MyDataBase
import com.cristhian.y.maria.biblioteca.room.models.LibroModel
import com.cristhian.y.maria.biblioteca.room.repo.RepoLibro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibroViewModel (application: Application) : AndroidViewModel(application) {
    val listaLibros  : LiveData<List<LibroModel>>
    val repository : RepoLibro

    init {
        val libroDao = MyDataBase.getDatabase(application).LibroDao()
        repository = RepoLibro(libroDao)
        listaLibros = repository.getLibros()
    }
    fun insertGasto(libro: LibroModel) =
        viewModelScope.launch(Dispatchers.IO) { repository.saveLibro(libro) }

    fun deleteGasto(libro: LibroModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteLibro(libro)
        }
}