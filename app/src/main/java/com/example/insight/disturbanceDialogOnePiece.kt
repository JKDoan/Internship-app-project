package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.Fragment

class disturbanceDialogOnePiece : Fragment(R.layout.disturbance_fragment_dialog_one_piece) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val definitieVanGereed: NumberPicker =
            requireView().findViewById(R.id.definitieVanGereed) as NumberPicker
        definitieVanGereed.maxValue = 3
        definitieVanGereed.minValue = 0

        val eenheidsaantal: NumberPicker =
            requireView().findViewById(R.id.eenheidsaantal) as NumberPicker
        eenheidsaantal.maxValue = 1000
        eenheidsaantal.minValue = 0

    }
}