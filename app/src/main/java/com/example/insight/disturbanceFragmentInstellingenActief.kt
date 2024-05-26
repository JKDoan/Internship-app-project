package com.example.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentInstellingenActief : Fragment(R.layout.disturbance_fragment_instellingen_actief){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navBarTakenVerstoring =
            requireActivity().findViewById<LinearLayout>(R.id.navBarTakenVerstoring)

        val backToStructuurBepalen: ImageButton = requireView().findViewById(R.id.backToStructuurBepalen)
        backToStructuurBepalen.setOnClickListener {
            replaceFragmentToActivity(disturbanceFragmentStructuurBepalenTaken())
            navBarTakenVerstoring.isVisible = true
        }

    }

    private fun replaceFragmentToActivity(fragment: Fragment) {
        val fragmentTransaction:
                FragmentTransaction =parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance,fragment)
        fragmentTransaction.commit()
    }
}