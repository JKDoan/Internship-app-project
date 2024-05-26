package com.example.insight

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class snapshotFragmentNiveau1Werkwoorden : Fragment(R.layout.snapshot_fragment_niveau1_werkwoorden) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val wachten: AppCompatButton = requireView().findViewById(R.id.wachten) as AppCompatButton
        val overleggen: AppCompatButton = requireView().findViewById(R.id.overleggen) as AppCompatButton
        val bewegen: AppCompatButton = requireView().findViewById(R.id.bewegen) as AppCompatButton
        val zoeken: AppCompatButton = requireView().findViewById(R.id.zoeken) as AppCompatButton
        val transporteren: AppCompatButton = requireView().findViewById(R.id.transporteren) as AppCompatButton
        val lezen: AppCompatButton = requireView().findViewById(R.id.lezen) as AppCompatButton
        val produceren: AppCompatButton = requireView().findViewById(R.id.produceren) as AppCompatButton
        val demonteren: AppCompatButton = requireView().findViewById(R.id.demonteren) as AppCompatButton
        val omstellen: AppCompatButton = requireView().findViewById(R.id.omstellen) as AppCompatButton
        val administreren: AppCompatButton = requireView().findViewById(R.id.administreren) as AppCompatButton
        val opruimen: AppCompatButton = requireView().findViewById(R.id.opruimen) as AppCompatButton
        val herstellen: AppCompatButton = requireView().findViewById(R.id.herstellen) as AppCompatButton

        fun setButtonsGreen() {
            wachten.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            overleggen.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            bewegen.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            zoeken.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            transporteren.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            lezen.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            produceren.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            demonteren.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            omstellen.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            administreren.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            opruimen.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
            herstellen.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden))
        }

        fun setTextWhite() {
            wachten.setTextColor(Color.WHITE)
            overleggen.setTextColor(Color.WHITE)
            bewegen.setTextColor(Color.WHITE)
            zoeken.setTextColor(Color.WHITE)
            transporteren.setTextColor(Color.WHITE)
            lezen.setTextColor(Color.WHITE)
            produceren.setTextColor(Color.WHITE)
            demonteren.setTextColor(Color.WHITE)
            omstellen.setTextColor(Color.WHITE)
            administreren.setTextColor(Color.WHITE)
            opruimen.setTextColor(Color.WHITE)
            herstellen.setTextColor(Color.WHITE)
        }

        fun www() {
            wachten.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.wachten_logo_scale, 0, 0);
            overleggen.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.overleggen_logo_scale, 0, 0);
            bewegen.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.bewegen_logo_scale, 0, 0);
            zoeken.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.zoeken_logo_scale, 0, 0);
            transporteren.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.transporteren_logo_scale, 0, 0);
            lezen.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lezen_logo_scale, 0, 0);
            produceren.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.productie_logo_scale, 0, 0);
            demonteren.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.demonteren_logo_scale, 0, 0);
            omstellen.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.omstellen_logo_scale, 0, 0);
            administreren.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.administreren_logo_scale, 0, 0)
            opruimen.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.opruimen_logo_scale, 0, 0);
            herstellen.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.herstellen_logo_scale, 0, 0)
        }

        fun onClick(v: AppCompatButton) {
            setButtonsGreen()
            v.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        }

        fun changeTextColor(e: AppCompatButton){
            e.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.green_werkwoorden)))
        }

        wachten.setOnClickListener {
            onClick(wachten)
            www()
            setTextWhite()
            changeTextColor(wachten)
            wachten.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.wachten_green_logo_scale, 0, 0);
        }

        overleggen.setOnClickListener {
            onClick(overleggen)
            www()
            setTextWhite()
            changeTextColor(overleggen)
            overleggen
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.overleggen_green_logo_scale, 0, 0)
        }

        bewegen.setOnClickListener {
            onClick(bewegen)
            www()
            setTextWhite()
            changeTextColor(bewegen)
            bewegen
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.bewegen_green_logo_scale, 0, 0)
        }

        zoeken.setOnClickListener {
            www()
            onClick(zoeken)
            setTextWhite()
            changeTextColor(zoeken)
            zoeken
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.zoeken_green_logo_scale, 0, 0)
        }

        transporteren.setOnClickListener {
            www()
            onClick(transporteren)
            setTextWhite()
            changeTextColor(transporteren)
            transporteren
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.transporteren_green_logo_scale, 0, 0)
        }

        lezen.setOnClickListener {
            www()
            onClick(lezen)
            setTextWhite()
            changeTextColor(lezen)
            lezen
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lezen_green_logo_scale, 0, 0)
        }

        produceren.setOnClickListener {
            www()
            onClick(produceren)
            setTextWhite()
            changeTextColor(produceren)
            produceren
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.productie_green_logo_scale, 0, 0)
        }

        demonteren.setOnClickListener {
            www()
            onClick(demonteren)
            setTextWhite()
            changeTextColor(demonteren)
            demonteren
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.demonteren_green_logo_scale, 0, 0)
        }

        omstellen.setOnClickListener {
            www()
            onClick(omstellen)
            setTextWhite()
            changeTextColor(omstellen)
            omstellen
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.omstellen_green_logo_scale, 0, 0)
        }

        administreren.setOnClickListener {
            www()
            onClick(administreren)
            setTextWhite()
            changeTextColor(administreren)
            administreren
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.administreren_green_logo_scale, 0, 0)
        }

        opruimen.setOnClickListener {
            www()
            onClick(opruimen)
            setTextWhite()
            changeTextColor(opruimen)
            opruimen
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.opruimen_green_logo_scale, 0, 0)
        }

        herstellen.setOnClickListener {
            www()
            onClick(herstellen)
            setTextWhite()
            changeTextColor(herstellen)
            herstellen
                .setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.herstellen_green_logo_scale, 0, 0)
        }
    }

}