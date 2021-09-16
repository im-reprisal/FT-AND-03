package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
class TaskViewHolder(itemView: View, var listener: onItemClick) : RecyclerView.ViewHolder(itemView) {
    fun setData(dataModel: TaskModel){
        itemView.apply {

            tvAmount.text = dataModel.amount.toString()
            tvDesc.text = dataModel.desc

            btnDelete.setOnClickListener{
                listener.onDeleteClicked(dataModel)
            }
            btnEdit.setOnClickListener{
                listener.onEditClicked(dataModel)
            }
        }
    }
}