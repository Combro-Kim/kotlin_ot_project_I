package com.example.kotlin_ot_project_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.kotlin_ot_project_i.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener {
            val intent = Intent (this, PersonalActivity::class.java)
            startActivity(intent)
        }

        binding.imageButton2.setOnClickListener {
            val intent = Intent (this, PersonalActivity::class.java)
            startActivity(intent)
        }

        binding.imageButton3.setOnClickListener {
            val intent = Intent (this, PersonalActivity::class.java)
            startActivity(intent)
        }

        binding.imageButton4.setOnClickListener {
            val intent = Intent (this, PersonalActivity::class.java)
            startActivity(intent)
        }
    }
}