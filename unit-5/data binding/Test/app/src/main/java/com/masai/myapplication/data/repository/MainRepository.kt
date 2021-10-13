package com.masai.myapplication.data.repository

import com.masai.myapplication.data.models.ResponseDTO
import com.masai.myapplication.data.models.ResultDTO
import com.masai.myapplication.network.ServiceGenerator

class MainRepository {
     suspend fun getResponseFromAPI(): List<ResultDTO> {
        return ServiceGenerator.getApiService().getAPIResponse().results
    }
}