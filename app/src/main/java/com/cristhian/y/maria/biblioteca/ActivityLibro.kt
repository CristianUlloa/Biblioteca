package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristhian.y.maria.biblioteca.adapters.LibroAdapter
import com.cristhian.y.maria.biblioteca.databinding.ActivityLibroBinding
import com.cristhian.y.maria.biblioteca.room.viewmodels.LibroViewModel

class ActivityLibro : BaseAddActivity() {
    private lateinit var binding: ActivityLibroBinding
    private lateinit var viewModel: LibroViewModel
    private lateinit var adapter: LibroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.listLibro.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            LibroViewModel::class.java)
        observeEvents()
    }
    private fun observeEvents() {
        viewModel.listaLibros.observe(this, Observer { list ->
            list?.let {

                adapter = LibroAdapter(it)
                binding.listLibro.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddLibro::class.java)
        return super.onOptionsItemSelected(item)
    }
}