package com.example.insight

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout

class resultatenFragmentSnapshot : Fragment(R.layout.fragment_resultaten_snapshot){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val snapshotMeting: LinearLayout =
            requireView().findViewById(R.id.snapshotMeting) as LinearLayout
        snapshotMeting.setOnClickListener {
            replaceActivity()
        }
    }
    private fun replaceActivity (){
        val intent = Intent(activity, SnapshotActivityResultaat::class.java)
        startActivity(intent)
    }
}