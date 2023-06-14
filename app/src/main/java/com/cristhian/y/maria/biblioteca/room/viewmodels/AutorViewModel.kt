package com.cristhian.y.maria.biblioteca.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cristhian.y.maria.biblioteca.room.MyDataBase
import com.cristhian.y.maria.biblioteca.room.models.AutorModel
import com.cristhian.y.maria.biblioteca.room.repo.RepoAutor
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class AutorViewModel (application: Application) : AndroidViewModel(application) {
    val listaAutores  : LiveData<List<AutorModel>>
    val repository : RepoAutor

    init {
        val autorDao = MyDataBase.getDatabase(application).AutorDao()
        repository = RepoAutor(autorDao)
        listaAutores = repository.getAutores()
    }
    fun insertGasto(autor: AutorModel) =
        viewModelScope.launch(Dispatchers.IO) { repository.saveAutor(autor) }

    fun deleteGasto(autor: AutorModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAutor(autor)
        }
}