package com.cristhian.y.maria.biblioteca

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cristhian.y.maria.biblioteca.databinding.ActivityAddActorBinding
import com.cristhian.y.maria.biblioteca.room.models.AutorModel
import com.cristhian.y.maria.biblioteca.room.viewmodels.AutorViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityAddAutor : AppCompatActivity() {
    private lateinit var binding: ActivityAddActorBinding
    private lateinit var viewModel: AutorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddActorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(AutorViewModel::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            GlobalScope.launch {
                val autor = AutorModel(binding.ETnombreCompleto.text.toString())
                viewModel.insertAutor(autor)
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
        inflater.inflate(R.menu.aceptar_cancelar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}