package com.cristhian.y.maria.biblioteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cristhian.y.maria.biblioteca.databinding.ActivityMainBinding
import com.cristhian.y.maria.biblioteca.room.models.PrestamoModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_add_autor)
        {
            val intent = Intent(this, ActivityAddAutor::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_add_cliente)
        {
            val intent = Intent(this, ActivityAddCliente::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_add_libro)
        {
            val intent = Intent(this, ActivityAddLibro::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_add_prestamo)
        {
            val intent = Intent(this, ActivityAddPrestamo::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_salir)
        {
            finish()
        }else if(item.itemId == R.id.menu_acerca_de)
        {
            //
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }
}