package com.example.insight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction

class disturbanceFragmentVerstoringMeten : Fragment(R.layout.disturbance_fragment_verstoring_meten) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val changeStatusTakenVerstoring: ImageView =
            requireActivity().findViewById(R.id.changeStatusTakenVerstoring)

        val stopMetenVerstoringButton: ImageButton =
            requireView().findViewById(R.id.stopMetenVerstoringButton) as ImageButton
        stopMetenVerstoringButton.setOnClickListener {
            replaceFragment(disturbanceFragmentVerstoringen())
            changeStatusTakenVerstoring.setBackgroundResource(R.drawable.verstoring)
            changeStatusTakenVerstoring.setTag(R.drawable.verstoring)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance,fragment)
        fragmentTransaction.commit()
    }
}