package com.geniusforapp.fancysample

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity.END
import android.view.Gravity.START
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.geniusforapp.fancydialog.builders.fancy
import com.geniusforapp.fancydialog.interfaces.OnActionClickedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnActionClickedListener {

    val carsRepo = CarsRepo.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            buildAndShowDialog()
            carsRepo.addCar("test")
        }


    }

    private fun buildAndShowDialog() {
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

