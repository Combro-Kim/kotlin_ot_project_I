package com.example.kotlin_ot_project_i

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.example.kotlin_ot_project_i.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val teamActivity = TeamActivity.teamActivity
        binding.plusButton.setOnClickListener {
            saveData()
            finish()
        }

        binding.addToolbar.menuBtn.setOnClickListener{
            val popupMenu = PopupMenu(applicationContext,it)
            menuInflater.inflate(R.menu.menu_pop_up,popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener{
                when(it.itemId){
                    R.id.go_main -> {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        finish()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_team -> {
                        finish()
                        return@setOnMenuItemClickListener true
                    }

                    R.id.go_member1 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",0)
                        startActivity(intent)
                        teamActivity.finish()
                        finish()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member2 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",1)
                        startActivity(intent)
                        teamActivity.finish()
                        finish()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member3 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",2)
                        startActivity(intent)
                        teamActivity.finish()
                        finish()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.go_member4 -> {
                        val intent = Intent(this, PersonalActivity::class.java)
                        intent.putExtra("indexNumber",3)
                        startActivity(intent)
                        teamActivity.finish()
                        finish()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.themeMode -> {
                        val items = arrayOf("라이트 모드", "다크 모드", "사용자 지정")
                        val builder = AlertDialog.Builder(this)
                            .setTitle("테마 변경")
                            .setItems(items) { dialog, idx ->
                                if (items[idx] == "라이트 모드") {
                                    changeTheme(AppCompatDelegate.MODE_NIGHT_NO)
                                } else if (items[idx] == "다크 모드") {
                                    changeTheme(AppCompatDelegate.MODE_NIGHT_YES)
                                } else {
                                    changeTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                                }
                            }
                        builder.show()

                        return@setOnMenuItemClickListener true
                    }
                    else-> return@setOnMenuItemClickListener false
                }
            }

        }



        binding.addToolbar.returnBtn.let{
            it.isVisible = true
            it.setOnClickListener{
                finish()
            }
        }



    }

    private fun saveData(){
        with(getSharedPreferences(User_Comment, Context.MODE_PRIVATE).edit()) {
            putString(UserComment1,binding.nameEditText1.text.toString())
            putString(UserComment2,binding.nameEditText2.text.toString())
            putString(UserComment3,binding.nameEditText3.text.toString())
            putString(UserComment4,binding.nameEitText4.text.toString())
            apply()
        }
        Toast.makeText(this,"저장 완료!!",Toast.LENGTH_SHORT).show()
    }
    private fun changeTheme(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}

