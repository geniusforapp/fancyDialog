package com.geniusforapp.fancydialog.builders

import android.content.Context
import androidx.annotation.BoolRes
import androidx.annotation.StringRes
import com.geniusforapp.fancydialog.FancyAlertDialog
import com.geniusforapp.fancydialog.R


abstract class BaseFancyBuilder<T>(private val context: Context, private var style: Int = R.style.FancyDialogTheme) {


    abstract var type: T

    open var title: String? = null
    open var subTitle: String? = null
    open var message: String? = null
    open var isCancelable = true


    open fun withTitle(title: String?): T {
        this.title = title
        return type
    }

    open fun withTitle(@StringRes title: Int): T {
        this.title = context.getString(title)
        return type
    }


    open fun withSubTitle(@StringRes subTitle: Int): T {
        this.subTitle = context.getString(subTitle)
        return type
    }


    open fun withSubTitle(subTitle: String): T {
        this.subTitle = subTitle
        return type
    }

    open fun withMessage(@StringRes message: Int): T {
        this.message = context.getString(message)
        return type
    }


    open fun withMessage(message: String): T {
        this.message = message
        return type
    }

    open fun withCanCancel(canCancel: Boolean): T {
        this.isCancelable = canCancel
        return type
    }

    private fun create(): FancyAlertDialog {
        return FancyAlertDialog(context, style)
    }


    fun show(): FancyAlertDialog {
        val dialog = create()
        dialog.show(this)
        return dialog
    }
}
