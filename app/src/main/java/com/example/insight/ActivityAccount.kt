package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ActivityAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        supportActionBar!!.hide()

        val backToHomescreen = findViewById<ImageButton>(R.id.backToHomescreenButton)
        backToHomescreen.setOnClickListener {
            replaceActivity(MainActivity())
        }

        val wachtwoordWijzigen = findViewById<AppCompatButton>(R.id.wachtwoordWijzigen)
        wachtwoordWijzigen.setOnClickListener {
            val wachtwoordWijzigenDialog = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val addTemplate: View = inflater.inflate(R.layout.dialog_wachtwoord_wijzigen, null)

            wachtwoordWijzigenDialog.setTitle("Wachtwoord wijzigen")
                .setMessage("Geef het nieuwe wachtwoord in")
                .setView(addTemplate)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Aanpassen") { _, _ ->
                    val wachtwoordAangepastDialog = AlertDialog.Builder(this)

                    wachtwoordAangepastDialog.setTitle("Wachtwoord wijzigen")
                        .setMessage("Wachtwoord gewijzigd!")
                        .setPositiveButton("OK", null)
                        .show()
                }
                .show()
        }

        val uitloggenButton = findViewById<AppCompatButton>(R.id.uitloggenButton)
        uitloggenButton.setOnClickListener {
            replaceActivity(ActivityLoginScreen())
        }
    }

    private fun replaceActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}