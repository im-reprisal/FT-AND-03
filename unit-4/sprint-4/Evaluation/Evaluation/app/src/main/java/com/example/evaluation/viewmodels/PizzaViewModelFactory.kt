package com.example.evaluation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.evaluation.Repository.PizzaRepository

class PizzaViewModelFactory(private val repository: PizzaRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return PizzaViewModel(repository) as T
    }
}