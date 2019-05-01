package com.geniusforapp.fancydialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.geniusforapp.fancydialog.builders.BaseFancyBuilder


abstract class BaseFancyDialog<T : BaseFancyBuilder<*>, D : Dialog>(context: Context, style: Int = R.style.FancyDialogTheme) : AlertDialog(context, style) {


    val defStyle: Int = R.style.FancyDialogTheme

    open lateinit var baseFancyBuilder: T

    abstract var dialogInstance: D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
        bindView(savedInstanceState)
    }

    @Suppress("UNCHECKED_CAST")
    open fun show(baseFancyBuilder: BaseFancyBuilder<*>): Dialog? {
        this.baseFancyBuilder = baseFancyBuilder as T
        this.setCanceledOnTouchOutside(baseFancyBuilder.isCancelable)
        this.show()
        return this
    }

    abstract fun bindView(saveInstanceState: Bundle?)


    abstract fun setContentView(): Int


}