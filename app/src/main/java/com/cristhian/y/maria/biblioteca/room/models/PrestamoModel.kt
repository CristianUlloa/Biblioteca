package com.cristhian.y.maria.biblioteca.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "prestamo", foreignKeys = [
    ForeignKey(
        entity = LibroModel::class,
        parentColumns = arrayOf("libroID"),
        childColumns = arrayOf("libro"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = ClienteModel::class,
        parentColumns = arrayOf("clienteID"),
        childColumns = arrayOf("cliente"),
        onDelete = ForeignKey.CASCADE
    ),
])
data class PrestamoModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "prestamoID") val id: Int,
    @ColumnInfo(name = "fecha_prestamo") val fechaPrestamo: String,
    @ColumnInfo(name = "fecha_entrega") val fechaEntrega: String,
    @ColumnInfo(name = "libro") val libroId: Int,
    @ColumnInfo(name = "cliente") val clienteId: Int,
    )
