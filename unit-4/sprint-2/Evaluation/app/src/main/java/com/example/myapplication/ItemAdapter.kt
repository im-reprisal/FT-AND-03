package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ItemAdapter:RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    private var itemList : ArrayList<Task> = ArrayList()
    fun addItem(itm: MutableList<Task>){
        this.itemList = itm as ArrayList<Task>
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val itm = itemList[position]
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