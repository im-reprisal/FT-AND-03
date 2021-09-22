package com.example.retrofit_1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofit_1.models.remote.Resource
import com.example.retrofit_1.models.remote.requests.LoginRequestModel
import com.example.retrofit_1.models.remote.responses.LoginResponse
import com.example.retrofit_1.repository.TaskRepo

import kotlinx.coroutines.Dispatchers

class TaskViewModel(val repo: TaskRepo) : ViewModel() {

    fun userLogin(loginRequestModel: LoginRequestModel): LiveData<Resource<LoginResponse>> {
        val livedata =  liveData(Dispatchers.IO){
            val result = repo.login(loginRequestModel)
            emit(result)
        }
        return livedata
    }
}