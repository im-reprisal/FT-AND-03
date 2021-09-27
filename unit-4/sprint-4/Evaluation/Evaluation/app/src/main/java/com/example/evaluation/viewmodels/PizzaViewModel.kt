package com.example.evaluation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluation.Repository.PizzaRepository
import com.example.evaluation.models.PizzaResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(val repository: PizzaRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getPizza()
        }
    }
    val pizzas:LiveData<PizzaResponse>
    get() = repository.pizzas
}