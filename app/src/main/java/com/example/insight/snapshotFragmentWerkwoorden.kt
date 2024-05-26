package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView


class snapshotFragmentWerkwoorden : Fragment(R.layout.snapshot_fragment_werkwoorden) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val werkwoordBewerkenFragment: FragmentContainerView =
            requireActivity().findViewById(R.id.werkwoordBewerkenFragment)
        val werkwoordBewerkenUitkomstFragment: FragmentContainerView =
            requireActivity().findViewById(R.id.werkwoordBewerkenUitkomstFragment)

        fun showBewerken(){
            val mIntent = requireActivity().intent
            val previousActivity = mIntent.getStringExtra("FROM_ACTIVITY")

            if (previousActivity.equals("BEWERKEN" )) {
                werkwoordBewerkenFragment.isVisible = true
            }
            else if (previousActivity.equals("UITKOMST")){
                werkwoordBewerkenUitkomstFragment.isVisible = true
            }
        }

        val wachten: AppCompatButton = requireView().findViewById(R.id.wachten)
        wachten.setOnClickListener {showBewerken()}

        val bewegen: AppCompatButton = requireView().findViewById(R.id.bewegen)
        bewegen.setOnClickListener {showBewerken()}

        val transporteren: AppCompatButton = requireView().findViewById(R.id.transporteren)
        transporteren.setOnClickListener {showBewerken()}

        val overleggen: AppCompatButton = requireView().findViewById(R.id.overleggen)
        overleggen.setOnClickListener {showBewerken()}

        val lezen: AppCompatButton = requireView().findViewById(R.id.lezen)
        lezen.setOnClickListener {showBewerken()}

        val zoeken : AppCompatButton = requireView().findViewById(R.id.zoeken )
        zoeken.setOnClickListener {showBewerken()}

        val produceren: AppCompatButton = requireView().findViewById(R.id.produceren)
        produceren.setOnClickListener {showBewerken()}

        val demonteren: AppCompatButton = requireView().findViewById(R.id.demonteren)
        demonteren.setOnClickListener{showBewerken()}

        val omstellen: AppCompatButton = requireView().findViewById(R.id.omstellen)
        omstellen.setOnClickListener {showBewerken()}

        val administreren: AppCompatButton = requireView().findViewById(R.id.administreren)
        administreren.setOnClickListener {showBewerken()}

        val opruimen: AppCompatButton = requireView().findViewById(R.id.opruimen)
        opruimen.setOnClickListener {showBewerken()}

        val herstellen: AppCompatButton = requireView().findViewById(R.id.herstellen)
        herstellen.setOnClickListener {showBewerken()}

        val viewsList: ArrayList<AppCompatButton> = ArrayList()
        viewsList.add(wachten)
        viewsList.add(bewegen)

        val werkwoordInstellingenFragment: FragmentContainerView =
            requireActivity().findViewById(R.id.werkwoordInstellingenFragment)

        val showWerkwoordInstellingen: ImageButton =
            requireView().findViewById(R.id.showWerkwoordInstellingen)
        showWerkwoordInstellingen.setOnClickListener {
            werkwoordInstellingenFragment.isVisible = true

        }
    }
}