package com.example.kotlin_ot_project_i.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_ot_project_i.R

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    private val list = listOf(1, 2, 3, 4)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.nameTextView)
        val birthdayView: TextView = view.findViewById(R.id.birthdayTextView)
        val mbtiView: TextView = view.findViewById(R.id.mbtiTextView)
        val regionView: TextView = view.findViewById(R.id.regionTextView)
        fun bind(position: Int) {
            nameView.text = "TEXT $position"
            birthdayView.text = "TEXT $position"
            mbtiView.text = "TEXT $position"
            regionView.text = "TEXT $position"
        }
    }
}