package com.example.insight


import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class snapshotFragmentWerkwoordBewerken : Fragment(R.layout.snapshot_fragment_werkwoord_bewerken){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val werkwoordBewerken: FragmentContainerView =
            requireActivity().findViewById(R.id.werkwoordBewerkenFragment)

        val werkwoordVerplaatsen: ImageButton =
            requireView().findViewById(R.id.werkwoordVerplaatsen)
        werkwoordVerplaatsen.setOnClickListener {
            werkwoordBewerken.isVisible = false
            replaceFragment(snapshotFragmentWerkwoordVerplaatsen())
        }

        val statusWerkwoord: ImageButton =
            requireView().findViewById(R.id.statusWerkwoord)
        val green: ImageButton =
            requireView().findViewById(R.id.green)
        val red: ImageButton =
            requireView().findViewById(R.id.red)

        statusWerkwoord.setOnClickListener {
            statusWerkwoord.isVisible = false
            green.isVisible = true
        }

        green.setOnClickListener {
            green.isVisible = false
            red.isVisible = true
        }

        red.setOnClickListener {
            red.isVisible = false
            statusWerkwoord.isVisible = true
        }

        val werkwoordToevoegen: ImageButton =
            requireView().findViewById(R.id.werkwoordToevoegen)
        werkwoordToevoegen.setOnClickListener {
            werkwoordBewerken.isVisible = false
            val addWerkwoordDialog = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addWerkwoord: View = inflater.inflate(R.layout.snapshot_fragment_dialog_add_werkwoord, null)

            addWerkwoordDialog.setTitle("Werkwoord toevoegen")
                .setView(addWerkwoord)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
        }

        val viewOnCancel: View =
            requireView().findViewById(R.id.viewOnCancel) as View
        viewOnCancel.setOnClickListener{
            werkwoordBewerken.isVisible = false
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fm: FragmentManager =parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerMetingSnapshot, fragment)
        fragmentTransaction.commit()
    }
}