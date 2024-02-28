package com.example.kotlin_ot_project_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.kotlin_ot_project_i.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainToolbar.menuBtn.setOnClickListener{
            val popupMenu = PopupMenu(applicationContext,it)
            menuInflater.inflate(R.menu.menu_pop_up,popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener{
                when(it.itemId){
                    R.id.go_main -> {
                        Toast.makeText(applicationContext, "이미 메인 화면입니다.", Toast.LENGTH_SHORT).show()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_team -> {
                        val intent = Intent(this, TeamActivity::class.java)
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member1 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",0)
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member2 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",1)
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member3 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",2)
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member4 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",3)
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    else-> return@setOnMenuItemClickListener false

                }
            }

        }

        binding.teamIB.setOnClickListener{
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }
        binding.memberIB1.setOnClickListener{
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 0)
            startActivity(intent)
        }
        binding.memberIB2.setOnClickListener{
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 1)
            startActivity(intent)
        }
        binding.memberIB3.setOnClickListener{
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 2)
            startActivity(intent)
        }
        binding.memberIB4.setOnClickListener{
            val intent = Intent(this, PersonalActivity::class.java)
            intent.putExtra("indexNumber", 3)
            startActivity(intent)

        }
    }
}