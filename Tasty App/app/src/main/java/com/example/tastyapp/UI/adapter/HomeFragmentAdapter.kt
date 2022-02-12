package com.example.TastyApp.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.DATA.model.Result
import com.example.TastyApp.R
import com.example.TastyApp.INTERFACE.OnClickListener
import kotlinx.android.synthetic.main.item_layout.view.*

class HomeFragmentAdapter(
    val multipleRecyclerViewList : ArrayList<Result>,
    val onItemClick: OnClickListener
) :
    RecyclerView.Adapter<HomeFragmentAdapter.MultipleRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleRecyclerViewHolder {
        return MultipleRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MultipleRecyclerViewHolder, position: Int) {
        holder.setData(multipleRecyclerViewList[position], onItemClick)
    }

    override fun getItemCount(): Int = multipleRecyclerViewList.size

    class MultipleRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(result: Result, onItemClick_1: OnClickListener) {
            itemView.apply {
                tvHeading.text = result.name
                if (result.items != null)
                    nestedRecyclerView.apply {
                        adapter = MultipleItemListAdapter(
                            result.items as ArrayList<ItemX>,
                            onItemClick_1
                        )
                        layoutManager = LinearLayoutManager(
                            itemView.context,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    }
            }
        }
    }
}
