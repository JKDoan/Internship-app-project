package com.example.insight

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class StopMetingFragment : Fragment(R.layout.snapshot_fragment_stop_meting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val fragmentStopMeting =
            requireActivity().findViewById(R.id.fragmentStopMeting) as FragmentContainerView

        val hervattenButton: ImageButton =
            requireView().findViewById(R.id.hervattenButton) as ImageButton
        hervattenButton.setOnClickListener {
            fragmentStopMeting.isVisible = false
            bottomNav.menu.findItem(R.id.meting).isChecked = true
            val addOnepiece = AlertDialog.Builder(view.context)

            addOnepiece.setTitle("Pauze")
                .setMessage("Wat is de reden voor de pauze?")
                .setPositiveButton("Overleg", null)
                .setNegativeButton("Pauze", null)
                .setNeutralButton("WC", null)
                .show()
        }

        val definitiefStoppen: ImageButton =
            requireView().findViewById(R.id.definitiefStoppenButton) as ImageButton
        definitiefStoppen.setOnClickListener{
            val confirmStopMeting = AlertDialog.Builder(view.context)

            confirmStopMeting.setTitle("Stop")
                .setMessage("Weet je zeker dat je wilt stoppen?")
                .setNegativeButton("Nee", null)
                .setPositiveButton("Ja") { _, _ ->
                    stopAlert()
                }
                .show()
        }
    }

    private fun stopAlert(){
        val procesStopMeting = view?.let { AlertDialog.Builder(it.context) }

        procesStopMeting?.setTitle("Stop")
            ?.setMessage("Waar in het proces stopt de meting?")
            ?.setNegativeButton("Einde van de werkdag") { _, _ ->
                replaceFragmentToActivity()
            }
            ?.setNeutralButton("Einde van de activiteit") { _, _ ->
                replaceFragmentToActivity()
            }
            ?.setPositiveButton("Activiteit nog bezig") { _, _ ->
                replaceFragmentToActivity()
            }
            ?.show()
    }
    private fun replaceFragmentToActivity(){
        val intent = Intent(activity, SnapshotActivityMetingOpslaan::class.java)
        startActivity(intent)
        requireActivity().overridePendingTransition(0, 0)
    }
}