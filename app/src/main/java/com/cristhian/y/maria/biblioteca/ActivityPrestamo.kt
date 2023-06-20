package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.cristhian.y.maria.biblioteca.databinding.ActivityPrestamoBinding

class ActivityPrestamo : BaseAddActivity() {
    private lateinit var binding: ActivityPrestamoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrestamoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddPrestamo::class.java)
        return super.onOptionsItemSelected(item)
    }
}