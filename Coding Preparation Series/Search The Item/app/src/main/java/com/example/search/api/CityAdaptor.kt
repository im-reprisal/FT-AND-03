package com.example.search.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.search.R
import com.example.search.data.Address

class CityAdaptor(
    val list: List<Address>) : RecyclerView.Adapter<CityHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CityHolder(view)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val City_List = list[position]
        holder.setData(City_List)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class CityHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(address: Address) {

    }
}