package com.example.insight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog

class SnapshotActivityTemplateAanmaken : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_template_aanmaken)
        supportActionBar!!.hide()

        val backToSnapshotHomescreen = findViewById<ImageView>(R.id.backToSnapshotHomescreen)
        backToSnapshotHomescreen.setOnClickListener{
            val saveChangesDialog = AlertDialog.Builder(this)

            saveChangesDialog.setTitle("Wijzigingen opslaan")
                .setMessage("Wil je de wijzigingen opslaan?")
                .setNegativeButton("Nee") { _, _ ->
                    val intent = Intent(this, SnapshotActivityHomescreen::class.java)
                    intent.putExtra("FROM_ACTIVITY", "SELECT_OMGEVING")
                    startActivity(intent)
                }
                .setPositiveButton("Ja") { _, _ ->
                    val intent = Intent(this, SnapshotActivityHomescreen::class.java)
                    intent.putExtra("FROM_ACTIVITY", "SELECT_OMGEVING")
                    startActivity(intent)
                }
                .show()
        }
    }
}