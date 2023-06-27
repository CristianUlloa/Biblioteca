package com.cristhian.y.maria.biblioteca

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cristhian.y.maria.biblioteca.databinding.ActivityLoginBinding
import com.cristhian.y.maria.biblioteca.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val KEY_PREFS: String = "login_prefs";
    private val EMAIL: String = "email"
    private val PROVIDER: String = "provider"

    private val GOOGLE_INT_KEY: Int = 100;

    private fun setup(email: String?, provider: String?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString(EMAIL)
        val provider: String? = bundle?.getString(PROVIDER)

        setup(email, provider)

        val prefs = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE).edit()
        prefs.putString(EMAIL, email)
        prefs.putString(PROVIDER, provider)
        prefs.apply()

        session();

        binding.btnGoogle.setOnClickListener {
            val count = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build()

            val client = GoogleSignIn.getClient(this, count)

            startActivityForResult(client.signInIntent, GOOGLE_INT_KEY)
        }
    }

    private fun session() {
        val prefs = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        val email: String? = prefs?.getString(EMAIL, null)
        val provider: String? = prefs?.getString(PROVIDER, null)

        if(email != null && provider != null)
        {
            startMainActivity(email, provider);
        }

    }

    private fun startMainActivity(email: String, provider: String) {

    }
}