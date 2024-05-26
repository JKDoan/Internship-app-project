package com.example.insight

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentInstellingenVerstoringen :
    Fragment(R.layout.disturbance_fragment_instellingen_verstoringen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentInstellingenVerstoringen =
            requireActivity().findViewById<FragmentContainerView>(R.id.fragmentInstellingenVerstoringen)

        val hoofdschermInstellenVerstoringDisturbance =
            requireView().findViewById<AppCompatButton>(R.id.hoofdschermInstellenVerstoringDisturbance)
        hoofdschermInstellenVerstoringDisturbance.setOnClickListener {
            fragmentInstellingenVerstoringen.isVisible = false
            val intent = Intent(activity, DisturbanceActivityHoofdschermInstellen()::class.java)
            intent.putExtra("FROM_ACTIVITY", "VERSTORINGEN_STRUCTUUR")
            startActivity(intent)
        }

        val viewOnCancel = requireView().findViewById<View>(R.id.viewOnCancel)
        viewOnCancel.setOnClickListener{
            fragmentInstellingenVerstoringen.isVisible = false
        }
    }
}