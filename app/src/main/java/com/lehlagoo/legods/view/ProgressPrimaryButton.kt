package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.R
import com.lehlagoo.legods.databinding.ProgressPrimaryButtonBinding

class ProgressPrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var titlePrimaryButton: String? = null
    private var titlePrimaryDesableButton: String? = null

    private val primaryBinding = ProgressPrimaryButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {

    }

    private fun setPrimaryLayout(attrs: AttributeSet) {
        attrs?.let { attributeSet ->
//            val attributes = context.obtainStyledAttributes(
//                attributeSet,
//                R.styleable.ProgressPrimaryButton
//            )
//            setBackgroundResource(R.drawable.title_primary_button)

//            attributes.recycle()
        }
    }

}