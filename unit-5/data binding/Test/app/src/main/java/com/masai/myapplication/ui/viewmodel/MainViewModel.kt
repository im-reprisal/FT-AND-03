package com.masai.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masai.myapplication.data.models.ResultDTO
import com.masai.myapplication.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val mainRepository = MainRepository()
    private val mutablelivedata = MutableLiveData<List<ResultDTO>>()
    val liveData: LiveData<List<ResultDTO>> = mutablelivedata
    fun callAPi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getResponseFromAPI()
            mutablelivedata.postValue(response)
        }
    }
}