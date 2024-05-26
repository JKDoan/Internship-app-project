package com.example.insight

import android.app.PendingIntent.getActivity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView


class DisturbanceActivityStructuurBepalen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_structuur_bepalen)
        supportActionBar!!.hide()

        val takenDisturbanceButton:
                AppCompatButton = requireViewById(R.id.takenDisturbanceButton) as AppCompatButton
        val verstoringenDisturbanceButton:
                AppCompatButton = requireViewById(R.id.verstoringenDisturbanceButton) as AppCompatButton

        takenDisturbanceButton.setOnClickListener{
            takenDisturbanceButton.setBackgroundColor(Color.parseColor("#EA6122"))
            verstoringenDisturbanceButton.setBackgroundColor(Color.parseColor("#C6C6C5"))

            takenDisturbanceButton.setTextColor(Color.parseColor("#FFFFFF"))
            verstoringenDisturbanceButton.setTextColor(Color.parseColor("#D9D9D9"))

            replaceFragment(disturbanceFragmentStructuurBepalenTaken())
        }

        verstoringenDisturbanceButton.setOnClickListener{
            verstoringenDisturbanceButton.setBackgroundColor(Color.parseColor("#EA6122"))
            takenDisturbanceButton.setBackgroundColor(Color.parseColor("#C6C6C5"))

            takenDisturbanceButton.setTextColor(Color.parseColor("#D9D9D9"))
            verstoringenDisturbanceButton.setTextColor(Color.parseColor("#FFFFFF"))

            replaceFragment(disturbanceFragmentStructuurBepalenVerstoringen())
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