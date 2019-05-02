package com.geniusforapp.fancysample

import android.os.Bundle
import android.view.Gravity.*
import androidx.appcompat.app.AppCompatActivity
import com.geniusforapp.fancydialog.builders.FancyDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        buildAndShowDialog()
        fab.setOnClickListener {
            buildAndShowDialog()
        }


    }

    private fun buildAndShowDialog() {
        val dialog = FancyDialogBuilder(this, R.style.CustomDialog)
                .withCanCancel(false)
                .withImageIcon(R.drawable.endgame)
                .withTitleTypeFace(R.font.roboto_bold)
                .withSubTitleTypeFace(R.font.roboto_medium)
                .withActionPositiveTypeFace(R.font.roboto_bold)
                .withActionNegativeTypeFace(R.font.roboto_bold)
                .withTextGravity(CENTER)
                .withPanelGravity(END)
                .withTitle(R.string.dialog_text_title)
                .withSubTitle(R.string.dialog_text_message)
                .withPositive(R.string.dialog_action_yes) { view, dialog -> dialog.dismiss() }
        dialog.show()
    }

}

