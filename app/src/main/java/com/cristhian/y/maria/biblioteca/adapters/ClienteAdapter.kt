package com.cristhian.y.maria.biblioteca.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristhian.y.maria.biblioteca.databinding.Item4tvBinding
import com.cristhian.y.maria.biblioteca.room.models.ClienteModel

class ClienteAdapter(var datalist: List<ClienteModel>) : RecyclerView.Adapter<ClienteAdapter.ClienteHolder>() {

    inner class ClienteHolder(val binding: Item4tvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteHolder {
        val binding = Item4tvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClienteHolder(binding)
    }

    override fun onBindViewHolder(holder: ClienteHolder, position: Int) {
        val item = datalist.get(position)
        holder.binding.tv1.text = "Nombre: " + item.getNombreCopleto()
        holder.binding.tv2.text = "Telefono: " + item.telefono
        holder.binding.tv3.text = "Carnet: " + item.carnet
        holder.binding.tv4.text = "Direccion: " + item.direccion
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}