package com.masai.sprint_2.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sprint_2.data.models.PeopleResponseItem
import kotlinx.android.synthetic.main.item_layout.view.*

class MainViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(peopleResponseItem: PeopleResponseItem){
        view.apply {
            Glide.with(this).load(peopleResponseItem.image.medium).into(iv_person_image)
            tv_person_name.text = peopleResponseItem.name
       //     tv_country_name.text = peopleResponseItem.country.name
            tv_birth_date.text = peopleResponseItem.birthday
            tv_death_date.text = peopleResponseItem.deathday
        }
    }
}