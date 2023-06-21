package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityAddPrestamoBinding
import com.cristhian.y.maria.biblioteca.room.models.PrestamoModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.ClienteViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.LibroViewModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.PrestamoViewModel

class ActivityAddPrestamo : AppCompatActivity() {
    private lateinit var binding: ActivityAddPrestamoBinding
    private lateinit var viewModel: PrestamoViewModel
    private lateinit var viewModelCliente: ClienteViewModel
    private lateinit var viewModelLibro: LibroViewModel

    private  var adapterCliente: ArrayAdapter<String>? = null
    private  var adapterLibro: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPrestamoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapterCliente = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayOf<String>())
        adapterLibro = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayOf<String>())

        updateAdapters()

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            PrestamoViewModel::class.java)
        viewModelCliente = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            ClienteViewModel::class.java)
        viewModelLibro = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            LibroViewModel::class.java)
        observeEvents()
    }

    private fun updateAdapters() {
        binding.SPNcliente.adapter = adapterCliente
        binding.SPNlibro.adapter = adapterLibro

        adapterCliente?.notifyDataSetChanged()
        adapterLibro?.notifyDataSetChanged()
    }

    private fun observeEvents() {
        viewModelCliente.listaClientes.observe(this, Observer { list ->
            list?.let {
                adapterCliente =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.getNombreCopleto()
                    }.toTypedArray());
            }
        })
        viewModelLibro.listaLibros.observe(this, Observer { list ->
            list?.let {
                adapterLibro =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.idioma
                    }.toTypedArray());
            }
        })
        updateAdapters()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            val prestamo =
                viewModelLibro.listaLibros.value?.get(binding.SPNlibro.selectedItemPosition)?.let {
                    viewModelCliente.listaClientes.value?.get(binding.SPNcliente.selectedItemPosition)
                        ?.let { it1 ->
                            PrestamoModel(
                                0,
                                binding.ETfechaPrestamo.text.toString(),
                                binding.ETfechaEntrega.text.toString(),
                                it.id,
                                it1.id,
                            )
                        }
                }
            if (prestamo != null) {
                viewModel.insertPrestamo(prestamo)
            }
            finish()
        } else if(item.itemId == R.id.menu_btn_cancelar)
        {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.aceptar_cancelar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}