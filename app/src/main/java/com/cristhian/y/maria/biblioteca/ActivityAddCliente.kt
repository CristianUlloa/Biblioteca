package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityAddClienteBinding
import com.cristhian.y.maria.biblioteca.room.models.ClienteModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.ClienteViewModel

class ActivityAddCliente : AppCompatActivity() {
    private lateinit var binding: ActivityAddClienteBinding
    private lateinit var viewModel: ClienteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClienteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            ClienteViewModel::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            val cliente = ClienteModel(
                0,
                binding.ETprimerNombre.text.toString(),
                binding.ETsegundoNombre.text.toString(),
                binding.ETprimerApellido.text.toString(),
                binding.ETsegundoApellido.text.toString(),
                binding.ETtelefono.text.toString(),
                binding.ETcarnet.text.toString(),
                binding.ETdireccion.text.toString()
                )
            viewModel.insertCliente(cliente)
            finish()
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