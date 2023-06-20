package com.cristhian.y.maria.biblioteca

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityAutorBinding
import com.cristhian.y.maria.biblioteca.room.viewmodels.AutorViewModel

class ActivityAutor  : BaseAddActivity() {
    private lateinit var binding: ActivityAutorBinding
    private lateinit var viewModel: AutorViewModel
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(AutorViewModel::class.java)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.listaAutores.observe(this, Observer { list ->
            list?.let {
                val items = it.map {
                    it.nombreCompleto
                }.toTypedArray();
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
                binding.listAutor.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddAutor::class.java)
        return super.onOptionsItemSelected(item)
    }

}