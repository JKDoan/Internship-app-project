package com.example.insight

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class resultatenFragmentDisturbance : Fragment(R.layout.fragment_resultaten_disturbance){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val disturbanceMeting: LinearLayout =
            requireView().findViewById(R.id.disturbanceMeting) as LinearLayout
        disturbanceMeting.setOnClickListener {
            replaceActivity()
        }
    }
    private fun replaceActivity (){
        val intent = Intent(activity, DisturbanceActivityResultaat::class.java)
        startActivity(intent)
    }
}
