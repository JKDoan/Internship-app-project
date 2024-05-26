package com.example.insight

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentHoofdschermInstellenTaken :
    Fragment(R.layout.disturbance_fragment_hoofdscherm_instellen_taken) {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val niveau1RadioButton: RadioButton =
            requireView().requireViewById<RadioButton>(R.id.niveau1RadioButton)
        val niveau2RadioButton: RadioButton =
            requireView().requireViewById<RadioButton>(R.id.niveau2RadioButton)
        val niveau3RadioButton: RadioButton =
            requireView().requireViewById<RadioButton>(R.id.niveau3RadioButton)

        var check1 = false // initial state of your radio button
        niveau1RadioButton.setOnClickListener {
            if (check1) {
                niveau1RadioButton.isChecked = false
                check1 = false
            } else {
                check1 = true
                niveau1RadioButton.isChecked = true
            }
        }

        var check2 = false
        niveau2RadioButton.setOnClickListener {
            if (check2) {
                niveau2RadioButton.isChecked = false
                check2 = false
            } else {
                check2 = true
                niveau2RadioButton.isChecked = true
            }
        }

        var check3 = false
        niveau3RadioButton.setOnClickListener {
            if (check3) {
                niveau3RadioButton.isChecked = false
                check3 = false
            } else {
                check3 = true
                niveau3RadioButton.isChecked = true
            }
        }
    }
}


