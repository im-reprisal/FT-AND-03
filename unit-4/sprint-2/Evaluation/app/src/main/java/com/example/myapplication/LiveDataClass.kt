package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class LiveDataClass {
    private var count = 0;
    private val fragMutableData = MutableLiveData<String>()
    private val mediatorLiveData = MediatorLiveData<String>()
    fun incSearchCount() {
        count++
        fragMutableData.value = "Total Search : $count"
    }
    fun getMediatorLiveData(): LiveData<String> {
        mediatorLiveData.addSource(fragMutableData, Observer {
            mediatorLiveData.value = it
        })
        return mediatorLiveData
    }
}