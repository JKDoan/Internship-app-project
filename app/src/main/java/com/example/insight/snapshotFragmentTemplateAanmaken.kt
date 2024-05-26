package com.example.insight

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class snapshotFragmentTemplateAanmaken : Fragment(R.layout.snapshot_fragment_template_aanmaken) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val selecteerOmgeving:
                LinearLayout =
                requireView().findViewById(R.id.selecteerOmgevingButton) as LinearLayout
        selecteerOmgeving.setOnClickListener{
            val intent = Intent(activity, SnapshotActivitySelecteerOmgeving()::class.java)
            startActivity(intent)
        }

        val templateAanmakenButton:
                LinearLayout =
                requireView().findViewById(R.id.afgerondeTellingToevoegen) as LinearLayout
        templateAanmakenButton.setOnClickListener{
            val intent = Intent(activity, SnapshotActivityWerkwoordBenoemen()::class.java)
            intent.putExtra("FROM_ACTIVITY", "BEWERKEN")
            startActivity(intent)
        }
    }
}