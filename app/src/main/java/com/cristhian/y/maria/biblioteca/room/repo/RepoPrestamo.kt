package com.cristhian.y.maria.biblioteca.room.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cristhian.y.maria.biblioteca.room.dao.PrestamoDao
import com.cristhian.y.maria.biblioteca.room.models.PrestamoModel

class RepoPrestamo constructor(
    private val prestamoDao: PrestamoDao
)
{
    fun getPrestamos(): LiveData<List<PrestamoModel>> = prestamoDao.getPrestamos().asLiveData()

    suspend fun savePrestamo(idioma: PrestamoModel){
        prestamoDao.savePrestamo(idioma)
    }

    suspend fun deletePrestamo(idioma: PrestamoModel)
    {
        prestamoDao.deletePrestamo(idioma)
    }
}