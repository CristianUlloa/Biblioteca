package com.cristhian.y.maria.biblioteca.room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cristhian.y.maria.biblioteca.room.dao.IdiomaDao
import com.cristhian.y.maria.biblioteca.room.models.IdiomaModel

class RepoIdioma constructor(
    private val idiomaDao: IdiomaDao
)
{
    fun getIdiomas(): LiveData<List<IdiomaModel>> = idiomaDao.getIdiomas().asLiveData()

    suspend fun saveIdioma(idioma: IdiomaModel){
        idiomaDao.saveIdioma(idioma)
    }

    suspend fun deleteIdioma(idioma: IdiomaModel)
    {
        idiomaDao.deleteIdioma(idioma)
    }
}