package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SnapshotActivityHoofdschermInstellen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_hoofdscherm_instellen)
        supportActionBar!!.hide()

        val backToTemplateAanmaken = requireViewById<ImageButton>(R.id.backToTemplateAanmaken)
        backToTemplateAanmaken.setOnClickListener {
            finish()
        }

        val niveau1RadioButton = requireViewById<RadioButton>(R.id.niveau1RadioButton)
        val niveau2RadioButton = requireViewById<RadioButton>(R.id.niveau2RadioButton)
        val niveau3RadioButton = requireViewById<RadioButton>(R.id.niveau3RadioButton)

        var check1 = false // initial state of your radio button
        var check2 = false
        var check3 = false

        niveau1RadioButton.setOnClickListener {
            if (check1) {
                niveau1RadioButton.isChecked = false
                check1 = false
            } else {
                check1 = true
                check2 = false
                niveau2RadioButton.isChecked = false
                check3 = false
                niveau3RadioButton.isChecked = false
            }
        }

        niveau2RadioButton.setOnClickListener {
            if (check2) {
                niveau2RadioButton.isChecked = false
                check2 = false
            } else {
                check1 = false
                niveau1RadioButton.isChecked = false
                check2 = true
                check3 = false
                niveau3RadioButton.isChecked = false
            }
        }

        niveau3RadioButton.setOnClickListener {
            if (check3) {
                niveau3RadioButton.isChecked = false
                check3 = false
            } else {
                check3 = true
                check2 =  false
                niveau2RadioButton.isChecked = false
                check1 =  false
                niveau1RadioButton.isChecked = false
            }
        }
    }
}