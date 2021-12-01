package com.example.my.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.my.data.OnCardClicked
import com.example.my.data.models.Article
import kotlinx.android.synthetic.main.item_layout.view.*

class MainViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(article: Article){
        view.apply {
            Glide.with(this).load(article.urlToImage).into(iv_article_image)
            tv_Title.text = article.title
            tv_Date.text = article.publishedAt
            tv_Description.text = article.description
        }
    }
}