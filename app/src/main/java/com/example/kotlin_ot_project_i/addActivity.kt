package com.example.kotlin_ot_project_i

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_ot_project_i.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plusButton.setOnClickListener {
            saveData()
            finish()
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


}