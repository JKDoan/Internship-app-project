package com.example.insight

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView


class fragmentOmgevingSelecteren : Fragment(R.layout.fragment_omgeving_selecteren) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: LinearLayout = requireView().findViewById(R.id.omgevingSelecteren) as LinearLayout
        toolbar.visibility = View.VISIBLE

        val showOmgevingSelect: FragmentContainerView =
            requireActivity().findViewById(R.id.slideInOmgeving) as FragmentContainerView

        val hideToolbar: ImageButton =
            requireView().findViewById(R.id.hideToolbarButton) as ImageButton
        hideToolbar.setOnClickListener{
            showOmgevingSelect.isVisible = false
        }

        val viewOnCancel = requireView().findViewById<View>(R.id.viewOnCancel)
        viewOnCancel.setOnClickListener{
            showOmgevingSelect.isVisible = false
        }
    }
}