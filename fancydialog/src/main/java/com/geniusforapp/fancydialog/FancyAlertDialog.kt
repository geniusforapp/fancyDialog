package com.geniusforapp.fancydialog

import android.content.Context
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.geniusforapp.fancydialog.builders.FancyDialogBuilder
import kotlinx.android.synthetic.main.dialog_fancy_alert.*

class FancyAlertDialog(context: Context) : BaseFancyDialog<FancyDialogBuilder, FancyAlertDialog>(context) {


    override var dialogInstance: FancyAlertDialog = this

    override fun bindView(saveInstanceState: Bundle?) {
        initBuilder()
        initData()
        initActions()
        initActionsClick()
        initTypeFace()
    }

    private fun initTypeFace() {
        baseFancyBuilder.titleTypeFace?.let { textTitle.typeface = it }
        baseFancyBuilder.subTitleTypeFace?.let { textSubTitle.typeface = it }
        baseFancyBuilder.actionPositiveTypeFace?.let { actionPositive.typeface = it }
        baseFancyBuilder.actionNegativeTypeFace?.let { actionNegative.typeface = it }
    }

    private fun initActionsClick() {
        actionPositive.setOnClickListener { handlePositive() }
        actionNegative.setOnClickListener { handleNegative() }
    }

    private fun handleNegative() {
        baseFancyBuilder.onActionNegativeClicked?.let { it.onClick(actionNegative, this) }
    }

    private fun handlePositive() {
        baseFancyBuilder.onActionPositiveClicked?.let { it.onClick(actionPositive, this) }
    }

    private fun initActions() {
        context.let {
            actionPositive.setTextColor(ContextCompat.getColor(it, R.color.colorPositive))
            actionNegative.setTextColor(ContextCompat.getColor(it, R.color.colorNegative))
        }
        actionPositive.text = baseFancyBuilder.actionPositive
        actionNegative.text = baseFancyBuilder.actionNegative

    }

    private fun initData() {
        textTitle.text = baseFancyBuilder.title
        textSubTitle.text = baseFancyBuilder.subTitle
        imageIcon.setImageDrawable(baseFancyBuilder.imageDrawable)
    }

    private fun initBuilder() {

    }

    override fun setContentView() = R.layout.dialog_fancy_alert

}
