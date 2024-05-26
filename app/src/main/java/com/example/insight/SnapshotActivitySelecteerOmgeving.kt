package com.example.insight

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class SnapshotActivitySelecteerOmgeving : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_selecteer_omgeving)
        supportActionBar!!.hide()

        val backToSnapshotTemplateAanmaken = findViewById<ImageView>(R.id.backToSnapshotTemplateAanmaken)
        backToSnapshotTemplateAanmaken.setOnClickListener{
            replaceActivity (SnapshotActivityTemplateAanmaken())
        }

        val legoTemplateButton = findViewById<AppCompatButton>(R.id.legoTemplateButton)
        legoTemplateButton.setOnClickListener{
            legoTemplateButton.setBackgroundResource(R.drawable.vak_template_green)
        }

        //val infraTemplateButton = findViewById<AppCompatButton>(R.id.infraTemplateButton)
        //val productieTemplateButton = findViewById<AppCompatButton>(R.id.productieTemplateButton)
        //val zorgTemplateButton = findViewById<AppCompatButton>(R.id.zorgTemplateButton)
        //val engineeringTemplateButton = findViewById<AppCompatButton>(R.id.engineeringTemplateButton)
        //val kantoorTemplateButton = findViewById<AppCompatButton>(R.id.kantoorTemplateButton)
    }
    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        intent.putExtra("FROM_ACTIVITY", "SELECT_OMGEVING")
        startActivity(intent)
    }
}