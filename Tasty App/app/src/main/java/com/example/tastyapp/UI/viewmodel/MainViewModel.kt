package com.example.TastyApp.UI.viewmodel

import androidx.lifecycle.*
import com.example.TastyApp.DATA.repository.FoodRepository
import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.DATA.model.Result

class MainViewModel(val repo: FoodRepository) : ViewModel() {

    fun getData(): LiveData<List<Result>> {
        return repo.getDataFromApi()
    }

    fun getDetail(int: Int): MutableLiveData<ItemX> {
        return repo.getDetailFromApi(int)
    }
}

class ViewModelFactory(repo: FoodRepository) : ViewModelProvider.Factory {
    val repo = FoodRepository()
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}