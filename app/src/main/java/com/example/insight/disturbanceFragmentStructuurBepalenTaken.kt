package com.example.insight

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat.requireViewById
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction


class disturbanceFragmentStructuurBepalenTaken : Fragment
    (R.layout.disturbance_fragment_structuur_bepalen_taken) {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settingsStructuurBepalenTaken: ImageButton =
            requireView().requireViewById(R.id.settingsStructuurBepalenTaken)
        settingsStructuurBepalenTaken.setOnClickListener {
            val fragmentInstellingenTaken: FragmentContainerView =
                requireActivity().requireViewById(R.id.fragmentInstellingenTaken)
            fragmentInstellingenTaken.isVisible = true
        }

        val backToDisturbanceHomescreen: ImageButton =
            requireView().requireViewById(R.id.backToDisturbanceHomescreen)
        backToDisturbanceHomescreen.setOnClickListener {
            val saveChangesDialog = AlertDialog.Builder(view.context)

            saveChangesDialog.setTitle("Wijzigingen opslaan")
                .setMessage("Wil je de wijzigingen opslaan?")
                .setNegativeButton("Nee") { _, _ ->
                    val intent = Intent(activity, DisturbanceActivityHomescreen::class.java)
                    intent.putExtra("FROM_ACTIVITY", "STRUCTUUR BEPALEN")
                    startActivity(intent)
                }
                .setPositiveButton("Ja") { _, _ ->
                    val intent = Intent(activity, DisturbanceActivityHomescreen::class.java)
                    intent.putExtra("FROM_ACTIVITY", "STRUCTUUR BEPALEN")
                    startActivity(intent)
                }
                .show()
        }



        val wachtenWerkwoord: AppCompatButton =
            requireView().findViewById(R.id.taak)

    }
}
