package com.cristhian.y.maria.biblioteca.room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cristhian.y.maria.biblioteca.room.dao.AutorDao
import com.cristhian.y.maria.biblioteca.room.models.AutorModel

class RepoAutor constructor(
    private val autorDao: AutorDao
)
{
    fun getAutores(): LiveData<List<AutorModel>> = autorDao.getAutores().asLiveData()

    suspend fun saveAutor(autor: AutorModel){
        autorDao.saveAutor(autor)
    }

    suspend fun deleteAutor(autor: AutorModel)
    {
        autorDao.deleteAutor(autor)
    }
}