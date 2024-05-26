package com.example.insight

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class snapshotFragmentUitkomst : Fragment(R.layout.snapshot_fragment_uitkomst) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shareBar: LinearLayout = requireView().findViewById(R.id.shareBar)

        shareBar.setOnClickListener {
            val params = shareBar.layoutParams as ViewGroup.MarginLayoutParams
            params.marginStart = 750
            shareBar.layoutParams = params
        }
        val ResultsMeting: LinearLayout = requireView().findViewById(R.id.ResultsMeting)
        ResultsMeting.setOnClickListener {
            val paramsAfter = shareBar.layoutParams as ViewGroup.MarginLayoutParams
            paramsAfter.marginStart = 1350
            shareBar.layoutParams = paramsAfter
        }

        val WerkwoordUitkomst: ImageButton = requireView().findViewById(R.id.WerkwoordUitkomst)
        WerkwoordUitkomst.setOnClickListener {
            val intent = Intent(activity, SnapshotActivityWerkwoordBenoemen()::class.java)
            intent.putExtra("FROM_ACTIVITY", "UITKOMST")
            startActivity(intent)
        }
    }

}