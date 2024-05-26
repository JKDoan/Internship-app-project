package com.example.insight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SnapshotActivityMetingResultaat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_meting_resultaat)
        supportActionBar!!.hide()

        val bottomNavResultsSnapshot = findViewById<BottomNavigationView>(R.id.bottomNavResultsSnapshot)
        bottomNavResultsSnapshot.menu.findItem(R.id.uitkomstSnapshot).isChecked = true
        bottomNavResultsSnapshot.setOnItemSelectedListener {
            when(it.itemId){
                R.id.opmerkingenSnapshot -> {
                    replaceFragment(snapshotFragmentOpmerking())
                }
                R.id.uitkomstSnapshot -> {
                    replaceFragment(snapshotFragmentUitkomst())
                }
                //when the user clicks on the stop button, the stop meting fragment appears
                R.id.tijdlijnSnapshot -> {
                    replaceFragment(snapshotFragmentTijdlijn())
                }
                else ->{
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerResultsSnapshot,fragment)
        fragmentTransaction.commit()
    }
}