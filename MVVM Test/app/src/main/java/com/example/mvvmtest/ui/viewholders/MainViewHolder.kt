package com.example.mvvmtest.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmtest.data.models.ResultsDTO
import kotlinx.android.synthetic.main.item_layout.view.*

class MainViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(resultsDTO: ResultsDTO) {
        view.apply {
            Glide.with(this).load(resultsDTO.image).into(ivCharacter)
            tv_name.text = resultsDTO.name
        }
    }
}