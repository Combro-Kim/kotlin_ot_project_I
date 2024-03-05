package com.example.kotlin_ot_project_i

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import kotlin.Int as Int


const val User_Comment = "userComment"
const val UserComment1 = "userComment1"
const val UserComment2 = "userComment2"
const val UserComment3 = "userComment3"
const val UserComment4 = "userComment4"

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun returnFun(view: View, activity: Activity){
    view.isVisible = true
    view.setOnClickListener{
        activity.finish()
    }
}


// pageNumber -> main: 0 team: 1 personal: 2 add: 3 credit: 4 calendar: 5 comment: 6

fun toolbarFun(menu:View, popupMenu : PopupMenu, activity: Activity, pageNumber: Int, idx: Int = -1){
    menu.setOnClickListener{
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.go_main -> {
                    if(pageNumber == 0) {
                        showToast(activity, "이미 메인 화면입니다.")
                    }
                    else {
                        val intent = Intent(activity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(activity, intent, null)
                    }
                    return@setOnMenuItemClickListener true
                }

                R.id.go_team -> {
                    if(pageNumber == 1){
                        showToast(activity, "이미 팀 소개 화면입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, TeamActivity::class.java)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }


                R.id.go_member1 -> {
                    if(pageNumber == 2 && idx == 0) {
                        showToast(activity, "이미 보고 있는 팀원입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, PersonalActivity::class.java)
                        intent.putExtra("indexNumber", 0)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }

                R.id.go_member2 -> {
                    if(pageNumber == 2 && idx == 1) {
                        showToast(activity, "이미 보고 있는 팀원입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, PersonalActivity::class.java)
                        intent.putExtra("indexNumber", 1)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }

                R.id.go_member3 -> {
                    if(pageNumber == 2 && idx == 2) {
                        showToast(activity, "이미 보고 있는 팀원입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, PersonalActivity::class.java)
                        intent.putExtra("indexNumber", 2)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }

                R.id.go_member4 -> {
                    if(pageNumber == 2 && idx == 3) {
                        showToast(activity, "이미 보고 있는 팀원입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, PersonalActivity::class.java)
                        intent.putExtra("indexNumber", 3)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }

                R.id.themeMode -> {
                    val items = arrayOf("라이트 모드", "다크 모드", "사용자 지정")
                    val builder = AlertDialog.Builder(activity)
                        .setTitle("테마 변경")
                        .setItems(items) { dialog, id ->
                            if (items[id] == "라이트 모드") {
                                changeTheme(AppCompatDelegate.MODE_NIGHT_NO)
                            } else if (items[id] == "다크 모드") {
                                changeTheme(AppCompatDelegate.MODE_NIGHT_YES)
                            } else {
                                changeTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                            }
                        }
                    builder.show()

                    return@setOnMenuItemClickListener true
                }

                R.id.go_maker -> {
                    if(pageNumber == 4){
                        showToast(activity, "이미 Credits 화면입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, CreditsActivity::class.java)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }
                R.id.go_calendar -> {
                    if(pageNumber == 5){
                        showToast(activity, "이미 일정 화면입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, CalendarActivity::class.java)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }
                R.id.go_comment -> {
                    if(pageNumber == 6){
                        showToast(activity, "이미 방명록 화면입니다.")
                    }
                    else {
                        if (pageNumber == 3) {
                            val intent2 = Intent(activity, MainActivity::class.java)
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(activity, intent2, null)
                        }
                        val intent = Intent(activity, CommentActivity::class.java)
                        startActivity(activity, intent, null)
                        if (pageNumber != 0) activity.finish()
                    }
                    return@setOnMenuItemClickListener true
                }
                else -> return@setOnMenuItemClickListener false
            }
        }
    }
}
fun changeTheme(mode: Int) {
    AppCompatDelegate.setDefaultNightMode(mode)
}