package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class DataClass {
    private var countA = 0;
    private var countB = 0;
    private val fragAMutableData = MutableLiveData<String>()
    private val fragBMutableData = MutableLiveData<String>()
    private val mediatorLiveData = MediatorLiveData<String>()
    fun incFragACount() {
        countA++
        fragAMutableData.value = "FragmentA : $countA"
    }
    fun incFragBCount() {
        countB++
        fragBMutableData.value = "FragmentB : $countB"
    }
    fun getMediatorLiveData(): LiveData<String> {
        mediatorLiveData.addSource(fragAMutableData, Observer {
            mediatorLiveData.value = it
        })

        mediatorLiveData.addSource(fragBMutableData, Observer {
            mediatorLiveData.value = it
        })
        return mediatorLiveData
    }
}