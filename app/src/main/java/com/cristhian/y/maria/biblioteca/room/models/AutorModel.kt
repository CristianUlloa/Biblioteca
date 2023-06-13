package com.cristhian.y.maria.biblioteca.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "autor")
data class AutorModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "nombre_completo") val nombreCompleto: String,
    )