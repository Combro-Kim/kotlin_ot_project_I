package com.example.kotlin_ot_project_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_ot_project_i.databinding.ActivityPersonalIntroduceBinding

class PersonalIntroduceActivity : AppCompatActivity() {
    private val nameOfTeam = listOf(
        R.string.name1,
        R.string.name2,
        R.string.name3,
        R.string.name4
    )
    private val hobbyOfTeam = listOf(
        R.string.hobby1,
        R.string.hobby2,
        R.string.hobby3,
        R.string.hobby4
    )
    private val mbtiOfTeam = listOf(
        R.string.mbti1,
        R.string.mbti2,
        R.string.mbti3,
        R.string.mbti4
    )
    private val birthdayOfTeam = listOf(
        R.string.birthday1,
        R.string.birthday2,
        R.string.birthday3,
        R.string.birthday4
    )
    private val workOfTeam = listOf(
        R.string.work1,
        R.string.work2,
        R.string.work3,
        R.string.work4
    )
    private val momentOfTeam = listOf(
        R.string.moment1,
        R.string.moment2,
        R.string.moment3,
        R.string.moment4
    )
    private val goalOfTeam = listOf(
        R.string.goal1,
        R.string.goal2,
        R.string.goal3,
        R.string.goal4
    )
    private val resolveOfTeam = listOf(
        R.string.resolve1,
        R.string.resolve2,
        R.string.resolve3,
        R.string.resolve4
    )
    private lateinit var binding: ActivityPersonalIntroduceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalIntroduceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idx = intent.getIntExtra("indexNumber",0)

        binding.ivPersonal.setImageResource(resources.getIdentifier("pic${idx+1}","drawable",packageName))
        binding.personalNameText.text = getString(nameOfTeam[idx])
        binding.hobbyText.text = getString(hobbyOfTeam[idx])
        binding.mbtiText.text = getString(mbtiOfTeam[idx])
        binding.birthdayText.text = getString(birthdayOfTeam[idx])
        binding.momentText.text = getString(momentOfTeam[idx])
        binding.goalText.text = getString(goalOfTeam[idx])
        binding.resolveText.text = getString(resolveOfTeam[idx])

        binding.personalToolbar.returnBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}