package com.geniusforapp.fancydialog.builders

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.geniusforapp.fancydialog.interfaces.OnActionClickedListener


class FancyDialogBuilder(private val context: Context) : BaseFancyBuilder<FancyDialogBuilder>(context) {


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


    fun withTitleTypeFace(@FontRes font: Int): FancyDialogBuilder {
        titleTypeFace = ResourcesCompat.getFont(context, font)
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
    fun withPositive(@StringRes actionPositive: String, onActionPositiveClicked: OnActionClickedListener): FancyDialogBuilder {
        this.actionPositive = actionPositive
        this.onActionPositiveClicked = onActionPositiveClicked
        return this
    }

    // with positive title and action with int id
    fun withPositive(@StringRes actionPositive: Int, onActionPositiveClicked: OnActionClickedListener): FancyDialogBuilder {
        this.actionPositive = context.getString(actionPositive)
        this.onActionPositiveClicked = onActionPositiveClicked
        return this
    }

    fun withNegative(@StringRes actionNegative: String, onActionNegativeClicked: OnActionClickedListener): FancyDialogBuilder {
        this.actionNegative = actionNegative
        this.onActionNegativeClicked = onActionNegativeClicked
        return this
    }

    fun withNegative(@StringRes actionNegative: Int, onActionNegativeClicked: OnActionClickedListener): FancyDialogBuilder {
        this.actionNegative = context.getString(actionNegative)
        this.onActionNegativeClicked = onActionNegativeClicked
        return this
    }

    // set the image Icon
    fun withImageIcon(@DrawableRes imageDrawable: Drawable?): FancyDialogBuilder {
        this.imageDrawable = imageDrawable
        return this
    }

    fun withImageIcon(@DrawableRes imageDrawable: Int): FancyDialogBuilder {
        this.imageDrawable = ContextCompat.getDrawable(context, imageDrawable)
        return this
    }


}