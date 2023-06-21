package com.cristhian.y.maria.biblioteca

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristhian.y.maria.biblioteca.adapters.ClienteAdapter
import com.cristhian.y.maria.biblioteca.databinding.ActivityClienteBinding
import com.cristhian.y.maria.biblioteca.room.viewmodels.AutorViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.ClienteViewModel

class ActivityCliente : BaseAddActivity() {
    private lateinit var binding: ActivityClienteBinding
    private lateinit var viewModel: ClienteViewModel
    private lateinit var adapter: ClienteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.listCliente.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            ClienteViewModel::class.java)
        observeEvents()
    }
    private fun observeEvents() {
        viewModel.listaClientes.observe(this, Observer { list ->
            list?.let {

                adapter = ClienteAdapter(it)
                binding.listCliente.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddCliente::class.java)
        return super.onOptionsItemSelected(item)
    }
}