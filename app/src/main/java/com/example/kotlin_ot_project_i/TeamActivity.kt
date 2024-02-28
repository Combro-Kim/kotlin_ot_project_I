package com.example.kotlin_ot_project_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_ot_project_i.databinding.ActivityTeamBinding


class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.teamToolbar.returnBtn.setOnClickListener{
            val intent = Intent(this@TeamActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}