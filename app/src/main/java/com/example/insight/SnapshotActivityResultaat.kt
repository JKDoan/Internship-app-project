package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SnapshotActivityResultaat : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_resultaat)
        supportActionBar!!.hide()

        val backToSnapshotResults = requireViewById<ImageButton>(R.id.backToSnapshotResults)
        backToSnapshotResults.setOnClickListener {
            replaceActivity(SnapshotActivityHomescreen())
        }

        val snapshotResultsButtonNav =
            requireViewById<BottomNavigationView>(R.id.snapshotResultsButtonNav)
        snapshotResultsButtonNav.menu.findItem(R.id.uitkomstSnapshot).isChecked = true
        //set navigation for the bottom nav
        snapshotResultsButtonNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.opmerkingenSnapshot -> replaceFragment(snapshotFragmentOpmerking())
                R.id.uitkomstSnapshot -> replaceFragment(snapshotFragmentUitkomst())
                R.id.tijdlijnSnapshot-> replaceFragment(snapshotFragmentTijdlijn())
                else -> {
                }
            }
            true
        }
    }
    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        intent.putExtra("FROM_ACTIVITY", "UITKOMST_SNAPSHOT")
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.snapshotResultatenFragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}