package com.example.kotlin_ot_project_i

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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