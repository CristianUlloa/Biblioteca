package com.cristhian.y.maria.biblioteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cristhian.y.maria.biblioteca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_autor)
        {
            val intent = Intent(this, ActivityAutor::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_cliente)
        {
            val intent = Intent(this, ActivityCliente::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_idioma)
        {
            val intent = Intent(this, ActivityIdioma::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_libro)
        {
            val intent = Intent(this, ActivityLibro::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_prestamo)
        {
            val intent = Intent(this, ActivityPrestamo::class.java)
            startActivity(intent)
        }

        else if(item.itemId == R.id.menu_acerca_de)
        {
            //
        }else if(item.itemId == R.id.menu_salir)
        {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }
}