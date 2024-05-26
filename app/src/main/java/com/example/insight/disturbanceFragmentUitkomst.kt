package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.Fragment


class disturbanceFragmentUitkomst : Fragment(R.layout.disturbance_fragment_uitkomst){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val verstoringenPicker: NumberPicker = requireView().findViewById(R.id.verstoringenPicker)

        val valuesVerstoringen = arrayOf("AANTAL", "TIJD")

        verstoringenPicker.minValue = 0;
        verstoringenPicker.maxValue = valuesVerstoringen.size-1
        verstoringenPicker.wrapSelectorWheel = true;
        verstoringenPicker.displayedValues = valuesVerstoringen;

        val takenPicker: NumberPicker = requireView().findViewById(R.id.takenPicker)

        val valuesTaken = arrayOf("TIJD", "START/STOP MOMENTEN", "GELEVERDE 'ONE-PIECES'")

        takenPicker.minValue = 0;
        takenPicker.maxValue = valuesTaken.size-1
        takenPicker.wrapSelectorWheel = true;
        takenPicker.displayedValues = valuesTaken

    }
}