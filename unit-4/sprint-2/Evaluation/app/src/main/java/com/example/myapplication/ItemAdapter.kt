package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ItemAdapter(val itm: List<Task>, val taskList: MutableList<Task>) :
    RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemHolder(view)
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        var itm: Task = taskList[position]
        holder.tvProductName.text = itm.itemname
        holder.tvPrice.text = itm.price.toString()
        holder.tvDesc.text = itm.desc
    }
    override fun getItemCount(): Int {
        return taskList.size
    }
}
class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvProductName: TextView
    var tvPrice: TextView
    var tvDesc:TextView
    init {
        tvProductName = view.findViewById(R.id.tvItemName)
        tvPrice = view.findViewById(R.id.tvPrice)
        tvDesc = view.findViewById(R.id.tvDesc)
    }
}