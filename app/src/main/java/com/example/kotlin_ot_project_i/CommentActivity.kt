package com.example.kotlin_ot_project_i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_ot_project_i.data.ArticleAdapter
import com.example.kotlin_ot_project_i.data.ItemLayout
import com.example.kotlin_ot_project_i.databinding.ActivityCommentBinding
import com.google.firebase.firestore.FirebaseFirestore

class CommentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentBinding
    val db = FirebaseFirestore.getInstance()
    val itemList = arrayListOf<ItemLayout>()
    val adapter = ArticleAdapter(itemList)


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCommentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        val popupMenu = PopupMenu(applicationContext,binding.creditBar.menuBtn)
        menuInflater.inflate(R.menu.menu_pop_up, popupMenu.menu)
        toolbarFun(binding.creditBar.menuBtn,this ,popupMenu, this, 6)
        returnFun(binding.creditBar.returnBtn, this)

        binding.commentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.commentRecyclerView.adapter = adapter

        binding.resetButton.setOnClickListener {
            db.collection("articles")
                .get()
                .addOnSuccessListener { result ->
                    itemList.clear()
                    for (document in result) {
                        val item = ItemLayout(document["name"] as String, document["comment"] as String)
                        itemList.add(item)
                    }
                    adapter.notifyDataSetChanged() // recyclerVIew 갱신
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "불러오기 실패", Toast.LENGTH_SHORT).show()
                    Log.w("CommentActivity", "Error for: $exception")
                }
        }
        binding.addButton.setOnClickListener {
            commentAdd()

        }
    }

    private fun commentAdd() {
        val builder = AlertDialog.Builder(this)

        val tvName = TextView(this)
        tvName.text = "이름"
        val tvComment = TextView(this)
        tvComment.text = "내용"
        val etName = EditText(this)
        etName.maxLines = 1
        val etComment = EditText(this)
        etName.maxLines = 1
        val mLayout = LinearLayout(this)
        mLayout.orientation = LinearLayout.VERTICAL
        mLayout.setPadding(16)
        mLayout.addView(tvName)
        mLayout.addView(etName)
        mLayout.addView(tvComment)
        mLayout.addView(etComment)
        builder.setView(mLayout)

        builder.setTitle("방명록 추가")
        builder.setPositiveButton("추가") { _, _ ->
            val data = hashMapOf(
                "name" to etName.text.toString(),
                "comment" to etComment.text.toString()
            )
            db.collection("articles")
                .add(data)
                .addOnSuccessListener {
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    Log.w("CommentActivity", "Error for: $exception")
                }
        }
        builder.setNegativeButton("취소") { _, _ ->

        }
        builder.show()
    }
}
