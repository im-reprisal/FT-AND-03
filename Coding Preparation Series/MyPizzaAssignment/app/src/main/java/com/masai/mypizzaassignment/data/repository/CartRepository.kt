package com.masai.mypizzaassignment.data.repository

import androidx.lifecycle.LiveData
import com.masai.mypizzaassignment.data.local.MyDao
import com.masai.mypizzaassignment.data.local.MyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartRepository(private val myDao: MyDao) {

    fun addItems(myEntity: MyEntity){
        CoroutineScope(Dispatchers.IO).launch {
            myDao.insertItems(myEntity)
        }
    }
    fun getItems(): LiveData<List<MyEntity>> {
        return myDao.getItems()
    }
    fun totalPrice(): LiveData<Double> {
        return myDao.totalPrice()
    }
}