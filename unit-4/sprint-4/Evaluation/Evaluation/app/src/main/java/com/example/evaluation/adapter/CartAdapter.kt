package com.example.evaluation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluation.R
import com.example.evaluation.local.MyEntity
import kotlinx.android.synthetic.main.pizza_item_layout.view.*

class CartAdapter(var cartList: List<MyEntity>) : RecyclerView.Adapter<CartAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pizza_item_layout, parent, false)
        return PizzaViewHolder(view)
    }
    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val currentCartList = cartList[position]
        holder.itemView.apply {
            tvName.text=currentCartList.name
            tvPrice.text= currentCartList.price.toString()
            tvDescription.text=currentCartList.desc
        }
    }
    override fun getItemCount() = cartList.size

}