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

        binding.teamIB.setOnClickListener{
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }
        binding.memberIB1.setOnClickListener{
            val intent = Intent(this, PersonalIntroduceActivity::class.java)
            intent.putExtra("indexNumber", 0)
            startActivity(intent)
        }
        binding.memberIB2.setOnClickListener{
            val intent = Intent(this, PersonalIntroduceActivity::class.java)
            intent.putExtra("indexNumber", 1)
            startActivity(intent)
        }
        binding.memberIB3.setOnClickListener{
            val intent = Intent(this, PersonalIntroduceActivity::class.java)
            intent.putExtra("indexNumber", 2)
            startActivity(intent)
        }
        binding.memberIB4.setOnClickListener{
            val intent = Intent(this, PersonalIntroduceActivity::class.java)
            intent.putExtra("indexNumber", 3)
            startActivity(intent)
        }
    }
}