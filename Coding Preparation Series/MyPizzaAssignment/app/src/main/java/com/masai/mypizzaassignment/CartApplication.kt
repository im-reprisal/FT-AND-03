package com.masai.mypizzaassignment

import android.app.Application
import com.masai.mypizzaassignment.data.local.MyDatabase
import com.masai.mypizzaassignment.data.repository.CartRepository

class CartApplication : Application() {
    private val myDao by lazy {
        val roomDatabase = MyDatabase.getDatabase(this)
        roomDatabase.getMyDao()
    }
    val repository: CartRepository by lazy {
        CartRepository(myDao)
    }
}