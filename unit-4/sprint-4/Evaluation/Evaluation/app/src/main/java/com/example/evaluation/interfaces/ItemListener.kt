package com.example.evaluation.interfaces

import com.example.evaluation.adapter.PizzaAdapter
import com.example.evaluation.models.Crust
import com.example.evaluation.views.MainActivity

interface ItemListener {
    fun addCartItems(name:String,size:String,crust:String,price:Double)
}