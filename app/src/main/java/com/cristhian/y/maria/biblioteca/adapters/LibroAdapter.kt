package com.cristhian.y.maria.biblioteca.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristhian.y.maria.biblioteca.databinding.Item4tvBinding
import com.cristhian.y.maria.biblioteca.room.models.LibroModel

class LibroAdapter(var datalist: List<LibroModel>) : RecyclerView.Adapter<LibroAdapter.LibroHolder>() {

    inner class LibroHolder(val binding: Item4tvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroHolder {
        val binding = Item4tvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LibroHolder(binding)
    }

    override fun onBindViewHolder(holder: LibroHolder, position: Int) {
        val item = datalist[position]
        holder.binding.tv1.text = "Titulo: " + item.titulo
        holder.binding.tv2.text = "Autor: " + item.autor
        holder.binding.tv3.text = "Idioma: " + item.idioma
        holder.binding.tv4.text = "Cantidad: " + item.cantidad
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}