package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.annotation.RequiresApi

class SnapshotActivityHoofdschermInstellenInMeting : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_hoofdscherm_instellen_in_meting)
        supportActionBar!!.hide()

        val backToWerkwoorden = requireViewById<ImageButton>(R.id.backToWerkwoorden)
        backToWerkwoorden.setOnClickListener {
            replaceActivity(SnapshotActivityMeting())
        }

        val niveau1RadioButton = requireViewById<RadioButton>(R.id.niveau1RadioButton)
        val niveau2RadioButton = requireViewById<RadioButton>(R.id.niveau2RadioButton)
        val niveau3RadioButton = requireViewById<RadioButton>(R.id.niveau3RadioButton)

        var check1 = false // initial state of your radio button
        niveau1RadioButton.setOnClickListener {
            if (check1) {
                niveau1RadioButton.isChecked = false
                check1 = false
            } else {
                check1 = true
                niveau1RadioButton.isChecked = true
                niveau2RadioButton.isChecked = false
                niveau3RadioButton.isChecked = false
            }
        }

        var check2 = false
        niveau2RadioButton.setOnClickListener {
            if (check2) {
                niveau2RadioButton.isChecked = false
                check2 = false
            } else {
                check2 = true
                niveau1RadioButton.isChecked = false
                niveau2RadioButton.isChecked = true
                niveau3RadioButton.isChecked = false
            }
        }

        var check3 = false
        niveau3RadioButton.setOnClickListener {
            if (check3) {
                niveau3RadioButton.isChecked = false
                check3 = false
            } else {
                check3 = true
                niveau1RadioButton.isChecked = false
                niveau2RadioButton.isChecked = false
                niveau3RadioButton.isChecked = true
            }
        }
    }
    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        intent.putExtra("FROM_ACTIVITY", "INSTELLINGEN")
        // put extra info in intent to provoke te correct fragment to load
        startActivity(intent)
    }
}