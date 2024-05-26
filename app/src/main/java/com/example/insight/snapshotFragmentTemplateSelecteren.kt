package com.example.insight

import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class snapshotFragmentTemplateSelecteren : Fragment(R.layout.snapshot_fragment_template_selecteren){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val templateSelecteren: LinearLayout =
            requireView().findViewById(R.id.templateSelecteren)
        templateSelecteren.visibility = View.VISIBLE

        val showTemplateSelect: FragmentContainerView =
            requireActivity().findViewById(R.id.slideInTemplate)

        val voorbeeldTim: AppCompatButton =
            requireView().findViewById(R.id.voorbeeldTim)

        voorbeeldTim.setOnClickListener {
            showTemplateSelect.isVisible = false
            println(GlobalVariables().templateName)
        }

        val hideToolbarSelecteren: ImageButton =
            requireView().findViewById(R.id.hideToolbarButtonSelecteren)
        hideToolbarSelecteren.setOnClickListener{
            showTemplateSelect.isVisible = false
        }

        val viewOnCancel = requireView().findViewById<View>(R.id.viewOnCancel)
        viewOnCancel.setOnClickListener{
            showTemplateSelect.isVisible = false
        }
    }
}