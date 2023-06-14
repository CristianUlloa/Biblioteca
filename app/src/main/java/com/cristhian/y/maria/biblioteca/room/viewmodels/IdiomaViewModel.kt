package com.cristhian.y.maria.biblioteca.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cristhian.y.maria.biblioteca.room.MyDataBase
import com.cristhian.y.maria.biblioteca.room.models.IdiomaModel
import com.cristhian.y.maria.biblioteca.room.repo.RepoIdioma
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IdiomaViewModel(application: Application) : AndroidViewModel(application) {
    val listaIdiomas  : LiveData<List<IdiomaModel>>
    val repository : RepoIdioma

    init {
        val idiomaDao = MyDataBase.getDatabase(application).IdiomaDao()
        repository = RepoIdioma(idiomaDao)
        listaIdiomas = repository.getIdiomas()
    }
    fun insertGasto(idioma: IdiomaModel) =
        viewModelScope.launch(Dispatchers.IO) { repository.saveIdioma(idioma) }

    fun deleteGasto(idioma: IdiomaModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteIdioma(idioma)
        }
}