package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityAddIdiomaBinding
import com.cristhian.y.maria.biblioteca.room.models.IdiomaModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.IdiomaViewModel

class ActivityAddIdioma : AppCompatActivity() {
    private lateinit var binding: ActivityAddIdiomaBinding
    private lateinit var viewModel: IdiomaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddIdiomaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            IdiomaViewModel::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            val idioma = IdiomaModel(
                binding.ETidioma.text.toString()
            )
            viewModel.insertIdioma(idioma)
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