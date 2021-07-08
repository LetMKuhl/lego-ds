package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.lehlagoo.legods.databinding.ProgressButtonBinding

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var titleButton: String? = null
    private var titleDesableButton: String? = null

    private val binding = ProgressButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {

    }

    private fun setLayout(attrs: AttributeSet) {

    }

}