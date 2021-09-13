package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ItemAdapter.ItemViewHolder

class ItemAdapter (val context:Context,val taskList:MutableList<Task>):RecyclerView.Adapter<ItemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val task = taskList.get(position)
        holder.itemName.text = task.itemname
        holder.price.text = task.price.toString()
        holder.desc.text = task.desc
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         var itemName : TextView
         var price : TextView
         var desc : TextView
         init {
             itemName = itemView.findViewById(R.id.tvItemName)
             price = itemView.findViewById(R.id.tvPrice)
             desc = itemView.findViewById(R.id.tvDesc)
         }
    }
}