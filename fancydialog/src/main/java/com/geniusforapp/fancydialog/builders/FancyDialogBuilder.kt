package com.geniusforapp.fancydialog.builders

import android.app.Dialog
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.Gravity.CENTER
import android.view.Gravity.END
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.geniusforapp.fancydialog.R
import com.geniusforapp.fancydialog.interfaces.OnActionClickedListener


class FancyDialogBuilder(private val context: Context, private var style: Int = R.style.FancyDialogTheme) : BaseFancyBuilder<FancyDialogBuilder>(context, style) {


    override var type: FancyDialogBuilder = this

    var imageDrawable: Drawable? = null

    // positive button
    var actionPositive: String? = null
    var onActionPositiveClicked: OnActionClickedListener? = null

    // negative button
    var actionNegative: String? = null
    var onActionNegativeClicked: OnActionClickedListener? = null

    var titleTypeFace: Typeface? = null
    var subTitleTypeFace: Typeface? = null
    var actionPositiveTypeFace: Typeface? = null
    var actionNegativeTypeFace: Typeface? = null


    var textGravity: Int = CENTER
    var panelGravity: Int = END


    fun withTitleTypeFace(@FontRes font: Int): FancyDialogBuilder {
        titleTypeFace = ResourcesCompat.getFont(context, font)
        return this
    }

    fun withTextGravity(gravity: Int): FancyDialogBuilder {
        textGravity = gravity
        return this
    }

    fun withPanelGravity(gravity: Int): FancyDialogBuilder {
        panelGravity = gravity
        return this
    }

    fun withSubTitleTypeFace(@FontRes font: Int): FancyDialogBuilder {
        subTitleTypeFace = ResourcesCompat.getFont(context, font)
        return this
    }

    fun withActionPositiveTypeFace(@FontRes font: Int): FancyDialogBuilder {
        actionPositiveTypeFace = ResourcesCompat.getFont(context, font)
        return this
    }


    fun withActionNegativeTypeFace(@FontRes font: Int): FancyDialogBuilder {
        actionPositiveTypeFace = ResourcesCompat.getFont(context, font)
        return this
    }


    // with positive title and action
    fun withPositive(actionPositive: String, onActionPositiveClicked: (view: View, dialog: Dialog) -> Unit?): FancyDialogBuilder {
        this.actionPositive = actionPositive
        this.onActionPositiveClicked = object : OnActionClickedListener {
            override fun onClick(view: View, dialog: Dialog) {
                onActionPositiveClicked(view, dialog)
            }
        }
        return this
    }

    // with positive title and action with int id
    fun withPositive(@StringRes actionPositive: Int, onActionPositiveClicked: (view: View, dialog: Dialog) -> Unit?): FancyDialogBuilder {
        this.actionPositive = context.getString(actionPositive)
        this.onActionPositiveClicked = object : OnActionClickedListener {
            override fun onClick(view: View, dialog: Dialog) {
                onActionPositiveClicked(view, dialog)
            }
        }
        return this
    }

    fun withNegative(actionNegative: String, onActionNegativeClicked: (view: View, dialog: Dialog) -> Unit?): FancyDialogBuilder {
        this.actionNegative = actionNegative
        this.onActionNegativeClicked = object : OnActionClickedListener {
            override fun onClick(view: View, dialog: Dialog) {
                onActionNegativeClicked(view, dialog)
            }
        }
        return this
    }

    fun withNegative(@StringRes actionNegative: Int, onActionNegativeClicked: (view: View, dialog: Dialog) -> Unit?): FancyDialogBuilder {
        this.actionNegative = context.getString(actionNegative)
        this.onActionNegativeClicked = object : OnActionClickedListener {
            override fun onClick(view: View, dialog: Dialog) {
                onActionNegativeClicked(view, dialog)
            }
        }
        return this
    }

    // set the image Icon
    fun withImageIcon(imageDrawable: Drawable?): FancyDialogBuilder {
        this.imageDrawable = imageDrawable
        return this
    }

    fun withImageIcon(@DrawableRes imageDrawable: Int): FancyDialogBuilder {
        this.imageDrawable = ContextCompat.getDrawable(context, imageDrawable)
        return this
    }


}

fun fancy(context: Context, block: FancyDialogBuilder.() -> Unit): FancyDialogBuilder = FancyDialogBuilder(context).apply(block)
