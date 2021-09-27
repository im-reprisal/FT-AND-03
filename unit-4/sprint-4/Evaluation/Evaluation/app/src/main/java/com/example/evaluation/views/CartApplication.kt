package com.example.evaluation.views

import android.app.Application
import com.example.evaluation.Repository.CartRepository
import com.example.evaluation.local.MyDatabase

class CartApplication:Application() {
    private val myDao by lazy {
        val roomDatabase = MyDatabase.getDatabase(this)
        roomDatabase.getMyDao()
    }
    val repository : CartRepository by lazy {
        CartRepository(myDao)
    }
}