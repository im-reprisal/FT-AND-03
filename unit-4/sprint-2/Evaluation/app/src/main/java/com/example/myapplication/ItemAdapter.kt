package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ItemAdapter(val itemList: List<Task>, tasksList: MutableList<Task>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val itm:Task = itemList[position]
        holder.bindView(itm)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class ItemViewHolder(var view : View) : RecyclerView.ViewHolder(view){
        private var itemName = view.findViewById<TextView>(R.id.tvItemName)
        private var price = view.findViewById<TextView>(R.id.tvPrice)
        private var desc = view.findViewById<TextView>(R.id.tvDesc)
        fun bindView(itm:Task){
            itemName.text = itm.itemname.toString()
            price.text = itm.price.toString()
            desc.text = itm.desc.toString()
        }
    }
}