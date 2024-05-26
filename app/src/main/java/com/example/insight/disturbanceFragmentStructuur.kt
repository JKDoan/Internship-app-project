package com.example.insight

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class disturbanceFragmentStructuur : Fragment(R.layout.disturbance_fragment_structuur){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentTaakVerstoringBewerken: FragmentContainerView =
            requireActivity().findViewById(R.id.fragmentTaakVerstoringBewerken)

        val wachtenDisturbanceButton: AppCompatButton = requireView().findViewById(R.id.wachtenDisturbanceButton)
        wachtenDisturbanceButton.setOnClickListener{
            fragmentTaakVerstoringBewerken.isVisible = true
        }

        val settingsStructuurBepalenTaken: ImageButton =
            requireView().requireViewById(R.id.settingsStructuurBepalenTaken)
        settingsStructuurBepalenTaken.setOnClickListener {
            val fragmentInstellingenTaken: FragmentContainerView =
                requireActivity().requireViewById(R.id.fragmentInstellingenTaken)
            fragmentInstellingenTaken.isVisible = true
        }
    }
}