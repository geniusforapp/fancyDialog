package com.geniusforapp.fancydialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.geniusforapp.fancydialog.builders.BaseFancyBuilder


abstract class BaseFancyDialog<T : BaseFancyBuilder<*>, D : Dialog>(context: Context) : AlertDialog(context, R.style.FancyDialogTheme) {

    open lateinit var baseFancyBuilder: T

    abstract var dialogInstance: D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
        bindView(savedInstanceState)
    }

    open fun show(baseFancyBuilder: BaseFancyBuilder<*>): Dialog? {
        this.baseFancyBuilder = baseFancyBuilder as T
        this.show()
        return this
    }


    abstract fun bindView(saveInstanceState: Bundle?)


    abstract fun setContentView(): Int
}