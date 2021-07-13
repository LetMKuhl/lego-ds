package com.lehlagoo.legods.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.lehlagoo.legods.databinding.ActivityMainBinding
import com.lehlagoo.legods.preferences.AppPreferences
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

private const val PROFILE_NAME = "Leticia Lago Mori - Dev Android"

class MainActivity : AppCompatActivity() {

    private val preferences: AppPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences.saveProfileName(PROFILE_NAME)
        val profileName = preferences.getProfileName()
        Toast.makeText(this, profileName, Toast.LENGTH_LONG).show()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonPrimary.setOnClickListener {
            binding.buttonPrimary.setDisabled()
            val intent = Intent(this, ImageAvatarCardActivity::class.java)

            lifecycleScope.launch {
                delay(2_000)
                binding.buttonPrimary.setNormal()
                startActivity(intent)
            }

        }

        binding.buttonSecondary.setOnClickListener {
            binding.buttonSecondary.setDisabled()
            val intent = Intent(this, CardViewActivity::class.java)
            lifecycleScope.launch {
                delay(2_000)
                binding.buttonSecondary.setNormal()
                startActivity(intent)
            }
        }

    }

}