package com.example.insight

import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class disturbanceFragmentTaakVerstoringBewerken :
    Fragment(R.layout.disturbance_fragment_taak_verstoring_bewerken) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentTaakBewerken:
                FragmentContainerView =
            requireActivity().findViewById(R.id.fragmentTaakVerstoringBewerken) as FragmentContainerView

        val moveTaak: ImageButton = requireView().findViewById(R.id.moveTaak)
        moveTaak.setOnClickListener {
            fragmentTaakBewerken.isVisible = false
            replaceFragment(disturbanceFragmentWerkwoordVerplaatsen())
        }

        val onepieceToevoegen: ImageButton =
            requireView().findViewById(R.id.onepieceToevoegen) as ImageButton
        onepieceToevoegen.setOnClickListener {
            val addOnepiece = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val theView: View = inflater.inflate(R.layout.disturbance_fragment_dialog_one_piece, null)

            addOnepiece.setTitle("Wanneer is je taak gereed?" +
                    "Benoem de 'one-piece'")
                .setMessage("Geef het commentaar in?")
                .setView(theView)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen") { _, _ ->
                    fragmentTaakBewerken.isVisible = false
                }
                .show()
                .window?.setLayout(1100, 1700)
        }

        val addTaak:ImageButton = requireView().findViewById(R.id.addTaak)
        addTaak.setOnClickListener {
            val addTaakDialog = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val theView: View = inflater.inflate(R.layout.disturbance_fragment_dialog_add_taak, null)

            addTaakDialog.setTitle("Taak toevoegen")
                .setView(theView)
                .setNegativeButton("Annuleren") { _, _ ->
                    fragmentTaakBewerken.isVisible = false
                }
                .setPositiveButton("Toevoegen") { _, _ ->
                    fragmentTaakBewerken.isVisible = false
                }
                .show()
        }

        val viewOnCancel: View =
            requireView().findViewById(R.id.viewOnCancel) as View
        viewOnCancel.setOnClickListener{
            fragmentTaakBewerken.isVisible = false
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fm: FragmentManager =parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance, fragment)
        fragmentTransaction.commit()
    }
}