package com.cristhian.y.maria.biblioteca.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cliente")
 class ClienteModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "clienteID") val id: Int,
    @ColumnInfo(name = "primer_nombre")  val primerNombre: String,
    @ColumnInfo(name = "segundo_nombre")  val segundoNombre: String,
    @ColumnInfo(name = "primer_apellido")  val primerApellido: String,
    @ColumnInfo(name = "segundo_nombre")  val segundoApellido: String,
    @ColumnInfo(name = "telefono")  val telefono: String,
    @ColumnInfo(name = "carnet")  val carnet: String,
    @ColumnInfo(name = "dirrecion")  val dirrecion: String,

    )
{
     public fun getNombreCopleto(): String {
         val b =  java.lang.StringBuilder(primerNombre).
         append(" ").append(segundoNombre).
         append(" ").append(primerApellido).
         append(" ").append(segundoApellido)
         return b.toString()
     }
 }
