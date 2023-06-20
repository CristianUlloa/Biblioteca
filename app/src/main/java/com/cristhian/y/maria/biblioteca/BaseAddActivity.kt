package com.cristhian.y.maria.biblioteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

abstract class BaseAddActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    protected fun startAddActivity(mclass: Class<*>) {
        val intent = Intent(this, mclass)
        startActivity(intent)
    }
}