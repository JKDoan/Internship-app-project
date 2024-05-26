package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class DisturbanceActivityResultaat : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_resultaat)
        supportActionBar!!.hide()

        val scorekaartVerstoring = requireViewById<FragmentContainerView>(R.id.scoreKaartVerstoring)
        val scoreKaartTaak = requireViewById<FragmentContainerView>(R.id.scoreKaartTaak)

        val backToDisturbanceResults = requireViewById<ImageButton>(R.id.backToDisturbanceResults)
        backToDisturbanceResults.setOnClickListener {
            replaceActivity(DisturbanceActivityHomescreen())
        }

        val disturbanceResultsBottomNav = requireViewById<BottomNavigationView>(R.id.disturbanceResultsBottomNav)
        disturbanceResultsBottomNav.menu.findItem(R.id.uitkomstDisturbance).isChecked = true
        //set navigation for the bottom nav
        disturbanceResultsBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.opmerkingenDisturbance -> replaceFragment(disturbanceFragmentOpmerking())
                R.id.uitkomstDisturbance -> replaceFragment(disturbanceFragmentUitkomst())
                R.id.tijdlijnDisturbance -> replaceFragment(disturbanceFragmentTijdlijn())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceActivity (activity: Activity){
        val intent = Intent(this, activity::class.java)
        intent.putExtra("FROM_ACTIVITY", "UITKOMST_DISTURBANCE")
        startActivity(intent)
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.disturbanceResultatenFragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}