package com.example.insight

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class snapshotFragmentMeting : Fragment(R.layout.snapshot_fragment_meting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileSwitch: ImageButton =
            requireView().findViewById(R.id.profileswitch)
        var isPressed = false
        profileSwitch.setOnClickListener {
            if (isPressed) {
                profileSwitch.setImageResource(R.drawable.twopersons_logo_scale)
                isPressed = !isPressed
            } else {
                profileSwitch.setImageResource(R.drawable.ic_oneperson);
                isPressed = !isPressed
            }
        }

        val addCommentSnapshot: ImageButton =
            requireView().findViewById(R.id.addCommentSnapshot)

        addCommentSnapshot.setOnClickListener {
            val addCommentSnapshot = AlertDialog.Builder(view.context)
            val inflater = layoutInflater
            val addComment: View =
                inflater.inflate(R.layout.snapshot_fragment_dialog_add_comment, null)

            addCommentSnapshot.setTitle("Opmerking toevoegen")
                .setView(addComment)
                .setNegativeButton("Annuleren", null)
                .setPositiveButton("Toevoegen", null)
                .show()
        }
    }
}
