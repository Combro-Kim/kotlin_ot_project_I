package com.example.kotlin_ot_project_i

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.kotlin_ot_project_i.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val popupMenu = PopupMenu(applicationContext,binding.mainToolbar.menuBtn)
        menuInflater.inflate(R.menu.menu_pop_up, popupMenu.menu)
        toolbarFun(binding.mainToolbar.menuBtn,this, popupMenu, this, 0)
        binding.teamIB.setOnClickListener {
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }
        binding.memberIB1.setOnClickListener {
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 0)
            startActivity(intent)
        }
        binding.memberIB2.setOnClickListener {
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 1)
            startActivity(intent)
        }
        binding.memberIB3.setOnClickListener {
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 2)
            startActivity(intent)
        }
        binding.memberIB4.setOnClickListener {
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 3)
            startActivity(intent)

        }
    }

}
