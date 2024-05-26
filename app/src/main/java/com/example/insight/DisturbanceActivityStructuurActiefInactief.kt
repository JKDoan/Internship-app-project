package com.example.insight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible

class DisturbanceActivityStructuurActiefInactief : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.disturbance_activity_structuur_actief_inactief)
        supportActionBar!!.hide()

        val backToStructuurBepalen: ImageButton = findViewById(R.id.backToStructuurBepalen)
        backToStructuurBepalen.setOnClickListener {
            finish()
        }


        val wachtenWerkwoord = requireViewById<AppCompatButton>(R.id.wachtenWerkwoordActive)
        val wachtenWerkwoordInactive = requireViewById<AppCompatButton>(R.id.wachtenWerkwoordInactive)
        val switchWachten = requireViewById<ImageButton>(R.id.switchWachten)

        wachtenWerkwoord.setOnClickListener {
            wachtenWerkwoord.isVisible = false
            wachtenWerkwoordInactive.isVisible = true
        }
        switchWachten.setOnClickListener {
            if(!wachtenWerkwoord.isVisible){
                wachtenWerkwoord.isVisible = true
                wachtenWerkwoordInactive.isVisible = false
            }
            else if (wachtenWerkwoord.isVisible){
                wachtenWerkwoord.isVisible = false
                wachtenWerkwoordInactive.isVisible = true
            }
        }
        wachtenWerkwoordInactive.setOnClickListener {
            wachtenWerkwoord.isVisible = true
            wachtenWerkwoordInactive.isVisible = false
        }

        val bewegenWerkwoordActive = requireViewById<AppCompatButton>(R.id.bewegenWerkwoordActive)
        val bewegenWerkwoordInactive = requireViewById<AppCompatButton>(R.id.bewegenWerkwoordInactive)
        val switchBewegen = requireViewById<ImageButton>(R.id.switchBewegen)

        bewegenWerkwoordActive.setOnClickListener {
            bewegenWerkwoordActive.isVisible = false
            bewegenWerkwoordInactive.isVisible = true
        }
        switchBewegen.setOnClickListener {
            if(!bewegenWerkwoordActive.isVisible){
                bewegenWerkwoordActive.isVisible = true
                bewegenWerkwoordInactive.isVisible = false
            }
            else if (bewegenWerkwoordActive.isVisible){
                bewegenWerkwoordActive.isVisible = false
                bewegenWerkwoordInactive.isVisible = true
            }
        }
        bewegenWerkwoordInactive.setOnClickListener {
            bewegenWerkwoordActive.isVisible = true
            bewegenWerkwoordInactive.isVisible = false
        }

        val transporterenWerkwoordActive = requireViewById<AppCompatButton>(R.id.transporterenWerkwoordActive)
        val transporterenWerkwoordInactive = requireViewById<AppCompatButton>(R.id.transporterenWerkwoordInactive)
        val switchTransporteren = requireViewById<ImageButton>(R.id.switchTransporteren)

        transporterenWerkwoordActive.setOnClickListener {
            transporterenWerkwoordActive.isVisible = false
            transporterenWerkwoordInactive.isVisible = true
        }
        switchTransporteren.setOnClickListener {
            if(!transporterenWerkwoordActive.isVisible){
                transporterenWerkwoordActive.isVisible = true
                transporterenWerkwoordInactive.isVisible = false
            }
            else if (transporterenWerkwoordActive.isVisible){
                transporterenWerkwoordActive.isVisible = false
                transporterenWerkwoordInactive.isVisible = true
            }
        }
        transporterenWerkwoordInactive.setOnClickListener {
            transporterenWerkwoordActive.isVisible = true
            transporterenWerkwoordInactive.isVisible = false
        }

        val overleggenWerkwoordActive = requireViewById<AppCompatButton>(R.id.overleggenWerkwoordActive)
        val overleggenWerkwoordInactive = requireViewById<AppCompatButton>(R.id.overleggenWerkwoordInactive)
        val switchOverleggen = requireViewById<ImageButton>(R.id.switchOverleggen)

        overleggenWerkwoordActive.setOnClickListener {
            overleggenWerkwoordActive.isVisible = false
            overleggenWerkwoordInactive.isVisible = true
        }
        switchOverleggen.setOnClickListener {
            if(!overleggenWerkwoordActive.isVisible){
                overleggenWerkwoordActive.isVisible = true
                overleggenWerkwoordInactive.isVisible = false
            }
            else if (overleggenWerkwoordActive.isVisible){
                overleggenWerkwoordActive.isVisible = false
                overleggenWerkwoordInactive.isVisible = true
            }
        }
        overleggenWerkwoordInactive.setOnClickListener {
            overleggenWerkwoordActive.isVisible = true
            overleggenWerkwoordInactive.isVisible = false
        }

        val lezenWerkwoordActive = requireViewById<AppCompatButton>(R.id.lezenWerkwoordActive)
        val lezenWerkwoordInactive = requireViewById<AppCompatButton>(R.id.lezenWerkwoordInactive)
        val switchLezen = requireViewById<ImageButton>(R.id.switchLezen)

        lezenWerkwoordActive.setOnClickListener {
            lezenWerkwoordActive.isVisible = false
            lezenWerkwoordInactive.isVisible = true
        }
        switchLezen.setOnClickListener {
            if(!lezenWerkwoordActive.isVisible){
                lezenWerkwoordActive.isVisible = true
                lezenWerkwoordInactive.isVisible = false
            }
            else if (lezenWerkwoordActive.isVisible){
                lezenWerkwoordActive.isVisible = false
                lezenWerkwoordInactive.isVisible = true
            }
        }
        lezenWerkwoordInactive.setOnClickListener {
            lezenWerkwoordActive.isVisible = true
            lezenWerkwoordInactive.isVisible = false
        }

        val zoekenWerkwoordActive = requireViewById<AppCompatButton>(R.id.zoekenWerkwoordActive)
        val zoekenWerkwoordInactive = requireViewById<AppCompatButton>(R.id.zoekenWerkwoordInactive)
        val switchZoeken = requireViewById<ImageButton>(R.id.switchZoeken)

        zoekenWerkwoordActive.setOnClickListener {
            zoekenWerkwoordActive.isVisible = false
            zoekenWerkwoordInactive.isVisible = true
        }
        switchZoeken.setOnClickListener {
            if(!zoekenWerkwoordActive.isVisible){
                zoekenWerkwoordActive.isVisible = true
                zoekenWerkwoordInactive.isVisible = false
            }
            else if (zoekenWerkwoordActive.isVisible){
                zoekenWerkwoordActive.isVisible = false
                zoekenWerkwoordInactive.isVisible = true
            }
        }
        zoekenWerkwoordInactive.setOnClickListener {
            zoekenWerkwoordActive.isVisible = true
            zoekenWerkwoordInactive.isVisible = false
        }
    }
}