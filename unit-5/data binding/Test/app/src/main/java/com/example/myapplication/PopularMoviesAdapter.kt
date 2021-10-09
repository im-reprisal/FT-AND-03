package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutBinding

class PopularMoviesAdapter(
    private val popularMoviesList: List<Result>) : RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {


    class PopularMoviesViewHolder(private val itemLayoutBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun onBind(resultModel: Result) {
            itemLayoutBinding.popMovieList = resultModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val itemLayoutBinding:ItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_layout,parent,false)
        return PopularMoviesViewHolder(itemLayoutBinding)

    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val resultModel = popularMoviesList[position]
        holder.onBind(resultModel)
    }

    override fun getItemCount(): Int {
        return popularMoviesList.size
    }
}