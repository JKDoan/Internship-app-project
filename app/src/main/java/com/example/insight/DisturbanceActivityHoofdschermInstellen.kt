package com.example.insight

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class DisturbanceActivityHoofdschermInstellen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_hoofdscherm_instellen)
        supportActionBar!!.hide()



        val backToPreviousScreen = findViewById<ImageButton>(R.id.backToPreviousScreen)
        backToPreviousScreen.setOnClickListener {
            finish()
        }

        val hoofdschermInstellenTakenButton = findViewById<AppCompatButton>(R.id.hoofdschermInstellenTakenButton)
        val hoofdschermInstellenVerstoringenButton =
            findViewById<AppCompatButton>(R.id.hoofdschermInstellenVerstoringenButton)

        hoofdschermInstellenTakenButton.setOnClickListener {
            replaceFragment(disturbanceFragmentHoofdschermInstellenTaken())

            hoofdschermInstellenTakenButton.setBackgroundColor(Color.parseColor("#EA6122"))
            hoofdschermInstellenVerstoringenButton.setBackgroundColor(Color.parseColor("#C6C6C5"))

            hoofdschermInstellenTakenButton.setTextColor(Color.parseColor("#FFFFFF"))
            hoofdschermInstellenVerstoringenButton.setTextColor(Color.parseColor("#D9D9D9"))
        }

        hoofdschermInstellenVerstoringenButton.setOnClickListener {
            replaceFragment(disturbanceFragmentHoofdschermInstellenVerstoringen())

            hoofdschermInstellenTakenButton.setBackgroundColor(Color.parseColor("#C6C6C5"))
            hoofdschermInstellenVerstoringenButton.setBackgroundColor(Color.parseColor("#EA6122"))

            hoofdschermInstellenTakenButton.setTextColor(Color.parseColor("#D9D9D9"))
            hoofdschermInstellenVerstoringenButton.setTextColor(Color.parseColor("#FFFFFF"))
        }

        val mIntent = intent
        val previousActivity = mIntent.getStringExtra("FROM_ACTIVITY")

        if (previousActivity.equals("VERSTORINGEN_STRUCTUUR")) {
            replaceFragment(disturbanceFragmentHoofdschermInstellenVerstoringen())

            hoofdschermInstellenTakenButton.setBackgroundColor(Color.parseColor("#C6C6C5"))
            hoofdschermInstellenVerstoringenButton.setBackgroundColor(Color.parseColor("#EA6122"))

            hoofdschermInstellenTakenButton.setTextColor(Color.parseColor("#D9D9D9"))
            hoofdschermInstellenVerstoringenButton.setTextColor(Color.parseColor("#FFFFFF"))
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.hoofdschermInstellenFragment, fragment)
        fragmentTransaction.commit()
    }
}