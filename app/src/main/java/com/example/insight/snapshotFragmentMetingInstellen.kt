package com.example.insight

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.textfield.TextInputLayout



class snapshotFragmentMetingInstellen : Fragment(R.layout.snapshot_fragment_meting_instellen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showOmgevingSelect: FragmentContainerView =
            requireActivity().findViewById(R.id.slideInOmgeving) as FragmentContainerView
        showOmgevingSelect.isVisible = false

        //display show environment
        val buttonOmgevingSelect: LinearLayout = requireView().findViewById(R.id.werkwoordTemplateOpslaan)
        buttonOmgevingSelect.setOnClickListener{
            showOmgevingSelect.isVisible = true
            hideKeyboard()
        }

        val showTemplateSelect: FragmentContainerView =
            requireActivity().findViewById(R.id.slideInTemplate) as FragmentContainerView

        //display show template
        val buttonTemplateSelect:  LinearLayout  = requireView().findViewById(R.id.templateButton)
        buttonTemplateSelect.setOnClickListener{
            showTemplateSelect.isVisible = true
            hideKeyboard()
        }

        val name: TextInputLayout = requireView().findViewById(R.id.name)
        name.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboardd(v)
            }
        }

        val currentTemplate = requireView().findViewById<TextView>(R.id.currentTemplate)
        currentTemplate.text =  GlobalVariables().templateName

        //values for numberpicker
        val minimumHours = 24
        val minimumMinutes = 60
        val minimumSeconds = 60
        val zero = 0

        //refer to each pickers and set max and min values for time
        val pickerHour: NumberPicker = requireView().findViewById<View>(R.id.hourPicker) as NumberPicker
        pickerHour.maxValue= minimumHours
        pickerHour.minValue= zero

        val pickerMinutes: NumberPicker = requireView().findViewById<View>(R.id.minutePicker) as NumberPicker
        pickerMinutes.maxValue= minimumMinutes
        pickerMinutes.minValue= zero

        val pickerSeconds: NumberPicker = requireView().findViewById<View>(R.id.secondsPicker) as NumberPicker
        pickerSeconds.maxValue= minimumSeconds
        pickerSeconds.minValue= zero
        // refer to button for starting measurement
        val startMeting: Button = requireView().findViewById<View>(R.id.startMeting) as Button

        //start meting when clicked on orange start button
        startMeting.setOnClickListener{
            val intent = Intent(activity, SnapshotActivityMeting::class.java)
            intent.putExtra("FROM_ACTIVITY", "BEWERKEN")
            startActivity(intent)
        }
    }

    private fun hideKeyboard(){
        val inputManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(requireView().windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    private fun hideKeyboardd(view: View) {
        val inputMethodManager =
            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
        inputMethodManager!!.hideSoftInputFromWindow(view.windowToken, 0)
    }
}



