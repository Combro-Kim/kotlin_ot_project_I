package com.example.kotlin_ot_project_i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.PopupMenu
import com.example.kotlin_ot_project_i.databinding.ActivityCreditsBinding

class CreditsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreditsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreditsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.referenceText.movementMethod = ScrollingMovementMethod.getInstance()

        val popupMenu = PopupMenu(applicationContext,binding.creditBar.menuBtn)
        menuInflater.inflate(R.menu.menu_pop_up, popupMenu.menu)
        toolbarFun(binding.creditBar.menuBtn, popupMenu, this, 4)
        returnFun(binding.creditBar.returnBtn, this)

    }
}