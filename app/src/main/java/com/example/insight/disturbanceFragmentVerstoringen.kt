package com.example.insight

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import java.time.Duration.parse

class disturbanceFragmentVerstoringen : Fragment(R.layout.disturbance_fragment_verstoringen){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val verstoring: RelativeLayout = requireView().findViewById(R.id.verstoring)
        verstoring.setOnClickListener {

        }

        val addCommentDisturbance: ImageButton =
            requireView().findViewById(R.id.addCommentDisturbance) as ImageButton
        addCommentDisturbance.setOnClickListener {
            val addCommentDisturbance = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addComment: View =
                inflater.inflate(R.layout.disturbance_fragment_dialog_add_comment, null)

            addCommentDisturbance.setTitle("Commentaar toevoegen")
                .setView(addComment)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
        }

        val progression: LinearLayout = requireView().findViewById(R.id.progression)
        val countVerstoring: ImageView = requireView().findViewById(R.id.countVerstoring)
        val count: TextView = requireView().findViewById(R.id.count)
        var gg = count.text
        gg = "1"
        var ff = Integer.parseInt(gg.toString())

        val params = progression.layoutParams as ViewGroup.MarginLayoutParams

        countVerstoring.setOnClickListener{
            val f = progression.width
            params.width = f + 150
            progression.layoutParams = params

            count.text = (ff++).toString()
            replaceFragment(disturbanceFragmentVerstoringMeten())
        }

        val verstoringToevoegen: LinearLayout =
            requireView().findViewById(R.id.verstoringToevoegen)
        verstoringToevoegen.setOnClickListener {
            val addVerstoringDialog = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addVerstoring: View =
                inflater.inflate(R.layout.disturbance_fragment_dialog_add_verstoring, null)

            addVerstoringDialog.setTitle("Verstoring")
                .setView(addVerstoring)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMetingDisturbance,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}