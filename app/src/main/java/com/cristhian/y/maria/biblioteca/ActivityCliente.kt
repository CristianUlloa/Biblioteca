package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.cristhian.y.maria.biblioteca.databinding.ActivityClienteBinding

class ActivityCliente : BaseAddActivity() {
    private lateinit var binding: ActivityClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddCliente::class.java)
        return super.onOptionsItemSelected(item)
    }
}