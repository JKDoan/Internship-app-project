package com.example.insight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DisturbanceActivityHomescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_homescreen)
        supportActionBar!!.hide()

        val layoutdisturbance = findViewById<ConstraintLayout>(R.id.layoutdisturbance)
        layoutdisturbance.setOnClickListener {
            val imm = getSystemService(
                INPUT_METHOD_SERVICE) as InputMethodManager

            imm.hideSoftInputFromWindow(layoutdisturbance.windowToken, 0)
        }

        val backToHomescreen = findViewById<ImageButton>(R.id.backToHomescreenButton)
        backToHomescreen.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //refer to bottom navigation and set active tab to meting
        val bottomNavDisturb = findViewById<BottomNavigationView>(R.id.bottomNavigationViewDisturb)
        bottomNavDisturb.menu.findItem(R.id.metingDisturbance).isChecked = true
        bottomNavDisturb.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.metingDisturbance -> replaceFragment(disturbanceFragmentMetingInstellen())
                R.id.voorbereidingDisturbance -> replaceFragment(disturbanceFragmentVoorbereiding())
                R.id.resultatenDisturbance -> replaceFragment(disturbanceFragmentResultaten())
                else -> {

                }
            }
            true
        }

        //get intent and its extra value
        val mIntent = intent
        val previousActivity = mIntent.getStringExtra("FROM_ACTIVITY")
        //check if the previous activity was 'meting opslaan'
        if (previousActivity.equals("OPSLAAN")) {
            bottomNavDisturb.menu.findItem(R.id.metingDisturbance).isChecked = false
            bottomNavDisturb.menu.findItem(R.id.resultatenDisturbance).isChecked = true
            replaceFragment(disturbanceFragmentResultaten())
        }
        else if (previousActivity.equals("STRUCTUUR BEPALEN")) {
            bottomNavDisturb.menu.findItem(R.id.metingDisturbance).isChecked = false
            bottomNavDisturb.menu.findItem(R.id.voorbereidingDisturbance).isChecked = true
            replaceFragment(disturbanceFragmentVoorbereiding())
        }
        else if (previousActivity.equals("UITKOMST_DISTURBANCE")) {
            bottomNavDisturb.menu.findItem(R.id.metingDisturbance).isChecked = false
            bottomNavDisturb.menu.findItem(R.id.resultatenDisturbance).isChecked = true
            replaceFragment(disturbanceFragmentResultaten())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerViewDisturbance, fragment)
        fragmentTransaction.commit()
    }
}