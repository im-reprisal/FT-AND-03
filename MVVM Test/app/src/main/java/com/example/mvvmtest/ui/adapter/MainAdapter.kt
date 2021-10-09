package com.example.mvvmtest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest.R
import com.example.mvvmtest.data.models.ResultsDTO
import com.example.mvvmtest.ui.viewholders.MainViewHolder

class MainAdapter(private val charactersList: List<ResultsDTO>) :
    RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, pos: Int) {
        val resultsDTO = charactersList[pos]
        holder.setData(resultsDTO)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}