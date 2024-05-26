package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentResultaten : Fragment(R.layout.disturbance_fragment_resultaten) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val snapshotResultsButton: ImageButton = requireView().findViewById(R.id.snapshotResultsButton)
        snapshotResultsButton.background = null

        val timingResultsButton: ImageButton = requireView().findViewById(R.id.timingResultsButton)
        timingResultsButton.background = null

        val gaugeResultsButton: ImageButton = requireView().findViewById(R.id.gaugeResultsButton)
        gaugeResultsButton.background = null

        val disturbanceResultsButton: ImageButton = requireView().findViewById(R.id.disturbanceResultsButton)
        replaceFragment(resultatenFragmentDisturbance())

        val snapshotTextResults: TextView = requireView().findViewById(R.id.snapshotTextResults)
        val gaugeTextResults: TextView = requireView().findViewById(R.id.gaugeTextResults)
        val timingTextResults: TextView = requireView().findViewById(R.id.timingTextResults)
        val disturbanceTextResults: TextView =
            requireView().findViewById(R.id.disturbanceTextResults)

        snapshotResultsButton.background = null
        snapshotResultsButton.setOnClickListener {
            snapshotResultsButton.setImageResource(R.drawable.logo_snapshot)
            snapshotResultsButton.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.box_shadow)
            snapshotTextResults.visibility = View.VISIBLE

            gaugeResultsButton.setImageResource(R.drawable.logo_gauge_grey)
            gaugeResultsButton.background = null
            gaugeTextResults.visibility = View.INVISIBLE

            timingResultsButton.setImageResource(R.drawable.logo_timing_grey)
            timingResultsButton.background = null
            timingTextResults.visibility = View.INVISIBLE

            disturbanceResultsButton.setImageResource(R.drawable.logo_disturbance_grey)
            disturbanceResultsButton.background = null
            disturbanceTextResults.visibility = View.INVISIBLE

            replaceFragment(resultatenFragmentSnapshot())
        }

        gaugeResultsButton.background = null
        gaugeResultsButton.setOnClickListener {
            snapshotResultsButton.setImageResource(R.drawable.logo_snapshot_grey)
            snapshotResultsButton.background = null
            snapshotTextResults.visibility = View.INVISIBLE

            gaugeResultsButton.setImageResource(R.drawable.logo_gauge)
            gaugeResultsButton.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.box_shadow)
            gaugeTextResults.visibility = View.VISIBLE

            timingResultsButton.setImageResource(R.drawable.logo_timing_grey)
            timingResultsButton.background = null
            timingTextResults.visibility = View.INVISIBLE

            disturbanceResultsButton.setImageResource(R.drawable.logo_disturbance_grey)
            disturbanceResultsButton.background = null
            disturbanceTextResults.visibility = View.INVISIBLE

            replaceFragment(resultatenFragmentGauge())
        }

        timingResultsButton.background = null
        timingResultsButton.setOnClickListener {
            snapshotResultsButton.setImageResource(R.drawable.logo_snapshot_grey)
            snapshotResultsButton.background = null
            snapshotTextResults.visibility = View.INVISIBLE

            gaugeResultsButton.setImageResource(R.drawable.logo_gauge_grey)
            gaugeResultsButton.background = null
            gaugeTextResults.visibility = View.INVISIBLE

            timingResultsButton.setImageResource(R.drawable.logo_timing)
            timingResultsButton.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.box_shadow)
            timingTextResults.visibility = View.VISIBLE

            disturbanceResultsButton.setImageResource(R.drawable.logo_disturbance_grey)
            disturbanceResultsButton.background = null
            disturbanceTextResults.visibility = View.INVISIBLE

            replaceFragment(resultatenFragmentTiming())
        }

        disturbanceResultsButton.setOnClickListener {
            snapshotResultsButton.setImageResource(R.drawable.logo_snapshot_grey)
            snapshotResultsButton.background = null
            snapshotTextResults.visibility = View.INVISIBLE

            gaugeResultsButton.setImageResource(R.drawable.logo_gauge_grey)
            gaugeResultsButton.background = null
            gaugeTextResults.visibility = View.INVISIBLE

            timingResultsButton.setImageResource(R.drawable.logo_timing_grey)
            timingResultsButton.background = null
            timingTextResults.visibility = View.INVISIBLE

            disturbanceResultsButton.setImageResource(R.drawable.logo_disturbance)
            disturbanceResultsButton.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.box_shadow)
            disturbanceTextResults.visibility = View.VISIBLE

            replaceFragment(resultatenFragmentDisturbance())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction:
                FragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragementResultaten, fragment)
        fragmentTransaction.commit()
    }
}