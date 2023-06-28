package com.cristhian.y.maria.biblioteca

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.cristhian.y.maria.biblioteca.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvEmail.setText(intent.getStringExtra("email"))

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
        }

        else if(item.itemId == R.id.menu_salir)
        {
            GoogleSignIn.getClient(this, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(getString(R.string.web_client_id))
                .build())
            .signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

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