package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentInstellingTaken : Fragment(R.layout.disturbance_fragment_instellingen_taken) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentInstellingenTaken =
            requireActivity().findViewById<FragmentContainerView>(R.id.fragmentInstellingenTaken)

        val takenNiveau1:  AppCompatButton =
            requireView().findViewById(R.id.takenNiveau1)
        takenNiveau1.setOnClickListener {
            fragmentInstellingenTaken.isVisible = false
            val intent = Intent(activity, DisturbanceActivityStructuurActiefInactief()::class.java)
            startActivity(intent)
        }

        val hoofdschermInstellenDisturbance: AppCompatButton =
            requireView().findViewById(R.id.hoofdschermInstellenDisturbance)
        hoofdschermInstellenDisturbance.setOnClickListener {
            fragmentInstellingenTaken.isVisible = false
            val intent = Intent(activity, DisturbanceActivityHoofdschermInstellen()::class.java)
            startActivity(intent)
        }

        val closeInstellingenTaken = requireView().findViewById<ImageButton>(R.id.closeInstellingenTaken)
        closeInstellingenTaken.setOnClickListener {
        }

        val viewOnCancel = requireView().findViewById<View>(R.id.viewOnCancel)
        viewOnCancel.setOnClickListener{
            fragmentInstellingenTaken.isVisible = false
        }
    }
}