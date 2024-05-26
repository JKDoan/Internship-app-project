package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentTaakMeten : Fragment(R.layout.disturbance_fragment_taak_meten) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val changeStatusTakenVerstoring: ImageView =
            requireActivity().findViewById(R.id.changeStatusTakenVerstoring)

        val stopMetenOverleggenButton: ImageButton =
            requireView().findViewById(R.id.stopMetenOverleggenButton)
        stopMetenOverleggenButton.setOnClickListener {
            replaceFragment(disturbanceFragmentTaken())
            changeStatusTakenVerstoring.setBackgroundResource(R.drawable.overleggen_grey)
            changeStatusTakenVerstoring.tag = R.drawable.overleggen_grey
        }

        val afgerondeTellingToevoegen: LinearLayout =
            requireView().findViewById(R.id.afgerondeTellingToevoegen)
        afgerondeTellingToevoegen.setOnClickListener {
            val addOnepiece = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val theView: View = inflater.inflate(R.layout.disturbance_fragment_dialog_one_piece, null)

            addOnepiece.setTitle("Wanneer is je taak gereed?" +
                    "Benoem de 'one-piece'")
                .setMessage("Geef het commentaar in?")
                .setView(theView)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
                .window?.setLayout(1100, 1700)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance,fragment)
        fragmentTransaction.commit()
    }
}