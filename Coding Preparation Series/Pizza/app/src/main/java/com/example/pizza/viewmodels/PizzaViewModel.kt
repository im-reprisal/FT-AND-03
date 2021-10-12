package com.example.pizza.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PizzaViewModel(val repository: PizzaRepository): ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getPizza()
        }
    }
    val pizzas: LiveData<PizzaResponse>
        get() = repository.pizzas


}