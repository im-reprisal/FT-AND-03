package com.masai.mypizzaassignment.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.masai.mypizzaassignment.data.models.PizzaResponse
import com.masai.mypizzaassignment.network.ApiService

class PizzaRepository(private val pizzaApiService:ApiService) {
    private val pizzaLiveData= MutableLiveData<PizzaResponse>()

    val pizzas: LiveData<PizzaResponse>
        get() = pizzaLiveData

    suspend fun getPizza(){
        val result= pizzaApiService.getPizza()
        if (result?.body()!=null){
            pizzaLiveData.postValue(result.body())

        }
    }
}