package com.masai.sprint_2.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sprint_2.data.models.PeopleResponseItem
import kotlinx.android.synthetic.main.item_layout.view.*

class MainViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(peopleResponseItem: PeopleResponseItem){
        view.apply {
            Glide.with(this).load(peopleResponseItem.image.medium).into(person_image)
        }
    }
}