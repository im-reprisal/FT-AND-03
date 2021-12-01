package com.example.my.data

import com.example.my.data.models.Article

interface OnCardClicked {
    fun onCardClicked(article: Article)
}