package com.geniusforapp.fancydialog.interfaces

import android.app.Dialog
import android.view.View

interface OnActionClickedListener {
    fun onClick(view: View, dialog: Dialog)
}


enum class Gravity {
    START,
    END,
    CENTER
}