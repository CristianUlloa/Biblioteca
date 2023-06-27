package com.cristhian.y.maria.biblioteca

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityIdiomaBinding
import com.cristhian.y.maria.biblioteca.room.viewmodels.AutorViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.IdiomaViewModel

class ActivityIdioma : BaseAddActivity() {
    private lateinit var binding: ActivityIdiomaBinding
    private lateinit var viewModel: IdiomaViewModel
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdiomaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(IdiomaViewModel::class.java)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.listaIdiomas.observe(this, Observer { list ->
            list?.let {
                val items = it.map {
                    it.idioma
                }.toTypedArray();
                adapter = ArrayAdapter(this, R.layout.simple_list_item_1, items)
                binding.listIdioma.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddIdioma::class.java)
        return super.onOptionsItemSelected(item)
    }
}