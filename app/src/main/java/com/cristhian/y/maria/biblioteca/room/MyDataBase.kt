package com.cristhian.y.maria.biblioteca.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cristhian.y.maria.biblioteca.room.dao.*
import com.cristhian.y.maria.biblioteca.room.models.*
import java.util.Objects

@Database(entities = [
    AutorModel::class,
    ClienteModel::class,
    IdiomaModel::class,
    LibroModel::class,
    PrestamoModel::class], version = 2)
abstract class MyDataBase : RoomDatabase() {

    abstract fun AutorDao(): AutorDao
    abstract fun ClienteDao(): ClienteDao
    abstract fun IdiomaDao(): IdiomaDao
    abstract fun LibroDao(): LibroDao
    abstract fun PrestamoDao(): PrestamoDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MyDataBase? = null

        fun getDatabase(context: Context): MyDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDataBase::class.java,
                    "MyDataBase"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}