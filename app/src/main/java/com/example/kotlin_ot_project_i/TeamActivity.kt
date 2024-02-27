package com.example.kotlin_ot_project_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        val btn_return = findViewById<ImageView>(R.id.returnBtn)

        btn_return.setOnClickListener{
            val intent = Intent(this@TeamActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}