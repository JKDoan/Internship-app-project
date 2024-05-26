package com.example.insight

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class ActivityLoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        supportActionBar!!.hide()

        val loginButton = findViewById<AppCompatButton>(R.id.loginButton)
        loginButton.setOnClickListener {
            replaceActivity(MainActivity())
        }
    }
    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}