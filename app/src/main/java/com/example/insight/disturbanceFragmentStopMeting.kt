package com.example.insight

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class disturbanceFragmentStopMeting : Fragment(R.layout.disturbance_fragment_stop_meting) {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavTaken:BottomNavigationView =  requireActivity().requireViewById(R.id.bottomNavigationViewTaken)

        val definitiefStoppenDisturb: ImageButton =
            requireView().findViewById<View>(R.id.definitiefStoppenButton) as ImageButton
        definitiefStoppenDisturb.setOnClickListener{
            val addOnepiece = AlertDialog.Builder(view.context)

            addOnepiece.setTitle("Stop")
                .setMessage("Weet je zeker dat je wilt stoppen?")
                .setPositiveButton("Nee", null)
                .setNegativeButton("Ja") { _, _ ->
                    val intent = Intent(activity, DisturbanceActivityMetingOpslaan::class.java)
                    startActivity(intent)
                }
                .show()

        }

        val fragmentStopMetingDisturbance: FragmentContainerView =
            requireActivity().requireViewById(R.id.fragmentStopMetingDisturbance)

        val hervattenButton: ImageButton =
            requireView().findViewById(R.id.hervattenButton) as ImageButton
        hervattenButton.setOnClickListener {
            fragmentStopMetingDisturbance.isVisible = false
            bottomNavTaken.menu.findItem(R.id.metingTaken).isChecked = true

        }
    }
}