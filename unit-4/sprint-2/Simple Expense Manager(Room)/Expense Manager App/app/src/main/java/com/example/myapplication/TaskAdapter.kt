package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val context: Context, val list : MutableList<TaskModel>, var listener: onItemClick): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false),listener)
    }
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.setData(list[position])
    }
    override fun getItemCount(): Int {
        return list.size
    }
}