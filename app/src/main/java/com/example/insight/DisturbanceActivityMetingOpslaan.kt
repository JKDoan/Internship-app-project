package com.example.insight

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class DisturbanceActivityMetingOpslaan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_meting_opslaan)
        supportActionBar!!.hide()

        val layoutOpslaanDisturbance = findViewById<ConstraintLayout>(R.id.layoutOpslaanDisturbance)
        layoutOpslaanDisturbance.setOnClickListener {
            val imm = getSystemService(
                INPUT_METHOD_SERVICE) as InputMethodManager

            imm.hideSoftInputFromWindow(layoutOpslaanDisturbance.windowToken, 0)
        }

        val verwijderMetingDisturbance = findViewById<ImageButton>(R.id.verwijderMetingDisturbance)
        verwijderMetingDisturbance.setOnClickListener {
            val deleteMetingSnapshot = AlertDialog.Builder(this)

            deleteMetingSnapshot.setTitle("Meting verwijderen")
                .setMessage("Weet je zeker dat je de meting wilt verwijderen?")
                .setPositiveButton("Nee", null)
                .setNegativeButton("Ja") { _, _ ->
                    replaceActivity(MainActivity())
                }
                .show()
        }

        val opslaanDisturbance = findViewById<ImageButton>(R.id.opslaanButtonDisturbance)
        opslaanDisturbance.setOnClickListener{
            val mIntent = Intent(this, DisturbanceActivityHomescreen::class.java)
            mIntent.putExtra("FROM_ACTIVITY", "OPSLAAN")
            startActivity(mIntent)
        }
    }
    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}