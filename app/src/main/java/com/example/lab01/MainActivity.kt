package com.example.lab01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var usernameTextView: TextView
    lateinit var passwordTextView: TextView
    lateinit var logoutButton: Button
    val LOGIN_REQUEST = 1
    var loggedIn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUIReferences()
        goToNextActivity()
        logoutButton.setOnClickListener{
            logout()
        }
    }

    private fun logout() {
        recreate()
    }

    private fun goToNextActivity() {
        var intent = Intent(this, Login::class.java)
        startActivityForResult(intent, LOGIN_REQUEST)
    }

    private fun getUIReferences() {
        usernameTextView = findViewById(R.id.usernameTextView)
        passwordTextView = findViewById(R.id.passwordTextView)
        logoutButton = findViewById(R.id.logoutButton)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LOGIN_REQUEST){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT)
                var username = data?.getStringExtra(Login.username).toString()
                usernameTextView.text = username
                passwordTextView.text = data?.getStringExtra(Login.password).toString()
            }
        }
    }
}
