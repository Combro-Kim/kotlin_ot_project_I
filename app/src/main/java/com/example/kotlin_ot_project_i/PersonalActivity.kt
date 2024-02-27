package com.example.kotlin_ot_project_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_ot_project_i.databinding.ActivityPersonalBinding


class PersonalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.personalToolbar.returnBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}