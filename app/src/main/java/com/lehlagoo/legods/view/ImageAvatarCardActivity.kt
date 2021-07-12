package com.lehlagoo.legods.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.ActivityImageAvatarCardBinding

class ImageAvatarCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityImageAvatarCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val followButton = findViewById<Button>(R.id.follow_button)

        followButton.setOnClickListener{
            binding.avatarCard.setFollowOrUnfollow()
        }



    }


}