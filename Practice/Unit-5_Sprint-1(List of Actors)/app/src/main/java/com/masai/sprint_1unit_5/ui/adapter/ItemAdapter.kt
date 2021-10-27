package com.masai.sprint_1unit_5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.sprint_1unit_5.R
import com.masai.sprint_1unit_5.data.local.MyEntity
import com.masai.sprint_1unit_5.ui.viewholder.ItemViewHolder

class ItemAdapter(var list:ArrayList<MyEntity>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout  ,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val response = list[position]
        holder.setData(response)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}