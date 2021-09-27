package com.example.evaluation.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evaluation.api.PizzaApiService
import com.example.evaluation.models.PizzaResponse

class PizzaRepository(private val pizzaApiService: PizzaApiService) {
    private val pizzaLiveData = MutableLiveData<PizzaResponse>()

    val pizzas:LiveData<PizzaResponse>
    get() = pizzaLiveData

    suspend fun getPizza(){
        val result = pizzaApiService.getPizza()
        if (result?.body() != null){
            pizzaLiveData.postValue(result.body())
        }
    }
}