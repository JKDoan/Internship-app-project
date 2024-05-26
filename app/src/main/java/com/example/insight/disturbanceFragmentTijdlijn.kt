package com.example.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.NumberPicker
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import java.lang.String.format

class disturbanceFragmentTijdlijn : Fragment(R.layout.disturbance_fragment_tijdlijn){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scale1: NumberPicker =
            requireActivity().findViewById(R.id.scale1)
        scale1.maxValue = 98
        scale1.minValue = 0
        scale1.setFormatter { i -> String.format("%02d", i) }

        val scale2: NumberPicker =
            requireActivity().findViewById(R.id.scale2)
        scale2.maxValue = 58
        scale2.minValue = 5
        scale2.setFormatter { i -> String.format("%02d", i) }

        val scorekaartVerstoring: FragmentContainerView = requireActivity().findViewById(R.id.scoreKaartVerstoring)
        val scorekaartTaak: FragmentContainerView = requireActivity().findViewById(R.id.scoreKaartTaak)

        val overleggen: LinearLayout = requireView().findViewById(R.id.overleggen)
        overleggen.setOnClickListener {
            scorekaartTaak.isVisible = true
        }

        val verstoring: LinearLayout = requireView().findViewById(R.id.verstoring)
        verstoring.setOnClickListener {
            scorekaartVerstoring.isVisible = true
        }

        val overleggen2: LinearLayout = requireView().findViewById(R.id.overleggen2)
        overleggen2.setOnClickListener {
            scorekaartTaak.isVisible = true
        }

        val bewerken: LinearLayout = requireView().findViewById(R.id.bewerken)
        bewerken.setOnClickListener {
            scorekaartTaak.isVisible = true
        }
    }
}

