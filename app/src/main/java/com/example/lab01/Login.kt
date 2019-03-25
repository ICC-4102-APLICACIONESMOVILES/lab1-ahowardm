package com.example.lab01

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
    var username: String = ""
    var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getUIReferences()
        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        username = usernameEditText.text.toString()
        password = passwordEditText.text.toString()
        if (isEmailValid(username) && !password.equals("")){

            Toast.makeText(this, "Valid login info", Toast.LENGTH_SHORT).show()
            //var intent = getIntent()
            //intent.putExtra("username", username)
            //intent.putExtra("password", password)

            finish()
        }
    }

    private fun getUIReferences() {
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
