package com.example.insight

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class disturbanceFragmentVoorbereiding : Fragment(R.layout.disturbance_fragment_voorbereiding) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nieuwTemplateDisturbance: LinearLayout =
            requireView().findViewById(R.id.nieuwTemplateDisturbance) as LinearLayout
        nieuwTemplateDisturbance.setOnClickListener {
            val addTemplateDialog = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addTemplate: View =
                inflater.inflate(R.layout.disturbance_fragment_dialog_add_template, null)

            addTemplateDialog.setTitle("Template toevoegen")
                .setMessage("Geef een naam voor de template")
                .setView(addTemplate)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen") { _, _ ->
                    val intent = Intent(activity, DisturbanceActivityStructuurBepalen::class.java)
                    startActivity(intent)
                }
                .show()
        }
    }
}