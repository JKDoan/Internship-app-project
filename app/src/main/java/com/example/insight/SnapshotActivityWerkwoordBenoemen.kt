package com.example.insight

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView

class SnapshotActivityWerkwoordBenoemen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snapshot_activity_werkwoord_benoemen)
        supportActionBar!!.hide()

        val backToTemplateAanmaken = requireViewById<ImageButton>(R.id.backToTemplateAanmaken)
        backToTemplateAanmaken.setOnClickListener{
            finish()
        }

        val werkwoordInstellingenFragment = requireViewById<FragmentContainerView>(R.id.werkwoordInstellingenFragment)

        val openWerkwoordIInstellingen = requireViewById<ImageButton>(R.id.openWerkwoordIInstellingen)
        openWerkwoordIInstellingen.setOnClickListener {
            werkwoordInstellingenFragment.isVisible = true
        }
    }
}