package com.example.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView

class disturbanceFragmentScorekaartVerstoring : Fragment(R.layout.disturbance_fragment_scorekaart_verstoring){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val scorekaartVerstoring: FragmentContainerView = requireActivity().findViewById(R.id.scoreKaartVerstoring)
        val scorekaartTaak: FragmentContainerView = requireActivity().findViewById(R.id.scoreKaartTaak)

        val viewOnClick: LinearLayout = requireView().findViewById(R.id.viewOnClick)

        viewOnClick.setOnClickListener {
            scorekaartVerstoring.isVisible = false
        }
    }
}