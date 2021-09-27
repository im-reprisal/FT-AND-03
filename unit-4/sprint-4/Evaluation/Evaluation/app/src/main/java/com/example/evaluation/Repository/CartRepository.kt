package com.example.evaluation.Repository

import androidx.lifecycle.LiveData
import com.example.evaluation.local.MyDao
import com.example.evaluation.local.MyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartRepository(private val myDao:MyDao) {
    fun addItems(myEntity: MyEntity){
        CoroutineScope(Dispatchers.IO).launch {
            myDao.insertItems(myEntity)
        }
    }
    fun getItems() : LiveData<List<MyEntity>>{
        return myDao.getItems()
    }
}