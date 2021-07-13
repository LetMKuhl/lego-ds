package com.lehlagoo.legods.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.CardViewBinding

class CardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var textCard: String? = null
    private var numberComments: String? = null
    private var numberLikes: String? = null
    private var layoutColor: Int? = null

    private val cardViewBinding =
        CardViewBinding.inflate(LayoutInflater.from(context), this, true)

    private var cardTextState: CardState = CardState.Text
        set(value) {
            field = value
            refreshState()
        }

    private var numberCommentState: CardState = CardState.Comment
        set(value) {
            field = value
            refreshState()
        }

    private var numberLikeState: CardState = CardState.Like
        set(value) {
            field = value
            refreshState()
        }

    private var layoutColorState: CardState = CardState.Like
        set(value) {
            field = value
            refreshState()
        }

    init {
        setAvatarCardLayout(attrs)
        refreshState()
    }

    private fun setAvatarCardLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.CardView
            )

            val textCardResId =
                attributes.getResourceId(R.styleable.CardView_text_card, 0)
            if (textCardResId != 0) {
                textCard = context.getString(textCardResId)
            }

            val numberCommentsResId =
                attributes.getResourceId(
                    R.styleable.CardView_number_comments, 0
                )
            if (numberCommentsResId != 0) {
                numberComments = context.getString(numberCommentsResId)
            }

            val numberLikesResId =
                attributes.getResourceId(
                    R.styleable.CardView_number_likes, 0
                )
            if (numberLikesResId != 0) {
                numberLikes = context.getString(numberLikesResId)
            }

            attributes.recycle()
        }
    }

    private fun refreshState() {

        isEnabled = cardTextState.isEnabled
        isClickable = cardTextState.isEnabled

        refreshDrawableState()

        cardViewBinding.textExampleCard.run {
            isEnabled = cardTextState.isEnabled
        }

        when (cardTextState) {
            CardState.Text ->
                cardViewBinding.textExampleCard.text = textCard
        }

        cardViewBinding.numberExampleComments.run {
            isEnabled = numberCommentState.isEnabled
        }

        when (numberCommentState) {
            CardState.Comment ->
                cardViewBinding.numberExampleComments.text = numberComments
        }

        cardViewBinding.numberExampleLikes.run {
            isEnabled = numberLikeState.isEnabled
        }

        when (numberLikeState) {
            CardState.Like ->
                cardViewBinding.numberExampleLikes.text = numberLikes
        }

    }

    sealed class CardState(val isEnabled: Boolean, progressVisibility: Int) {
        object Text : CardState(true, View.GONE)
        object Comment : CardState(true, View.GONE)
        object Like : CardState(true, View.GONE)

    }

}