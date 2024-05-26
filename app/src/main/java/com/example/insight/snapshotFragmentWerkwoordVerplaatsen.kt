package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class snapshotFragmentWerkwoordVerplaatsen :
    Fragment(R.layout.snapshot_fragment_werkwoord_verplaatsen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val niveau1: LinearLayout =
            requireView().findViewById(R.id.niveau1)

        val bewegen: AppCompatButton =
            requireView().findViewById(R.id.bewegenWerkwoord) as AppCompatButton

        bewegen.setOnClickListener {
            val moveWerkwoord = AlertDialog.Builder(view.context)

            moveWerkwoord.setTitle("Verplaatsen")
                .setMessage("Waar wil je de geselecteerde activiteit naar toe verplaatsen?")
                .setNeutralButton("Boven deze") { _, _ ->
                    replaceFragmentInFragment(snapshotFragmentWerkwoorden())
                }
                .setNegativeButton("Onder deze") { _, _ ->
                    replaceFragmentInFragment(snapshotFragmentWerkwoorden())
                }
                .setPositiveButton("Annuleren") { _, _ ->
                    replaceFragmentInFragment(snapshotFragmentWerkwoorden())
                }
                .show()
        }
    }
    private fun replaceFragmentInFragment(fragment: Fragment) {
        val fragmentTransaction:
                FragmentTransaction=parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerMetingSnapshot,fragment)
        fragmentTransaction.commit()
    }
}