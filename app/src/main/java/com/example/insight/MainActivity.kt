package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val snapshotButton = findViewById<View>(R.id.buttonSnapshot)
        snapshotButton.setOnClickListener {
            replaceActivity(SnapshotActivityHomescreen())
        }

        val disturbanceButton = findViewById<View>(R.id.buttonDisturbance)
        disturbanceButton.setOnClickListener{
            replaceActivity(DisturbanceActivityHomescreen())
        }

        val settings = findViewById<ImageView>(R.id.settings)
        settings.setOnClickListener{
            replaceActivity(ActivityAccount())
        }

        val profilepic = findViewById<ImageView>(R.id.profilePic)
        profilepic.setOnClickListener{
            val setProfilePic = AlertDialog.Builder(this)

            setProfilePic.setTitle("Profielfoto vervangen")
                .setMessage("Wilt u uw profielfoto vervangen?")
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Vervangen", null)
                .show()
        }
    }
    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}