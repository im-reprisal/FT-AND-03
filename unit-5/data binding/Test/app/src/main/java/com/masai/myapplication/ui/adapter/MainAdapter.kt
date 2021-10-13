package com.masai.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.myapplication.R
import com.masai.myapplication.data.models.ResultDTO
import com.masai.myapplication.ui.viewholder.MainViewHolder

class MainAdapter(private val movieList: List<ResultDTO>):RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val resultList = movieList[position]
        holder.setData(resultList)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
}