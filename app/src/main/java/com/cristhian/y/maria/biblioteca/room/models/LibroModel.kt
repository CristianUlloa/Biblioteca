package com.cristhian.y.maria.biblioteca.room.models

import androidx.room.*
import java.util.Date

@Entity(tableName = "libro", foreignKeys = [
    ForeignKey(
        entity = AutorModel::class,
        parentColumns = arrayOf("nombre_completo"),
        childColumns = arrayOf("autor"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = IdiomaModel::class,
        parentColumns = arrayOf("idioma"),
        childColumns = arrayOf("idioma"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class LibroModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "libroID") val id: Int,
    @ColumnInfo(name = "editorial")  val editorial: String,
    @ColumnInfo(name = "autor")  val autorId: String,
    @ColumnInfo(name = "tema")  val tema: String,
    @ColumnInfo(name = "titulo")  val titulo: String,
    @ColumnInfo(name = "idioma")  val idioma: String,
    @ColumnInfo(name = "cantidad")  val cantidad: Int,
    @ColumnInfo(name = "fecha_lanzamiento")  val fechaLanzamiento: String,
    )
