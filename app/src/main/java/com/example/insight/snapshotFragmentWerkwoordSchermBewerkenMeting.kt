package com.example.insight

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView

class snapshotFragmentWerkwoordSchermBewerkenMeting : Fragment(R.layout.snapshot_fragment_werkwoord_scherm_bewerken_meting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val snapshotFragmentWerkwoordBewerkenInMeting: FragmentContainerView =
            requireActivity().findViewById(R.id.werkwoordInstellingenFragment)

        val werkwoordNiveau1InMeting: AppCompatButton =
            requireView().findViewById(R.id.werkwoordNiveau1)
        werkwoordNiveau1InMeting.setOnClickListener {
            snapshotFragmentWerkwoordBewerkenInMeting.isVisible = false
            val intent = Intent(activity, SnapshotActivityInstellingenActiefInMeting::class.java)
            startActivity(intent)
        }

        val hoofdschermInstellenInMeting:
                AppCompatButton = requireView().findViewById(R.id.hoofdschermInstellen)
        hoofdschermInstellenInMeting.setOnClickListener {
            snapshotFragmentWerkwoordBewerkenInMeting.isVisible = false
            val intent = Intent(activity, SnapshotActivityHoofdschermInstellenInMeting::class.java)
            startActivity(intent)
        }

        val closeWerkwoordInstellingen: View =
            requireView().findViewById(R.id.closeWerkwoordInstellingen) as View
        closeWerkwoordInstellingen.setOnClickListener{
            snapshotFragmentWerkwoordBewerkenInMeting.isVisible = false
        }

        val viewOnCancel: View =
            requireView().findViewById(R.id.viewOnCancel) as View
        viewOnCancel.setOnClickListener{
            snapshotFragmentWerkwoordBewerkenInMeting.isVisible = false
        }
    }
}