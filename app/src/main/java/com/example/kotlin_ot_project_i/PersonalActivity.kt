package com.example.kotlin_ot_project_i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlin_ot_project_i.databinding.ActivityPersonalBinding

class PersonalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idxOfToolbar = intent.getIntExtra("indexNumber", 0)
        val popupMenu = PopupMenu(applicationContext, binding.personalToolbar.menuBtn)
        menuInflater.inflate(R.menu.menu_pop_up, popupMenu.menu)
        toolbarFun(binding.personalToolbar.menuBtn, popupMenu, this, 2, idx = idxOfToolbar)
        returnFun(binding.personalToolbar.returnBtn, this)

        binding.viewPager.adapter = if (idxOfToolbar == 0) {
            indicator(getImageList1())
            ViewPagerAdapter(getImageList1())
        } else if (idxOfToolbar == 1) {
            indicator(getImageList2())
            ViewPagerAdapter(getImageList2())
        } else if (idxOfToolbar == 2) {
            indicator(getImageList3())
            ViewPagerAdapter(getImageList3())
        } else {
            indicator(getImageList4())
            ViewPagerAdapter(getImageList4())
        }

        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.personalNameText.text = getString(nameOfTeam[idxOfToolbar])
        binding.hobbyText.text = getString(hobbyOfTeam[idxOfToolbar])
        binding.mbtiText.text = getString(mbtiOfTeam[idxOfToolbar])
        binding.birthdayText.text = getString(birthdayOfTeam[idxOfToolbar])
        binding.momentText.text = getString(momentOfTeam[idxOfToolbar])
        binding.goalText.text = getString(goalOfTeam[idxOfToolbar])
        binding.resolveText.text = getString(resolveOfTeam[idxOfToolbar])
        binding.roleText.text = getString(roleOfTeam[idxOfToolbar])


    }

    private fun indicator(list: ArrayList<Int>) {
        val pagerAdapter = ViewPagerAdapter(list)
        binding.viewPager.adapter = pagerAdapter
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    private fun getImageList1(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.pic55, R.drawable.pic88, R.drawable.pic66)
    }

    private fun getImageList2(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.pic2, R.drawable.pic2_2, R.drawable.pic2_3)
    }

    private fun getImageList3(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.pic3, R.drawable.pic3_2, R.drawable.pic3_3)
    }

    private fun getImageList4(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.pic4, R.drawable.pic4_2, R.drawable.pic4_3)
    }

    //todo
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
    private val roleOfTeam = listOf(
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
}
