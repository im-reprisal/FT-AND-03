package com.example.evaluation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.evaluation.Repository.CartRepository
import com.example.evaluation.local.MyEntity

class CartViewModel(private val repository: CartRepository):ViewModel() {
    fun addItems(taskEntity: MyEntity){
        repository.addItems(taskEntity)
    }
    fun getItems() : LiveData<List<MyEntity>>{
        return repository.getItems()
    }
}