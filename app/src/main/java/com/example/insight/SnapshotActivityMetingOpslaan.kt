package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout



class SnapshotActivityMetingOpslaan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_meting_opslaan)
        supportActionBar!!.hide()

        val layoutOpslaanSnapshot = findViewById<ConstraintLayout>(R.id.layoutOpslaanSnapshot)
        layoutOpslaanSnapshot.setOnClickListener {
            val imm = getSystemService(
                INPUT_METHOD_SERVICE) as InputMethodManager

            imm.hideSoftInputFromWindow(layoutOpslaanSnapshot.windowToken, 0)
        }

        val verwijderMetingSnapshot = findViewById<ImageButton>(R.id.verwijderMetingSnapshot)
        verwijderMetingSnapshot.setOnClickListener {
            val deleteMetingSnapshot = AlertDialog.Builder(this)

            deleteMetingSnapshot.setTitle("Meting verwijderen")
                .setMessage("Weet je zeker dat je de meting wilt verwijderen?")
                .setNegativeButton("Nee", null)
                .setPositiveButton("Ja") { _, _ ->
                    replaceActivity(MainActivity())
                }
                .show()
        }

        val werkwoordTemplateOpslaan = findViewById<ImageButton>(R.id.werkwoordTemplateOpslaan)
        werkwoordTemplateOpslaan.setOnClickListener {
            replaceActivity(SnapshotActivityWerkwoordBenoemen())
        }

        val opslaan = findViewById<ImageButton>(R.id.opslaanButton)
        opslaan.setOnClickListener{
            goToHomescreen()
        }
    }

    private fun goToHomescreen() {
        val mIntent = Intent(this, SnapshotActivityHomescreen::class.java)
        mIntent.putExtra("FROM_ACTIVITY", "OPSLAAN")
        startActivity(mIntent)
        overridePendingTransition(0, 0)
    }

    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }
}