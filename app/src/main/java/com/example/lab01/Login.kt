package com.example.lab01

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button

    companion object {
        val username = "username"
        val password = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getUIReferences()
        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        var username = usernameEditText.text.toString()
        var password = passwordEditText.text.toString()
        if (isEmailValid(username) && !password.equals("")){

            Toast.makeText(this, "Valid login info", Toast.LENGTH_SHORT).show()
            var result = Intent()
            result.putExtra("username", username)
            result.putExtra("password", password)
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }

    private fun getUIReferences() {
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }

    /**
     * Este metodo fue buscado en internet para validar direcciones de email.
     * Fuente: https://gist.github.com/ironic-name/f8e8479c76e80d470cacd91001e7b45b
     */
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
