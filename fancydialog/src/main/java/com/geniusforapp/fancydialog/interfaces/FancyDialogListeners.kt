package com.geniusforapp.fancydialog.interfaces

import android.app.Dialog
import android.view.View

interface OnActionClickedListener {
    fun onClick(view: View, dialog: Dialog)
}


enum class PanelGravity {
    LEFT,
    RIGHT,
    CENTER
}

enum class TextGravity {
    LEFT,
    RIGHT,
    CENTER
}