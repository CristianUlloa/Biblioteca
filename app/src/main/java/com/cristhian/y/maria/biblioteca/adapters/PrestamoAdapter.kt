package com.cristhian.y.maria.biblioteca.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristhian.y.maria.biblioteca.databinding.Item4tvBinding
import com.cristhian.y.maria.biblioteca.room.models.PrestamoModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.ClienteViewModel

class PrestamoAdapter(var datalist: List<PrestamoModel>, val viewModel: ClienteViewModel) : RecyclerView.Adapter<PrestamoAdapter.PrestamoHolder>() {

    inner class PrestamoHolder(val binding: Item4tvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrestamoHolder {
        val binding = Item4tvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PrestamoHolder(binding)
    }

    override fun onBindViewHolder(holder: PrestamoHolder, position: Int) {
        val item = datalist[position]
        holder.binding.tv1.text = "Cliente: " + (viewModel.listaClientes.value?.filter { c -> c.id == item.clienteId }
            ?.get(0)?.getNombreCopleto() ?: "")

        holder.binding.tv2.text = "Libro: " + item.libro
        holder.binding.tv3.text = "Fecha Prestamo: " + item.fechaPrestamo
        holder.binding.tv4.text = "Fecha Entrega: " + item.fechaEntrega
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}