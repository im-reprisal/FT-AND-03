package com.masai.mypizzaassignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masai.mypizzaassignment.data.models.PizzaResponse
import com.masai.mypizzaassignment.data.repository.PizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(val repository: PizzaRepository): ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getPizza()
        }
    }
    val pizzas: LiveData<PizzaResponse>
        get() = repository.pizzas


}