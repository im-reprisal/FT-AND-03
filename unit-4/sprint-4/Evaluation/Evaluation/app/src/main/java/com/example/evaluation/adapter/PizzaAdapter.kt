package com.example.evaluation.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluation.R
import com.example.evaluation.interfaces.ItemListener
import com.example.evaluation.models.Crust
import com.example.evaluation.views.MainActivity

class PizzaAdapter(val context: MutableList<Crust>, var pizzaList: MainActivity, val listener: ItemListener) :
    RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.pizza_item_layout, parent, false)
        return PizzaViewHolder(view1)
    }
    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val task = pizzaList[position]
        holder.name.text = task.name
        holder.desc.text = task.description
        holder.price.text = task.name
    }
    override fun getItemCount(): Int {
        return pizzaList.size
    }
    class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var desc: TextView
        var price: TextView

        init {
            name = itemView.findViewById(R.id.tvName)
            desc = itemView.findViewById(R.id.tvDescription)
            price = itemView.findViewById(R.id.tvPrice)
        }
    }
}