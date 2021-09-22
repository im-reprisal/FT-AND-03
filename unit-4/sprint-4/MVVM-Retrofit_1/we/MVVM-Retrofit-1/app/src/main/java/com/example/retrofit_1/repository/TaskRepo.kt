package com.example.retrofit_1.repository

import androidx.lifecycle.LiveData
import com.example.retrofit_1.models.local.Task
import com.example.retrofit_1.models.local.TaskAppDao
import com.example.retrofit_1.models.remote.Network
import com.example.retrofit_1.models.remote.Resource
import com.example.retrofit_1.models.remote.ResponseHandler
import com.example.retrofit_1.models.remote.TasksAPI
import com.example.retrofit_1.models.remote.requests.LoginRequestModel
import com.example.retrofit_1.models.remote.responses.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TaskRepo(private val taskAppDao: TaskAppDao) {

    private val api: TasksAPI = Network.getRetrofit().create(TasksAPI::class.java)
    private val responseHandler = ResponseHandler()

    //as it will take some time so that's we are marking it as suspend function
    suspend fun login(loginRequestModel: LoginRequestModel): Resource<LoginResponse> {
        return try {
            val response = api.login(loginRequestModel)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e) //passing exception here
        }
    }

    // this operation should be happened in the bg thread
    fun addTaskToRoom(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.addTask(task)
        }
    }


    //returning the live data of list
    fun getAllTask(): LiveData<List<Task>> {
        return taskAppDao.getTasks()
    }

    fun updateTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.updateTask(task)
        }
    }


    fun deleteTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.delete(task)
        }
    }
}