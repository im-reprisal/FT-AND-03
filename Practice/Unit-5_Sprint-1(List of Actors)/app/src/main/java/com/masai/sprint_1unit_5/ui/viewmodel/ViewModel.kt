package com.masai.sprint_1unit_5.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.masai.sprint_1unit_5.data.Repository.Repository
import com.masai.sprint_1unit_5.data.local.MyEntity

class ViewModel(val repository: Repository) : ViewModel(){
    fun getAllData(): LiveData<List<MyEntity>> {
        return repository.getData()
    }

    fun insertData( num:Int){
        repository.insertData1(num)
    }
    fun deleteAllData(){
        repository.deleteAll()
    }
}