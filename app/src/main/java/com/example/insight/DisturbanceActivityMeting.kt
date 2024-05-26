package com.example.insight

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class DisturbanceActivityMeting : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_meting)
        supportActionBar!!.hide()

        val structuurBepalenHeader = findViewById<RelativeLayout>(R.id.structuurBepalenHeader)

        val settingsStructuurBepalenTaken = findViewById<ImageButton>(R.id.settingsStructuurBepalenTaken)
        val settingsStructuurBepalenVerstoring = findViewById<ImageButton>(R.id.settingsStructuurBepalenVerstoring)

        val fragmentInstellingenTaken =
            findViewById<FragmentContainerView>(R.id.fragmentInstellingenTaken)
        val fragmentInstellingenVerstoringen =
            findViewById<FragmentContainerView>(R.id.fragmentInstellingenVerstoringen)

        settingsStructuurBepalenVerstoring.isVisible = false

        settingsStructuurBepalenTaken.setOnClickListener {
            fragmentInstellingenTaken.isVisible = true
        }

        settingsStructuurBepalenVerstoring.setOnClickListener {
            fragmentInstellingenVerstoringen.isVisible = true
        }

        val changeStatusTakenVerstoring = findViewById<ImageView>(R.id.changeStatusTakenVerstoring)

        changeStatusTakenVerstoring.setOnClickListener {
            if (changeStatusTakenVerstoring.tag == (R.drawable.overleggen_grey)) {
                replaceFragment(disturbanceFragmentTaakMeten())
            } else if (changeStatusTakenVerstoring.tag == (R.drawable.verstoring)) {
                replaceFragment(disturbanceFragmentVerstoringMeten())
            }
        }

        val showStopMetingDisturb =
            findViewById<FragmentContainerView>(R.id.fragmentStopMetingDisturbance)
        showStopMetingDisturb.isVisible = false

        //refer to bottom navigation and regulate it
        // set meting to default active link
        val bottomNavTaken = findViewById<BottomNavigationView>(R.id.bottomNavigationViewTaken)
        bottomNavTaken.menu.findItem(R.id.metingTaken).isChecked = true
        bottomNavTaken.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.metingTaken -> {
                    replaceFragment(disturbanceFragmentTaken())
                    showStopMetingDisturb.isVisible = false
                    changeStatusTakenVerstoring.isVisible = true
                    structuurBepalenHeader.isVisible = false
                }
                R.id.structure -> {
                    replaceFragment(disturbanceFragmentStructuur())
                    showStopMetingDisturb.isVisible = false
                    changeStatusTakenVerstoring.isVisible = false
                    structuurBepalenHeader.isVisible = true
                }
                //when the user clicks on the stop button, the stop meting fragment appears
                R.id.stopTaken -> showStopMetingDisturb.isVisible = true
                else -> {
                }
            }
            true
        }

        val takenMetingDisturbanceButton =
            findViewById<AppCompatButton>(R.id.takenMetingDisturbanceButton)
        val verstoringenMetingDisturbanceButton =
            findViewById<AppCompatButton>(R.id.verstoringenMetingDisturbanceButton)

        takenMetingDisturbanceButton.setOnClickListener {
            takenMetingDisturbanceButton.setBackgroundColor(Color.parseColor("#EA6122"))
            verstoringenMetingDisturbanceButton
                .setBackgroundColor(Color.parseColor("#C6C6C5"))

            takenMetingDisturbanceButton.setTextColor(Color.parseColor("#FFFFFF"))
            verstoringenMetingDisturbanceButton.setTextColor(Color.parseColor("#D9D9D9"))

            if (bottomNavTaken.selectedItemId == R.id.metingTaken) {
                replaceFragment(disturbanceFragmentTaken())
            } else if (bottomNavTaken.selectedItemId == R.id.structure) {
                replaceFragment(disturbanceFragmentStructuur())
            }

            settingsStructuurBepalenTaken.isVisible = true
            settingsStructuurBepalenVerstoring.isVisible = false
        }

        verstoringenMetingDisturbanceButton.setOnClickListener {
            verstoringenMetingDisturbanceButton.setBackgroundColor(Color.parseColor("#EA6122"))
            takenMetingDisturbanceButton.setBackgroundColor(Color.parseColor("#C6C6C5"))

            takenMetingDisturbanceButton
                .setTextColor(Color.parseColor("#D9D9D9"))
            verstoringenMetingDisturbanceButton.setTextColor(Color.parseColor("#FFFFFF"))

            if (bottomNavTaken.selectedItemId == R.id.metingTaken) {
                replaceFragment(disturbanceFragmentVerstoringen())

            } else if (bottomNavTaken.selectedItemId == R.id.structure) {
                replaceFragment(disturbanceFragmentStructuurBepalenVerstoringen())
            }

            settingsStructuurBepalenTaken.isVisible = false
            settingsStructuurBepalenVerstoring.isVisible = true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance, fragment)
            .addToBackStack(null)
        fragmentTransaction.commit()
    }
}