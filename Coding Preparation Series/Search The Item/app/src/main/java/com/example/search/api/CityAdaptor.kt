package com.example.search.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.search.R
import com.example.search.data.Address
import kotlinx.android.synthetic.main.item_layout.view.*

class CityAdaptor(
    val list: List<Address>) : RecyclerView.Adapter<CityHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CityHolder(view)
    }
    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val cityList = list[position]
        holder.setData(cityList)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class CityHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(address: Address) {
          view.apply {
              tv_id.text = address.id
              tv_City.text = address.city
              tv_Latitude.text = address.latitude.toString()
              tv_Longitude.text = address.longitude.toString()
          }
    }
}