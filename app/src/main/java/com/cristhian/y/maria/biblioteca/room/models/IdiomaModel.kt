package com.cristhian.y.maria.biblioteca.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "idioma")
data class IdiomaModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "idioma") val idioma: String,
)