package com.example.my.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my.R
import com.example.my.data.OnCardClicked
import com.example.my.data.models.Article
import com.example.my.ui.viewholder.MainViewHolder

class MainAdapter(private val articleList : List<Article>): RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val resultList = articleList[position]
        holder.setData(resultList)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}