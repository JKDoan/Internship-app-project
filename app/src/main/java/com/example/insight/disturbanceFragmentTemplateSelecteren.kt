package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class disturbanceFragmentTemplateSelecteren :
    Fragment(R.layout.disturbance_fragment_template_selecteren) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val disturbanceSelecteerTemplate: FragmentContainerView =
            requireActivity().findViewById(R.id.disturbanceSelecteerTemplate)


        val hideToolbarButtonSelecteren: ImageButton =
            requireView().findViewById(R.id.hideToolbarButtonSelecteren)
        hideToolbarButtonSelecteren.setOnClickListener {
            disturbanceSelecteerTemplate.isVisible = false
        }
        val viewOnCancel: View = requireView().findViewById(R.id.viewOnCancel)
        viewOnCancel.setOnClickListener{
            disturbanceSelecteerTemplate.isVisible = false
        }
    }
}