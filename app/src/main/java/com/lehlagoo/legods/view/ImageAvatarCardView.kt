package com.lehlagoo.legods.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.ImageAvatarCardViewBinding

class ImageAvatarCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var avatarUsername: String? = null
    private var avatarUsernameJob: String? = null
    private var followButton: String? = null
    private var unfollowButton: String? = null

    private val avatarBinding =
        ImageAvatarCardViewBinding.inflate(LayoutInflater.from(context), this, true)

    private var buttonState: ChangeCardState = ChangeCardState.Follow
        set(value) {
            field = value
            refreshState()
        }

    private var usernameState: ChangeCardState = ChangeCardState.User
        set(value) {
            field = value
            refreshState()
        }

    private var jobState: ChangeCardState = ChangeCardState.Job
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
                R.styleable.ImageAvatarCardView
            )
            setBackgroundResource(R.drawable.avatar_follow_card_view)

            val avatarUsernameResId =
                attributes.getResourceId(R.styleable.ImageAvatarCardView_avatar_username, 0)
            if (avatarUsernameResId != 0) {
                avatarUsername = context.getString(avatarUsernameResId)
            }

            val avatarJobResId =
                attributes.getResourceId(
                    R.styleable.ImageAvatarCardView_avatar_username_job, 0
                )
            if (avatarJobResId != 0) {
                avatarUsernameJob = context.getString(avatarJobResId)
            }

            val followButtonResId =
                attributes.getResourceId(
                    R.styleable.ImageAvatarCardView_follow_button, 0
                )
            if (followButtonResId != 0) {
                followButton = context.getString(followButtonResId)
            }

            val unfollowButtonResId =
                attributes.getResourceId(
                    R.styleable.ImageAvatarCardView_unfollow_button, 0
                )
            if (unfollowButtonResId != 0) {
                unfollowButton = context.getString(unfollowButtonResId)
            }

            attributes.recycle()
        }
    }

    private fun refreshState() {

        isEnabled = buttonState.isEnabled
        isClickable = buttonState.isEnabled

        refreshDrawableState()

        avatarBinding.followButton.run {
            isEnabled = true
            isClickable = true
        }

        when (buttonState) {
            ChangeCardState.Follow ->
                avatarBinding.followButton.text = followButton
            ChangeCardState.Unfollow ->
                avatarBinding.followButton.text = unfollowButton
        }

        avatarBinding.avatarUsername.run {
            isEnabled = buttonState.isEnabled
        }

        when (usernameState) {
            ChangeCardState.User ->
                avatarBinding.avatarUsername.text = avatarUsername
        }

        avatarBinding.avatarUsernameJob.run {
            isEnabled = buttonState.isEnabled
        }

        when (jobState) {
            ChangeCardState.Job ->
                avatarBinding.avatarUsernameJob.text = avatarUsernameJob
        }
    }

    fun setFollowOrUnfollow() {
        if (buttonState.isEnabled) {
            buttonState = ChangeCardState.Unfollow
            avatarBinding.followButton.text = resources.getString(R.string.unfollow_status)
            avatarBinding.followButton.setBackgroundColor(context.getColor(R.color.color_red))
        } else {
            buttonState = ChangeCardState.Follow
            avatarBinding.followButton.text = context.getString(R.string.follow_button)
            avatarBinding.followButton.setBackgroundColor(context.getColor(R.color.color_yellow))
        }

    }

    sealed class ChangeCardState(val isEnabled: Boolean, progressVisibility: Int) {
        object User : ChangeCardState(true, View.GONE)
        object Job : ChangeCardState(true, View.GONE)
        object Follow : ChangeCardState(true, View.GONE)
        object Unfollow : ChangeCardState(false, View.INVISIBLE)

    }

}