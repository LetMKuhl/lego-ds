package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.R
import com.lehlagoo.legods.databinding.ProgressSecundaryButtonBinding

class ProgressSecondaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var titleSecondaryButton: String? = null
    private var titleSecondaryDesableButton: String? = null

    private val secondaryBinding = ProgressSecundaryButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {

    }

    private fun setSecondaryLayout(attrs: AttributeSet) {
        attrs?.let { attributeSet ->
//            val attributes = context.obtainStyledAttributes(
//                attributeSet,
//                R.styleable.ProgressSecondaryButton
//            )
//            setBackgroundResource(R.drawable.title_secondary_button)

//            attributes.recycle()
        }
    }

}