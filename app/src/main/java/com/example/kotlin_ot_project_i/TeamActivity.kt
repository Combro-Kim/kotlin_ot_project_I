package com.example.kotlin_ot_project_i

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.kotlin_ot_project_i.databinding.ActivityTeamBinding

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.teamToolbar.menuBtn.setOnClickListener{
            val popupMenu = PopupMenu(applicationContext,it)
            menuInflater.inflate(R.menu.menu_pop_up,popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener{
                when(it.itemId){
                    R.id.go_main -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
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



        binding.teamToolbar.returnBtn.let{
            it.isVisible = true
            it.setOnClickListener{
                val intent = Intent(this@TeamActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.addButton.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }
        binding.deleteButton.setOnClickListener {
            deleteData()
        }

    }

    override fun onResume() {
        super.onResume()
        getDataUiUpdate()
    }

    private fun getDataUiUpdate() {
        with(getSharedPreferences(User_Comment, Context.MODE_PRIVATE)) {
            binding.valueTextView1.text = getString(UserComment1, "내가 보기에 이 팀원은?")
            binding.valueTextView2.text = getString(UserComment2, "내가 보기에 이 팀원은?")
            binding.valueTextView3.text = getString(UserComment3, "내가 보기에 이 팀원은?")
            binding.valueTextView4.text = getString(UserComment4, "내가 보기에 이 팀원은?")

        }
    }


    private fun deleteData() {
        with(getSharedPreferences(User_Comment, MODE_PRIVATE).edit()) {
            clear()
            apply()
            getDataUiUpdate()
        }
        Toast.makeText(this, "데이터를 삭제했습니다.", Toast.LENGTH_SHORT).show()
    }
}