package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.ProgressSecundaryButtonBinding

class ProgressSecondaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var titleSecondaryButton: String? = null
    private var titleSecondaryDisabledButton: String? = null

    private val secondaryBinding = ProgressSecundaryButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    private var state: ProgressSecondaryButton.ProgressSecondaryButtonState = ProgressSecondaryButton.ProgressSecondaryButtonState.Normal
        set(value) {
            field = value
            refreshState()
        }

    init {
        setSecondaryLayout(attrs)
        refreshState()
    }

    private fun setSecondaryLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressSecondaryButton
            )
            setBackgroundResource(R.drawable.button_progress_state_secundary)

            val titleSecondaryResId =
                attributes.getResourceId(R.styleable.ProgressSecondaryButton_title_secondary_button, 0)
            if (titleSecondaryResId != 0){
                titleSecondaryButton = context.getString(titleSecondaryResId)
            }

            val titleSecondaryDeResId =
                attributes.getResourceId(R.styleable.ProgressSecondaryButton_title_secondary_disabled_button, 0)
            if (titleSecondaryDeResId != 0){
                titleSecondaryDisabledButton = context.getString(titleSecondaryDeResId)
            }


            attributes.recycle()
        }
    }

    private fun refreshState() {

        isEnabled = state.isEnabled
        isClickable = state.isEnabled

        refreshDrawableState()

        secondaryBinding.textSecondaryButton.run {
            isEnabled = state.isEnabled
            isClickable = state.isEnabled
        }

        when (state) {
            ProgressSecondaryButtonState.Normal ->
                secondaryBinding.textSecondaryButton.text = titleSecondaryButton
            ProgressSecondaryButtonState.Disabled ->
                secondaryBinding.textSecondaryButton.text = titleSecondaryDisabledButton
        }
    }

    fun setDisabled() {
        state = ProgressSecondaryButtonState.Disabled
        secondaryBinding.ivChevronRightSecondary.isVisible = false
        secondaryBinding.textSecondaryButton.setTextColor(context.getColor(R.color.color_black_800))
    }

    fun setNormal() {
        state = ProgressSecondaryButtonState.Normal
        secondaryBinding.ivChevronRightSecondary.isVisible = true
        secondaryBinding.textSecondaryButton.setTextColor(context.getColor(R.color.color_white))
    }

    sealed class ProgressSecondaryButtonState(val isEnabled: Boolean, progressVisibility: Int) {

        object Normal : ProgressSecondaryButtonState(true, View.GONE)
        object Disabled : ProgressSecondaryButtonState(false, View.VISIBLE)

    }


}