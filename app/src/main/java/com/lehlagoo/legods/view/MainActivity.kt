package com.lehlagoo.legods.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.lehlagoo.legods.R
import com.lehlagoo.legods.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

//    companion object {
//
//        fun mainActivity() = MainActivity
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.iconButtomPrimary.setOnClickListener {
            binding.iconButtomPrimary.setDisabled()
            val intent = Intent(this, ImageAvatarCardActivity::class.java)

            lifecycleScope.launch {
                delay(2_000)
                binding.iconButtomPrimary.setNormal()
                startActivity(intent)
            }

        }

        binding.iconButtomSecondary.setOnClickListener {
            binding.iconButtomSecondary.setDisabled()

            lifecycleScope.launch {
                delay(2_000)
                binding.iconButtomSecondary.setNormal()
            }
        }

    }

}