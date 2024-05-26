package com.example.insight

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class SnapshotActivityMeting : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_meting)
        supportActionBar!!.hide()

        //refer to stop meting fragment and set it on invisible until the user on the stop button
        val showStopMeting = findViewById<FragmentContainerView>(R.id.fragmentStopMeting)
        showStopMeting.isVisible = false

        //refer to bottom navigation and regulate it
        // set meting to default active link
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.menu.findItem(R.id.meting).isChecked = true

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.meting -> {
                    replaceFragment(snapshotFragmentMeting())
                    showStopMeting.isVisible = false
                }
                R.id.werkwoorden -> {
                    replaceFragment(snapshotFragmentWerkwoorden())
                    showStopMeting.isVisible = false
                }
                //when the user clicks on the stop button, the stop meting fragment appears
                R.id.stop -> showStopMeting.isVisible = true
                else ->{
                }
            }
            true
        }

        val mIntent = intent
        val previousActivity = mIntent.getStringExtra("FROM_ACTIVITY")
        if (previousActivity.equals("INSTELLINGEN" )) {
            replaceFragment(snapshotFragmentWerkwoorden())
            bottomNav.menu.findItem(R.id.meting).isChecked = false
            bottomNav.menu.findItem(R.id.werkwoorden).isChecked = true
        } else{
            // initialize a pop-up for choosing start of activity
            val chooseStartMeting = AlertDialog.Builder(this)

            // content of pop-up
            chooseStartMeting.setTitle("Start")
                .setMessage("Waar start de meting?")
                .setPositiveButton("Vanaf begin werkdag", null)
                .setNeutralButton("Vanaf begin activiteit", null)
                .setNegativeButton("Activiteit al begonnen", null)
                .setOnCancelListener{
                    val intent = Intent(this, SnapshotActivityHomescreen::class.java)
                    startActivity(intent)
                    finish()
                }
            // show pop-up
            val showOptions = chooseStartMeting.create()
            showOptions.show()
        }

        val snapshotFragmentWerkwoordBewerkenInMeting =
            requireViewById<FragmentContainerView>(R.id.werkwoordInstellingenFragment)
        if (snapshotFragmentWerkwoordBewerkenInMeting.isVisible){
            bottomNav.menu.findItem(R.id.meting).isCheckable = false
            bottomNav.menu.findItem(R.id.stop).isCheckable  = false
            bottomNav.menu.findItem(R.id.werkwoorden).isCheckable  = false
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerMetingSnapshot,fragment)
        fragmentTransaction.commit()
    }
}

