package com.example.my.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my.data.models.Article
import com.example.my.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val mainRepository = MainRepository()
    private val mutableLiveData = MutableLiveData<List<Article>>()
    val liveData : LiveData<List<Article>> = mutableLiveData
    fun callAPI(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getResponseFromAPI()
            mutableLiveData.postValue(response)
        }
    }
}