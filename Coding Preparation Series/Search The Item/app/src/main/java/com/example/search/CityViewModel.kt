package com.example.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.search.data.ResponseModel

import com.example.search.repository.CityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel  : ViewModel() {

    private val cityRepo = CityRepository()
    private val mutableLiveData = MutableLiveData<MainUiModel>()
    val liveData: LiveData<MainUiModel> = mutableLiveData

    fun getData(query: String) : LiveData<ResponseModel>{
        CoroutineScope(Dispatchers.IO).launch {
            val repo = cityRepo.getAllCities(query)
            if (repo != null) {
                mutableLiveData.postValue(MainUiModel.OnSuccess(repo))
            } else {
                mutableLiveData.postValue(MainUiModel.OnFailure("Error"))
            }
        }
        return liveData(Dispatchers.IO) {
            val data = cityRepo.getAllCities(query)
            emit(data)
        }
    }
}