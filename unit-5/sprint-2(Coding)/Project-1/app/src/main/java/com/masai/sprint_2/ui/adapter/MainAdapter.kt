package com.masai.sprint_2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.masai.sprint_2.R
import com.masai.sprint_2.data.models.PeopleResponseItem
import com.masai.sprint_2.ui.viewholder.MainViewHolder


class MainAdapter : PagingDataAdapter<PeopleResponseItem,MainViewHolder>(diffUtil){
   companion object{
       val diffUtil = object:DiffUtil.ItemCallback<PeopleResponseItem>(){
           override fun areItemsTheSame(
               oldItem: PeopleResponseItem,
               newItem: PeopleResponseItem
           ): Boolean {
               return oldItem.id == newItem.id
           }

           override fun areContentsTheSame(
               oldItem: PeopleResponseItem,
               newItem: PeopleResponseItem
           ): Boolean {
              return oldItem.equals(newItem)
           }

       }
   }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val tvPeopleResponseItem = getItem(position)
        tvPeopleResponseItem?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MainViewHolder(view)
    }
}