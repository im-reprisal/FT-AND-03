package com.masai.myapplication.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.myapplication.data.models.ResultDTO
import kotlinx.android.synthetic.main.item_layout.view.*

class MainViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(result: ResultDTO){
      view.apply {
          Glide.with(posterImage).load("https://image.tmdb.org/t/p/w500/"+result.posterPath).into(posterImage)
          tvTitle.text = result.title
          tvReleaseDate.text = result.releaseDate
      }
    }
}