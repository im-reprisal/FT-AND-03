package com.example.TastyApp.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.R
import com.example.TastyApp.INTERFACE.OnClickListener
import kotlinx.android.synthetic.main.fooditem_view.view.*

class MultipleItemListAdapter(val foodItemList:ArrayList<ItemX>, val onFoodItemClick : OnClickListener): RecyclerView.Adapter<MultipleItemListAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fooditem_view,parent,false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.setData(foodItemList[position],onFoodItemClick)
    }

    override fun getItemCount(): Int {
        return foodItemList.size
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      fun setData(itemX: ItemX, onCardClicklistner: OnClickListener) {
          itemView.apply {
              Glide.with(food_image).load(itemX.thumbnail_url).into(food_image)
              food_name.text = itemX.name
              cardViewItem.setOnClickListener {
                  onCardClicklistner.onClick(itemX)
              }
          }
      }
    }
}