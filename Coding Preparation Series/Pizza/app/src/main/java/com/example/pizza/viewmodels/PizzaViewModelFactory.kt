package com.example.pizza.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PizzaViewModelFactory(private val repository: PizzaRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PizzaViewModel(repository) as T
    }
}