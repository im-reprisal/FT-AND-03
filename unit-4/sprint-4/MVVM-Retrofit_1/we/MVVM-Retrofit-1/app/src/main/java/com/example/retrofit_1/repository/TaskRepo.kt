package com.example.retrofit_1.repository
import com.example.retrofit_1.models.local.TaskAppDao
import com.example.retrofit_1.models.remote.Network
import com.example.retrofit_1.models.remote.Resource
import com.example.retrofit_1.models.remote.ResponseHandler
import com.example.retrofit_1.models.remote.TasksAPI
import com.example.retrofit_1.models.remote.requests.LoginRequestModel
import com.example.retrofit_1.models.remote.responses.LoginResponse
class TaskRepo(private val taskAppDao: TaskAppDao) {
    private val api: TasksAPI = Network.getRetrofit().create(TasksAPI::class.java)
    private val responseHandler = ResponseHandler()
    suspend fun login(loginRequestModel: LoginRequestModel): Resource<LoginResponse> {
        return try {
            val response = api.login(loginRequestModel)
            responseHandler.handleSuccess(response)
        }
        catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e)
        }
    }
}