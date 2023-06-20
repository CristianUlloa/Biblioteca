package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityAddLibroBinding
import com.cristhian.y.maria.biblioteca.room.models.LibroModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.AutorViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.IdiomaViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.LibroViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityAddLibro : AppCompatActivity() {
    private lateinit var binding: ActivityAddLibroBinding
    private lateinit var viewModel: LibroViewModel
    private lateinit var viewModelAutor: AutorViewModel
    private lateinit var viewModelIdioma: IdiomaViewModel

    private  var adapterAutor: ArrayAdapter<String>? = null
    private  var adapterIdioma: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddLibroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapterAutor = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayOf<String>())
        adapterIdioma = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayOf<String>())

        updateAdapters()

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            LibroViewModel::class.java)
        viewModelAutor = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            AutorViewModel::class.java)
        viewModelIdioma = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            IdiomaViewModel::class.java)
        observeEvents()
    }

    private fun updateAdapters() {
        binding.SPNautor.adapter = adapterAutor
        binding.SPNidioma.adapter = adapterIdioma

        adapterAutor?.notifyDataSetChanged()
        adapterIdioma?.notifyDataSetChanged()
    }

    private fun observeEvents() {
        viewModelAutor.listaAutores.observe(this, Observer { list ->
            list?.let {
                adapterAutor =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.nombreCompleto
                    }.toTypedArray());
            }
            updateAdapters()
        })
        viewModelIdioma.listaIdiomas.observe(this, Observer { list ->
            list?.let {
                adapterIdioma =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.idioma
                    }.toTypedArray());
            }
            updateAdapters()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            GlobalScope.launch {
                val libro = LibroModel(
                    0,
                    binding.ETeditorial.text.toString(),
                    binding.SPNautor.selectedItem.toString(),
                    binding.ETtema.text.toString(),
                    binding.ETtitulo.text.toString(),
                    binding.SPNidioma.selectedItem.toString(),
                    binding.ETcantidad.text.toString().toInt(),
                    binding.ETcantidad.text.toString(),
                )
                Log.d("INSERT",binding.SPNautor.selectedItem.toString())
                Log.d("INSERT",binding.SPNidioma.selectedItem.toString())

                viewModel.insertLibro(libro)
                finish()
            }
        } else if(item.itemId == R.id.menu_btn_cancelar)
        {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_aceptar_cancelar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}