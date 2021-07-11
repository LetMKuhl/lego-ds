package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.ProgressPrimaryButtonBinding

class ProgressPrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var titlePrimaryButton: String? = null
    private var titlePrimaryDisabledButton: String? = null

    private val primaryBinding = ProgressPrimaryButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    private var state: ProgressPrimaryButtonState = ProgressPrimaryButtonState.Normal
        set(value) {
            field = value
            refreshState()
        }

    init {
        setPrimaryLayout(attrs)
        refreshState()
    }

    private fun setPrimaryLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressPrimaryButton
            )
            setBackgroundResource(R.drawable.button_progress_state_primary)

            val titlePrimaryResId =
                attributes.getResourceId(R.styleable.ProgressPrimaryButton_title_primary_button, 0)
            if (titlePrimaryResId != 0) {
                titlePrimaryButton = context.getString(titlePrimaryResId)
            }

            val titlePrimaryDeResId =
                attributes.getResourceId(
                    R.styleable.ProgressPrimaryButton_title_primary_disabled_button,
                    0
                )
            if (titlePrimaryResId != 0) {
                titlePrimaryDisabledButton = context.getString(titlePrimaryDeResId)
            }

            attributes.recycle()
        }
    }

    private fun refreshState() {

        isEnabled = state.isEnabled
        isClickable = state.isEnabled

        refreshDrawableState()

        primaryBinding.textPrimaryButton.run {
            isEnabled = state.isEnabled
            isClickable = state.isEnabled
        }

        when (state) {
            ProgressPrimaryButtonState.Normal ->
                primaryBinding.textPrimaryButton.text = titlePrimaryButton
            ProgressPrimaryButtonState.Disabled ->
                primaryBinding.textPrimaryButton.text = titlePrimaryDisabledButton
        }
    }

    fun setDisabled() {
        state = ProgressPrimaryButtonState.Disabled
        primaryBinding.ivChevronRightPrimary.isVisible = false
    }

    fun setNormal() {
        state = ProgressPrimaryButtonState.Normal
        primaryBinding.ivChevronRightPrimary.isVisible = true
    }

    sealed class ProgressPrimaryButtonState(val isEnabled: Boolean, progressVisibility: Int) {

        object Normal : ProgressPrimaryButtonState(true, View.GONE)
        object Disabled : ProgressPrimaryButtonState(false, View.VISIBLE)

    }

}