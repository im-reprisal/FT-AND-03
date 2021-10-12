package com.example.pizza.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class CartViewModel(private val repository: CartRepository) : ViewModel() {

    fun addItems(taskEntity: MyEntity) {
        repository.addItems(taskEntity)
    }

    fun getItems(): LiveData<List<MyEntity>> {
        return repository.getItems()
    }
    fun totalPrice(): LiveData<Double> {
        return repository.totalPrice()
    }

}