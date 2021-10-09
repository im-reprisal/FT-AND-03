package com.example.mvvmtest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtest.MainUIModel
import com.example.mvvmtest.data.models.ResponseDTO
import com.example.mvvmtest.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val mainRepository = MainRepository()
    private val mutableLiveData = MutableLiveData<MainUIModel>()
    val liveData: LiveData<MainUIModel> = mutableLiveData

    fun callApi() {
        CoroutineScope(IO).launch {
            val response: ResponseDTO = mainRepository.getAllCharacters()
            if (response != null) {
                mutableLiveData.postValue(MainUIModel.OnSuccess(response))
            } else {
                mutableLiveData.postValue(MainUIModel.onFailure("Error"))
            }
        }
    }
}