package com.geniusforapp.fancydialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.constraintlayout.widget.ConstraintLayout
import com.geniusforapp.fancydialog.builders.FancyDialogBuilder
import com.geniusforapp.fancydialog.ktx.gone
import com.geniusforapp.fancydialog.ktx.visible
import kotlinx.android.synthetic.main.dialog_fancy_alert.*

class FancyAlertDialog(context: Context) : BaseFancyDialog<FancyDialogBuilder, FancyAlertDialog>(context) {


    private val fancyDialogMargin = context.resources.getDimension(R.dimen.fancyDialogMargin).toInt()

    override var dialogInstance: FancyAlertDialog = this

    override fun bindView(saveInstanceState: Bundle?) {
        initBuilder()
        initData()
        initActions()
        initActionsClick()
        initTypeFace()
        initTextGravity()
        initPanelGravity()
        initViability()
    }

    private fun initViability() {
        // hide the views on null
        if (baseFancyBuilder.imageDrawable == null) {
            imageIcon.gone()
        } else {
            imageIcon.visible()
        }
        // hide the views on null
        if (baseFancyBuilder.actionPositive == null) {
            actionPositive.gone()
        } else {
            actionPositive.visible()
        }

        // hide the views on null
        if (baseFancyBuilder.actionNegative == null) {
            actionNegative.gone()
        } else {
            actionNegative.visible()
        }
    }

    private fun initPanelGravity() {
        when (baseFancyBuilder.panelGravity) {
            Gravity.START -> panelStart()
            Gravity.CENTER -> panelCenter()
        }

    }

    private fun panelCenter() {
        actionNegative.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
                .apply {
                    startToStart = textSubTitle.id
                    endToStart = actionPositive.id
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    topToBottom = textSubTitle.id
                    setMargins(fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin)
                    horizontalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED
                }

        actionPositive.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
                .apply {
                    startToEnd = actionNegative.id
                    endToEnd = textSubTitle.id
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    topToBottom = textSubTitle.id
                    setMargins(fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin)
                }
    }

    private fun panelStart() {
        actionNegative.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
                .apply {
                    startToStart = textSubTitle.id
                    endToStart = actionPositive.id
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    topToBottom = textSubTitle.id
                    setMargins(fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin)
                }

        actionPositive.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
                .apply {
                    startToEnd = actionNegative.id
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    topToBottom = textSubTitle.id
                    setMargins(fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin,
                            fancyDialogMargin)
                }
    }

    private fun initTextGravity() {
        textTitle.gravity = baseFancyBuilder.textGravity
        textSubTitle.gravity = baseFancyBuilder.textGravity
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
