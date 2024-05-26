package com.example.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class snapshotFragmentWerkwoordBewerkenUitkomst :
    Fragment(R.layout.snapshot_fragment_werkwoord_bewerken_uitkomst) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val werkwoordBewerkenUitkomstFragment: FragmentContainerView =
            requireActivity().findViewById(R.id.werkwoordBewerkenUitkomstFragment)

        val werkwoordVerplaatsen: ImageButton =
            requireView().findViewById(R.id.werkwoordVerplaatsen)
        werkwoordVerplaatsen.setOnClickListener {
            werkwoordBewerkenUitkomstFragment.isVisible = false
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

        val viewOnCancel: View =
            requireView().findViewById(R.id.viewOnCancel) as View
        viewOnCancel.setOnClickListener{
            werkwoordBewerkenUitkomstFragment.isVisible = false
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fm: FragmentManager =parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerMetingSnapshot, fragment)
        fragmentTransaction.commit()
    }
}