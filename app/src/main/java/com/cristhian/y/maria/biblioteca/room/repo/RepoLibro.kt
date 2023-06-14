package com.cristhian.y.maria.biblioteca.room.repo

import androidx.lifecycle.LiveData
import com.cristhian.y.maria.biblioteca.room.dao.LibroDao
import com.cristhian.y.maria.biblioteca.room.models.LibroModel
import androidx.lifecycle.asLiveData


class RepoLibro constructor(
    private val libroDao: LibroDao
)
{
    fun getLibros(): LiveData<List<LibroModel>> = libroDao.getLibros().asLiveData()

    suspend fun saveLibro(libro: LibroModel){
        libroDao.saveLibro(libro)
    }

    suspend fun deleteLibro(libro: LibroModel)
    {
        libroDao.deleteLibro(libro)
    }


}