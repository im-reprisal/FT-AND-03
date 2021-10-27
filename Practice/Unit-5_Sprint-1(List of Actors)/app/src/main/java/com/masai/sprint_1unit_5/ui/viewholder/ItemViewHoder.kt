package com.masai.sprint_1unit_5.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sprint_1unit_5.data.local.MyEntity
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(responseModelItem: MyEntity){
        itemView.apply {
            itemName.text = "Name: ${responseModelItem.name}"
            itemBirthday.text = "Birthday: ${responseModelItem.birthDay}"
            itemDeathday.text = "Death-day: ${responseModelItem.deathday}"
            Glide.with(itemImage).load(responseModelItem.imageUrl).into(itemImage)
            itemCountryName.text = "Country Name: ${responseModelItem.countryName}"
            itemCountryCode.text = "Country Code: ${responseModelItem.countryCode}"
            itemCountryTimeZone.text = "Country Time-zone: ${responseModelItem.timeZone}"
        }
    }
}