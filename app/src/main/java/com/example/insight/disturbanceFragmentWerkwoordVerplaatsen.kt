package com.example.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentWerkwoordVerplaatsen : Fragment(R.layout.disturbance_fragment_werkwoord_verplaatsen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bewegenDisturbance: AppCompatButton =
            requireActivity().findViewById(R.id.bewegenDisturbance)
        bewegenDisturbance.setOnClickListener {
            val moveWerkwoordDisturbance = AlertDialog.Builder(view.context)

            moveWerkwoordDisturbance.setTitle("Verplaatsen")
                .setMessage("Waar wil je de geselecteerde activiteit naar toe verplaatsen?")
                .setPositiveButton("Boven deze") { _, _ ->
                    replaceFragmentInFragment(disturbanceFragmentStructuur())
                }
                .setNeutralButton("Onder deze") { _, _ ->
                    replaceFragmentInFragment(disturbanceFragmentStructuur())
                }
                .setNegativeButton("Annuleren") { _, _ ->
                    replaceFragmentInFragment(disturbanceFragmentStructuur())
                }
                .show()
        }
    }
    private fun replaceFragmentInFragment(fragment: Fragment) {
        val fragmentTransaction:
                FragmentTransaction =parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance,fragment)
        fragmentTransaction.commit()
    }
}