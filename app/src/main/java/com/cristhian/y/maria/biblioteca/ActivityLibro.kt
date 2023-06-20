package com.cristhian.y.maria.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.cristhian.y.maria.biblioteca.databinding.ActivityLibroBinding

class ActivityLibro : BaseAddActivity() {
    private lateinit var binding: ActivityLibroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startAddActivity(ActivityAddLibro::class.java)
        return super.onOptionsItemSelected(item)
    }
}