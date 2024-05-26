package com.example.insight

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.security.AccessController.getContext


class disturbanceFragmentStructuurBepalenVerstoringen : Fragment
    (R.layout.disturbance_fragment_structuur_bepalen_verstoringen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val addVerstoring: ImageButton = requireView().findViewById(R.id.addVerstoring)
        addVerstoring.setOnClickListener {
            val addVerstoringDialog = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addVerstoring: View =
                inflater.inflate(R.layout.disturbance_fragment_dialog_add_verstoring, null)

            addVerstoringDialog.setTitle("Verstoring")
                .setView(addVerstoring)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
        }
        val settingsStructuurBepalenVerstoring: ImageButton =
            requireView().findViewById(R.id.settingsStructuurBepalenVerstoring)
        settingsStructuurBepalenVerstoring.setOnClickListener {
            val fragmentInstellingenVerstoringen: FragmentContainerView =
                requireActivity().requireViewById(R.id.fragmentInstellingenVerstoringen)
            fragmentInstellingenVerstoringen.isVisible = true
        }
    }
}