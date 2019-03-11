package com.geniusforapp.fancysample

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity.END
import android.view.Gravity.START
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geniusforapp.fancydialog.builders.FancyDialogBuilder
import com.geniusforapp.fancydialog.interfaces.OnActionClickedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            buildAndShowDialog()
        }
    }

    private fun buildAndShowDialog() {
        val dialog = FancyDialogBuilder(this)
                .withCanCancel(false)
                .withTitleTypeFace(R.font.roboto_bold)
                .withSubTitleTypeFace(R.font.roboto_medium)
                .withActionPositiveTypeFace(R.font.roboto)
                .withActionNegativeTypeFace(R.font.roboto)
                .withTextGravity(START)
                .withPanelGravity(END)
                .withTitle(R.string.dialog_text_title)
                .withSubTitle(R.string.dialog_text_message)
                .withPositive(R.string.dialog_action_yes, object : OnActionClickedListener {
                    override fun onClick(view: View, dialog: Dialog) {
                        Toast.makeText(this@MainActivity, "Why Me ?", Toast.LENGTH_LONG).show()
                    }
                })
                .withNegative(R.string.dialog_action_no, object : OnActionClickedListener {
                    override fun onClick(view: View, dialog: Dialog) {
                        dialog.dismiss()

                    }
                })
        dialog.show()
    }
}
