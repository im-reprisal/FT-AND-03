package com.example.TastyApp.DATA.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.TastyApp.REMOTE.Network
import com.example.TastyApp.DATA.model.ItemX
import com.example.TastyApp.DATA.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class FoodRepository{
    val listOfDataLiveData = MutableLiveData<List<Result>>()
    val detailsOfDataLiveData = MutableLiveData<ItemX>()
    fun getDataFromApi(): LiveData<List<Result>> {
        CoroutineScope(IO).launch {
            try {
                val list = Network.api.getData().results
                listOfDataLiveData.postValue(list)
            } catch (e: Exception) {
            }
        }
        return listOfDataLiveData
    }

    fun getDetailFromApi(int: Int): MutableLiveData<ItemX> {
        CoroutineScope(IO).launch {
            detailsOfDataLiveData.postValue(Network.api.getDetail(int))
        }
        return detailsOfDataLiveData
    }
}
