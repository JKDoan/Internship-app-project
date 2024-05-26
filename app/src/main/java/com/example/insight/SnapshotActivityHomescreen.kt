package com.example.insight

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class SnapshotActivityHomescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_homescreen)
        supportActionBar!!.hide()

        val backToHomescreen = findViewById<ImageButton>(R.id.backToHomescreenButton)
        backToHomescreen.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }

        //refer to bottom navigation and set active tab to meting
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.menu.findItem(R.id.meting).isChecked = true
        //set navigation for the bottom nav
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.meting -> replaceFragment(snapshotFragmentMetingInstellen())
                R.id.voorbereiding -> replaceFragment(VoorbereidingFragment())
                R.id.resultaten -> replaceFragment(ResultatenFragment())
                else -> {

                }
            }
            true
        }

        //get intent and its extra value
        val mIntent = intent
        val previousActivity = mIntent.getStringExtra("FROM_ACTIVITY")

        //check if the previous activity was 'meting opslaan'
        if (previousActivity.equals("OPSLAAN" )) {
            bottomNav.menu.findItem(R.id.meting).isChecked = false
            bottomNav.menu.findItem(R.id.resultaten).isChecked = true
            replaceFragment(ResultatenFragment())
        }
        else if (previousActivity.equals("UITKOMST_SNAPSHOT")){
            bottomNav.menu.findItem(R.id.meting).isChecked = false
            bottomNav.menu.findItem(R.id.resultaten).isChecked = true
            replaceFragment(ResultatenFragment())
        }
        else if (previousActivity.equals("SELECT_OMGEVING")){
            bottomNav.menu.findItem(R.id.meting).isChecked = false
            bottomNav.menu.findItem(R.id.voorbereiding).isChecked = true
            replaceFragment(VoorbereidingFragment())
        }

        val layout = findViewById<ConstraintLayout>(R.id.layout)
        layout.setOnClickListener{
            val imm = getSystemService(
                INPUT_METHOD_SERVICE) as InputMethodManager

            imm.hideSoftInputFromWindow(layout.windowToken, 0)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerViewSnapshot, fragment)
            .addToBackStack(null)
        fragmentTransaction.commit()
    }

}
