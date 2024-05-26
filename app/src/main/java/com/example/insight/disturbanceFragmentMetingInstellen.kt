package com.example.insight

import android.content.Intent
import android.graphics.text.TextRunShaper
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class disturbanceFragmentMetingInstellen : Fragment(R.layout.disturbance_fragment_meting_instellen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val disturbanceSelecteerTemplate: FragmentContainerView =
            requireActivity().findViewById(R.id.disturbanceSelecteerTemplate)

        val templateSelecteren: LinearLayout = requireView().findViewById(R.id.templateSelecteren)
        templateSelecteren.setOnClickListener {
            disturbanceSelecteerTemplate.isVisible = true
        }

        val startMetingDisturb: Button = requireView().findViewById(R.id.startMetingDisturbance)
        startMetingDisturb.setOnClickListener{
            val intent = Intent(activity, DisturbanceActivityMeting::class.java)
            startActivity(intent)
        }
    }
}