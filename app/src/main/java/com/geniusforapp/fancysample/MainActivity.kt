package com.geniusforapp.fancysample

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity.END
import android.view.Gravity.START
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.geniusforapp.fancydialog.builders.fancy
import com.geniusforapp.fancydialog.interfaces.OnActionClickedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnActionClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            buildAndShowDialog()
        }


    }

    private fun buildAndShowDialog() {

        /*  val dialog = FancyDialogBuilder(this)
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
                          Toast.makeText(this@MainActivity, "Why Me ?", Toast.LENGTH_LONG).show()
                      }
                  })
          dialog.show()*/

        fancy(this) {
            imageDrawable = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_picture)
            isCancelable = true
            titleTypeFace = ResourcesCompat.getFont(this@MainActivity, R.font.roboto_bold)
            subTitleTypeFace = ResourcesCompat.getFont(this@MainActivity, R.font.roboto_medium)
            actionPositiveTypeFace = ResourcesCompat.getFont(this@MainActivity, R.font.roboto)
            actionNegativeTypeFace = ResourcesCompat.getFont(this@MainActivity, R.font.roboto)
            textGravity = START
            panelGravity = END
            title = getString(R.string.dialog_text_title)
            subTitle = getString(R.string.dialog_text_message)
            actionPositive = getString(R.string.dialog_action_yes)
            actionNegative = getString(R.string.dialog_action_no)
            onActionPositiveClicked = this@MainActivity
            onActionNegativeClicked = this@MainActivity
        }.show()
    }

    override fun onClick(view: View, dialog: Dialog) {
        dialog.dismiss()
    }


}

