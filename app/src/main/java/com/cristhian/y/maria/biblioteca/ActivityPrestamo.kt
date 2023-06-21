package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristhian.y.maria.biblioteca.adapters.PrestamoAdapter
import com.cristhian.y.maria.biblioteca.databinding.ActivityPrestamoBinding
import com.cristhian.y.maria.biblioteca.room.viewmodels.ClienteViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.PrestamoViewModel

class ActivityPrestamo : BaseAddActivity() {
    private lateinit var binding: ActivityPrestamoBinding
    private lateinit var viewModel: PrestamoViewModel
    private lateinit var viewModelCliente: ClienteViewModel
    private lateinit var adapter: PrestamoAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrestamoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.listPrestamo.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            PrestamoViewModel::class.java)
        viewModelCliente = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            ClienteViewModel::class.java)
        observeEvents()
    }
    private fun observeEvents() {
        viewModel.listaPrestamos.observe(this, Observer { list ->
            list?.let {

                adapter = PrestamoAdapter(it, viewModelCliente)
                binding.listPrestamo.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddPrestamo::class.java)
        return super.onOptionsItemSelected(item)
    }
}