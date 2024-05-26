package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class disturbanceFragmentTaken : Fragment(R.layout.disturbance_fragment_taken){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val addCommentDisturbance: ImageButton =
            requireView().findViewById(R.id.addCommentDisturbance) as ImageButton
        addCommentDisturbance.setOnClickListener {
            val addCommentDisturbance = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addComment: View = inflater.inflate(R.layout.disturbance_fragment_dialog_add_comment, null)

            addCommentDisturbance.setTitle("Commentaar toevoegen")
                .setView(addComment)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
        }
        val taakOverleggen: LinearLayout = requireView().findViewById(R.id.taakOverleggen) as LinearLayout
        taakOverleggen.setOnClickListener {
            replaceFragment(disturbanceFragmentTaakMeten())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction:
                FragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance,fragment)
        fragmentTransaction.commit()
    }
}