package com.example.pizza.views

import android.app.Application

class CartApplication : Application() {
    private val myDao by lazy {
        val roomDatabase = MyDatabase.getDatabase(this)
        roomDatabase.getMyDao()
    }
    val repository: CartRepository by lazy {
        CartRepository(myDao)
    }
}