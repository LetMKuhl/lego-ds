package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.CustomCardViewBinding

class CustomCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var textCardView: String? = null
    private var cardViewDateText: String? = null
    private var backgroundCardView: Int? = null

    private val cardBinding = CustomCardViewBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {
        setCardLayout(attrs)
    }

    private fun setCardLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.CustomCardView
            )

            setBackgroundResource(R.drawable.custom_card_view_shape)

            val titleCardTextResId =
                attributes.getResourceId(R.styleable.CustomCardView_text_card_view, 0)
            if (titleCardTextResId != 0) {
                textCardView = context.getString(titleCardTextResId)
            }

            val titleCardDateResId =
                attributes.getResourceId(R.styleable.CustomCardView_card_view_date_text, 0)
            if (titleCardDateResId != 0) {
                cardViewDateText = context.getString(titleCardDateResId)
            }

            val titleCardBackgroundResId =
                attributes.getResourceId(R.styleable.CustomCardView_background_card_view, 0)
            if (titleCardBackgroundResId != 0) {
                backgroundCardView = context.getColor(titleCardBackgroundResId)
            }

            attributes.recycle()

        }
    }


}